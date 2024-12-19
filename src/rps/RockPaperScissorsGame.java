package rps;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {
    private static final String[] HANDS = { "グー", "チョキ", "パー" };
    private static final int ROCK = 0;
    private static final int SCISSORS = 1;
    private static final int PAPER = 2;

    private static final String WELCOME_MESSAGE = "じゃんけん勝負";
    private static final String INSTRUCTION_MESSAGE = "グーチョキパーを数字で入力してください";
    private static final String HAND_OPTIONS_MESSAGE = "%d:%s\n";
    private static final String PLAYER_INPUT_MESSAGE = "\n最初はぐー、じゃんけん：";
    private static final String COMPUTER_CHOICE_MESSAGE = "コンピュータ：%s";
    private static final String PLAYER_CHOICE_MESSAGE = "プレイヤー　：%s";
    private static final String DRAW_MESSAGE = "引き分けです！";
    private static final String WIN_MESSAGE = "あなたの勝ち！";
    private static final String LOSE_MESSAGE = "あなたの負け...";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // ゲーム開始メッセージを表示
        System.out.println(WELCOME_MESSAGE);
        System.out.println(INSTRUCTION_MESSAGE);

        // ジャンケンの手を表示
        for (int i = 0; i < HANDS.length; i++) {
            System.out.printf(HAND_OPTIONS_MESSAGE, i, HANDS[i]);
        }

        // プレイヤーの手を入力
        System.out.print(PLAYER_INPUT_MESSAGE);
        int playerChoice = scanner.nextInt();

        // コンピュータの手をランダムに決定
        int computerChoice = random.nextInt(HANDS.length);

        // プレイヤーとコンピュータの手を表示
        System.out.println(String.format(COMPUTER_CHOICE_MESSAGE, HANDS[computerChoice]));
        System.out.println(String.format(PLAYER_CHOICE_MESSAGE, HANDS[playerChoice]));

        // 勝敗判定
        if (playerChoice == computerChoice) {
            // 引き分け
            System.out.println(DRAW_MESSAGE);
        } else if ((playerChoice == ROCK && computerChoice == SCISSORS) ||
                (playerChoice == SCISSORS && computerChoice == PAPER) ||
                (playerChoice == PAPER && computerChoice == ROCK)) {
            // プレイヤーの勝ち
            System.out.println(WIN_MESSAGE);
        } else {
            // プレイヤーの負け
            System.out.println(LOSE_MESSAGE);
        }

        // リソースを解放
        scanner.close();
    }
}