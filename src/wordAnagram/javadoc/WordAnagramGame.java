package wordAnagram.javadoc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/** 単語アナグラムゲームクラス */
public class WordAnagramGame {
    /** ゲーム開始時に表示されるメッセージ */
    private static final String WELCOME_MESSAGE = "アナグラムゲームへようこそ！";
    /** プレイヤーに提示するアナグラムの問題文 */
    private static final String PROMPT_QUESTION_MESSAGE = "次の文字を元に戻してください: %s\n";
    /** プレイヤーに解答を促すメッセージ */
    private static final String PROMPT_INPUT_MESSAGE = "\n答えを入力してください: ";
    /** 正解時に表示されるメッセージ */
    private static final String CORRECT_MESSAGE = "正解です！おめでとうございます！";
    /** 不正解時に表示されるメッセージ */
    private static final String INCORRECT_MESSAGE = "不正解です。もう一度挑戦してください！";
    /** ゲーム終了時に表示されるメッセージ */
    private static final String GAME_OVER_MESSAGE = "\nゲームを終了します。お疲れ様でした！";
    /** 出題対象の単語リスト */
    private static final List<String> WORD_LIST = Arrays.asList("apple", "banana", "cherry", "grape", "orange");

    /**
     * ゲームのエントリーポイント。プレイヤーにアナグラム問題を提示し、正解を求めます。
     * 正解するまでプレイヤーに入力を促し、正解後にゲーム終了メッセージを表示します。
     *
     * @param args コマンドライン引数（使用しません）
     */
    public static void main(String[] args) {
        // Scannerを自動クローズするためにtry-with-resourcesを使用
        try (Scanner scanner = new Scanner(System.in)) {
            String selectedWord = selectRandomWord();
            String shuffledWord = shuffleWord(selectedWord);

            System.out.println(WELCOME_MESSAGE);
            System.out.printf(PROMPT_QUESTION_MESSAGE, shuffledWord);

            boolean isCorrect = false;

            // プレイヤーが正解するまで繰り返すループ
            while (!isCorrect) {
                String playerAnswer = readPlayerInput(scanner);
                isCorrect = checkAnswer(playerAnswer, selectedWord);
                provideFeedback(isCorrect);
            }

            System.out.println(GAME_OVER_MESSAGE);
        }
    }

    /**
     * 単語リストからランダムに単語を選択します。
     * 
     * @return ランダムに選ばれた単語
     */
    private static String selectRandomWord() {
        // リストの要素をシャッフルして先頭のものを返すことでランダムな単語を選択
        Collections.shuffle(WORD_LIST);
        return WORD_LIST.get(0);
    }

    /**
     * 与えられた単語をシャッフルし、アナグラムを作成します。
     * 
     * @param word シャッフルする元の単語
     * @return シャッフル後のアナグラム
     */
    private static String shuffleWord(String word) {
        // 文字列を1文字ずつに分解し、シャッフルして再結合することでアナグラムを作成
        List<String> splittedWord = Arrays.asList(word.split(""));
        Collections.shuffle(splittedWord);
        return String.join("", splittedWord);
    }

    /**
     * プレイヤーの入力を読み取ります。
     * 
     * @param scanner 入力を受け取るためのScannerオブジェクト
     * @return プレイヤーの入力した文字列
     */
    private static String readPlayerInput(Scanner scanner) {
        System.out.print(PROMPT_INPUT_MESSAGE);
        return scanner.nextLine();
    }

    /**
     * プレイヤーの入力が正解かどうかを判定します。
     * 大文字・小文字の違いを無視して比較します。
     * 
     * @param playerAnswer プレイヤーの入力
     * @param correctAnswer 正解の単語
     * @return 正解ならtrue、それ以外ならfalse
     */
    private static boolean checkAnswer(String playerAnswer, String correctAnswer) {
        // 大文字・小文字が違っている場合でも正解とするためにequalsIgnoreCaseを使用
        return playerAnswer.equalsIgnoreCase(correctAnswer);
    }

    /**
     * プレイヤーの入力に対してフィードバックを提供します。
     * 正解なら「正解です！」、不正解なら「不正解です！」を表示します。
     * 
     * @param isCorrect 入力が正解かどうか
     */
    private static void provideFeedback(boolean isCorrect) {
        if (isCorrect) {
            System.out.println(CORRECT_MESSAGE);
        } else {
            System.out.println(INCORRECT_MESSAGE);
        }
    }
}