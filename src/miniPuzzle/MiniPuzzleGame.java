package miniPuzzle;

import java.util.Random;
import java.util.Scanner;

public class MiniPuzzleGame {
    private static final int MAX_RANDOM_NUMBER = 10;

    private static final String WELCOME_MESSAGE = "ミニ謎解きゲームへようこそ！";
    private static final String QUESTION_MESSAGE = "問題: %d %s %d は？\n";
    private static final String INPUT_MESSAGE = "答えを入力してください: ";
    private static final String CORRECT_MESSAGE = "正解です！";
    private static final String INCORRECT_MESSAGE = "不正解です。もう一度挑戦してください！\n";
    private static final String[] OPERATORS = {"+", "-", "*", "/"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println(WELCOME_MESSAGE);

        // ランダムに2つの数字を生成
        int num1 = random.nextInt(MAX_RANDOM_NUMBER) + 1;
        int num2 = random.nextInt(MAX_RANDOM_NUMBER) + 1;

        // ランダムに演算子を選択
        String operator = OPERATORS[random.nextInt(OPERATORS.length)];

        // 演算に基づいて正解を計算
        int correctAnswer = 0;
        switch (operator) {
            case "+":
                correctAnswer = num1 + num2;
                break;
            case "-":
                correctAnswer = num1 - num2;
                break;
            case "*":
                correctAnswer = num1 * num2;
                break;
            case "/":
                // 商は小数点以下を切り捨てて、整数として扱う
                correctAnswer = num1 / num2;
                break;
        }

        // 問題を表示
        System.out.printf(QUESTION_MESSAGE, num1, operator, num2);

        boolean isCorrectAnswer = false;
        // 正解するまで繰り返し入力を促す
        while (!isCorrectAnswer) {
            System.out.print(INPUT_MESSAGE);
            int playerAnswer = scanner.nextInt();

            // プレイヤーの入力が正解かどうかを判定
            if (playerAnswer == correctAnswer) {
                System.out.println(CORRECT_MESSAGE);
                isCorrectAnswer = true;
            } else {
                System.out.println(INCORRECT_MESSAGE);
            }
        }

        scanner.close();
    }
}