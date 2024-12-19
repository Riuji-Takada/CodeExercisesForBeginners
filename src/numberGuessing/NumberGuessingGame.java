package numberGuessing;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int ANSWER_RANGE_MIN = 1;
    private static final int ANSWER_RANGE_MAX = 100;

    private static final String WELCOME_MESSAGE = "数当てゲームへようこそ！";
    private static final String INSTRUCTION_MESSAGE = "%dから%dまでの数字を当ててください。\n\n";
    private static final String PLAYER_GUESS_INPUT_MESSAGE = "数字を入力してください: ";
    private static final String CORRECT_MESSAGE = "正解です！おめでとうございます！\n";
    private static final String ATTEMPTS_MESSAGE = "試行回数:%d回%n";
    private static final String HIGHER_HINT_MESSAGE = "正解はもっと大きい数字です！\n";
    private static final String LOWER_HINT_MESSAGE = "正解はもっと小さい数字です！\n";
    private static final String GAME_OVER_MESSAGE = "ゲームを終了します。お疲れ様でした！";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // ゲームの開始メッセージと説明を表示
        System.out.println(WELCOME_MESSAGE);
        System.out.printf(INSTRUCTION_MESSAGE, ANSWER_RANGE_MIN, ANSWER_RANGE_MAX);

        // ランダムに正解の数字を生成
        int targetNumber = random.nextInt(ANSWER_RANGE_MAX - ANSWER_RANGE_MIN + 1) + ANSWER_RANGE_MIN;
        // 試行回数カウント
        int attempts = 0;
        boolean isCorrect = false;

        // ユーザーが正解を入力するまで繰り返し
        while (!isCorrect) {
            System.out.print(PLAYER_GUESS_INPUT_MESSAGE);

            // ユーザーの入力を取得
            int userGuess = scanner.nextInt();
            attempts++;

            // 正解判定
            if (userGuess == targetNumber) {
                System.out.println(CORRECT_MESSAGE);
                System.out.printf(ATTEMPTS_MESSAGE, attempts);
                isCorrect = true;
            } else if (userGuess < targetNumber) {
                // 正解がもっと大きい場合
                System.out.println(HIGHER_HINT_MESSAGE);
            } else {
                // 正解がもっと小さい場合
                System.out.println(LOWER_HINT_MESSAGE);
            }
        }

        System.out.println(GAME_OVER_MESSAGE); // ゲーム終了メッセージを表示
        scanner.close();
    }
}