import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int attempts = 0;
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to Guess the Number!");
        
        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int guess;
            boolean guessedCorrectly = false;

            System.out.println("I'm thinking of a number between " + minRange + " and " + maxRange);
            
            while (!guessedCorrectly) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number correctly in " + attempts + " attempts.");
                    score += 100 - (attempts * 2); // Score calculation based on attempts
                    guessedCorrectly = true;
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (!guessedCorrectly && attempts >= 10) {
                    System.out.println("Sorry, you've used all your attempts. The number was " + randomNumber + ".");
                    break;
                }
            }

            System.out.println("Your score: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.next();

            if (!playChoice.equalsIgnoreCase("yes")) {
                playAgain = false;
            } else {
                attempts = 0; // Reset attempts for the next game
            }
        }

        System.out.println("Thanks for playing Guess the Number!");
        scanner.close();
    }
}

