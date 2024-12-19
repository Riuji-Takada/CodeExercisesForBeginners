package wordAnagram.commentRich;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WordAnagramGame {
    // ゲーム開始時に表示されるメッセージ
    private static final String WELCOME_MESSAGE = "アナグラムゲームへようこそ！";
    // プレイヤーに提示するアナグラムの問題文
    private static final String PROMPT_QUESTION_MESSAGE = "次の文字を元に戻してください: %s\n";
    // プレイヤーに解答を促すメッセージ
    private static final String PROMPT_INPUT_MESSAGE = "\n答えを入力してください: ";
    // 正解時に表示されるメッセージ
    private static final String CORRECT_MESSAGE = "正解です！おめでとうございます！";
    // 不正解時に表示されるメッセージ
    private static final String INCORRECT_MESSAGE = "不正解です。もう一度挑戦してください！";
    // ゲーム終了時に表示されるメッセージ
    private static final String GAME_OVER_MESSAGE = "\nゲームを終了します。お疲れ様でした！";

    public static void main(String[] args) {
        // ユーザーからの入力を受け取るためのスキャナーを作成
        Scanner scanner = new Scanner(System.in);

        // ゲームに使用する単語リスト。アナグラムの対象となる単語はここから選ばれる。
        String[] words = {"apple", "banana", "cherry", "grape", "orange"};
        List<String> wordList = Arrays.asList(words);

        // 単語リストをシャッフルしてランダムに選ばれた単語を使用する
        // シャッフルすることで、毎回異なる単語が選ばれ、ゲームがランダム性を持つようにする
        Collections.shuffle(wordList);
        // シャッフルされたリストから最初の単語を選択
        String selectedWord = wordList.get(0);

        // 選ばれた単語を1文字ずつに分割し、シャッフルすることでアナグラムを作成
        // ユーザーが解答するための文字の並び替え問題を作成
        List<String> shuffledWordList = Arrays.asList(selectedWord.split(""));
        Collections.shuffle(shuffledWordList);
        // シャッフルされた文字を再結合してアナグラムを生成
        String shuffledWord = String.join("", shuffledWordList);

        // ゲームの開始メッセージを表示
        System.out.println(WELCOME_MESSAGE);
        // シャッフルされた単語（アナグラム）をプレイヤーに提示
        System.out.printf(PROMPT_QUESTION_MESSAGE, shuffledWord);

        // プレイヤーの答えが正解かどうかを判定するフラグ
        boolean isCorrect = false;

        // プレイヤーが正解するまでループ
        while (!isCorrect) {
            // ユーザーに入力を促すメッセージを表示
            System.out.print(PROMPT_INPUT_MESSAGE);
            // プレイヤーの入力を受け取る
            String playerAnswer = scanner.nextLine();

            // プレイヤーの入力と正解を比較する（大文字・小文字を区別しない）
            // ここでは `equalsIgnoreCase` を使用して、ユーザーが大文字・小文字を間違えても正解と判定する
            if (playerAnswer.equalsIgnoreCase(selectedWord)) {
                // 正解の場合、正解メッセージを表示
                System.out.println(CORRECT_MESSAGE);
                isCorrect = true; // 正解したのでループを終了
            } else {
                // 不正解の場合、不正解メッセージを表示
                System.out.println(INCORRECT_MESSAGE);
            }
        }

        // ゲーム終了メッセージを表示
        System.out.println(GAME_OVER_MESSAGE);
        // スキャナーを閉じる（リソースの解放）
        scanner.close();
    }
}