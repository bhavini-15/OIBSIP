import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final int MAX_ATTEMPTS = 10;
    private static final int MAX_ROUNDS = 3;

    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int totalScore = 0;
3
        System.out.println("NUMBER GUESSING GAME");
        System.out.println("Total Number of Rounds: " + MAX_ROUNDS);
        System.out.println("Attempts to Guess the Number in Each Round: " + MAX_ATTEMPTS);

        for (int i = 1; i <= MAX_ROUNDS; i++) {
            int number = random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.printf("Round %d: Guess the number between %d and %d. You have %d attempts.\n", i, MIN_RANGE, MAX_RANGE, MAX_ATTEMPTS);

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                int guessNumber = sc.nextInt();
                attempts++;

                if (guessNumber == number) {
                    int score = MAX_ATTEMPTS - attempts + 1;
                    totalScore += score;
                    System.out.printf("Hurray! Number guessed successfully in %d attempts. Round score: %d\n", attempts, score);
                    hasGuessedCorrectly = true;
                    break;
                } else if (guessNumber < number) {
                    System.out.printf("The number is greater than %d. Attempts left: %d\n", guessNumber, MAX_ATTEMPTS - attempts);
                } else {
                    System.out.printf("The number is less than %d. Attempts left: %d\n", guessNumber, MAX_ATTEMPTS - attempts);
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.printf("Round %d over. You've used all attempts. The correct number was %d.\n\n", i, number);
            }
        }

        System.out.printf("GAME OVER. TOTAL SCORE = %d\n", totalScore);
        sc.close();
    }
}
