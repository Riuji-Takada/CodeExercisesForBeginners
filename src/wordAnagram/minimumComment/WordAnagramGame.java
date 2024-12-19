package wordAnagram.minimumComment;

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
    private static final List<String> WORD_LIST = Arrays.asList("apple", "banana", "cherry", "grape", "orange");

    public static void main(String[] args) {
        // Scannerを自動クローズするためにtry-with-resourcesを使用
        try (Scanner scanner = new Scanner(System.in)) {
            String selectedWord = selectRandomWord();
            String shuffledWord = shuffleWord(selectedWord);

            System.out.println(WELCOME_MESSAGE);
            System.out.printf(PROMPT_QUESTION_MESSAGE, shuffledWord);

            boolean isCorrect = false;

            while (!isCorrect) {
                String playerAnswer = readPlayerInput(scanner);
                isCorrect = checkAnswer(playerAnswer, selectedWord);
                provideFeedback(isCorrect);
            }

            System.out.println(GAME_OVER_MESSAGE);
        }
    }

    private static String selectRandomWord() {
        // リストの要素をシャッフルして先頭のものを返すことでランダムな単語を選択
        Collections.shuffle(WORD_LIST);
        return WORD_LIST.get(0);
    }

    private static String shuffleWord(String word) {
        // 文字列を1文字ずつに分解し、シャッフルして再結合することでアナグラムを作成
        List<String> splittedWord = Arrays.asList(word.split(""));
        Collections.shuffle(splittedWord);
        return String.join("", splittedWord);
    }

    private static String readPlayerInput(Scanner scanner) {
        System.out.print(PROMPT_INPUT_MESSAGE);
        return scanner.nextLine();
    }

    private static boolean checkAnswer(String playerAnswer, String correctAnswer) {
        // 大文字・小文字が違っている場合でも正解とするためにequalsIgnoreCaseを使用
        return playerAnswer.equalsIgnoreCase(correctAnswer);
    }

    private static void provideFeedback(boolean isCorrect) {
        if (isCorrect) {
            System.out.println(CORRECT_MESSAGE);
        } else {
            System.out.println(INCORRECT_MESSAGE);
        }
    }
}