package wordAnagram.plain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WordAnagramGame {
    private static final String WELCOME_MESSAGE = "アナグラムゲームへようこそ！";
    private static final String PROMPT_QUESTION_MESSAGE = "次の文字を元に戻してください: %s\n";
    private static final String PROMPT_INPUT_MESSAGE = "\n答えを入力してください: ";
    private static final String CORRECT_MESSAGE = "正解です！おめでとうございます！";
    private static final String INCORRECT_MESSAGE = "不正解です。もう一度挑戦してください！";
    private static final String GAME_OVER_MESSAGE = "\nゲームを終了します。お疲れ様でした！";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 単語リストを準備
        String[] words = {"apple", "banana", "cherry", "grape", "orange"};
        List<String> wordList = Arrays.asList(words);

        // ランダムに単語を選択
        Collections.shuffle(wordList);
        String selectedWord = wordList.get(0); // 最初の単語を選択

        // 単語をシャッフルしてアナグラムを生成
        List<String> shuffledWordList = Arrays.asList(selectedWord.split(""));
        Collections.shuffle(shuffledWordList);
        String shuffledWord = String.join("", shuffledWordList);

        // ゲームの説明とアナグラムの表示
        System.out.println(WELCOME_MESSAGE);
        System.out.printf(PROMPT_QUESTION_MESSAGE, shuffledWord);

        boolean isCorrect = false;

        while (!isCorrect) {
            // プレイヤーの解答を取得
            System.out.print(PROMPT_INPUT_MESSAGE);
            String playerAnswer = scanner.nextLine();

            // 正解判定
            if (playerAnswer.equalsIgnoreCase(selectedWord)) {
                System.out.println(CORRECT_MESSAGE);
                isCorrect = true;
            } else {
                System.out.println(INCORRECT_MESSAGE);
            }
        }

        // ゲーム終了メッセージ
        System.out.println(GAME_OVER_MESSAGE);
        scanner.close();
    }
}
