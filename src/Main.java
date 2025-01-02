import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc_main = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");

        int difficulty = getDifficulty();
        playGame(difficulty);

        boolean playAgain = true;
        while (playAgain) {
            System.out.println("Do you want to play again? (yes/no)");
            String play = sc_main.next();
            if (play.equalsIgnoreCase("no")) {
                playAgain = false;
            } else {
                System.out.println("Do you want to change the difficulty? (yes/no)");
                String change = sc_main.next();
                if (change.equalsIgnoreCase("yes")) {
                    difficulty = getDifficulty();
                    playGame(difficulty);
                } else {
                    playGame(difficulty);
                }
            }
        }
        sc_main.close();
    }


    public static int getDifficulty() {
        int difficulty = 0;
        Scanner sc_dificultad = new Scanner(System.in);
        do {
            try {
                System.out.println("Please enter the difficulty level");
                System.out.println("1. Easy (10 guesses)");
                System.out.println("2. Medium (5 guesses)");
                System.out.println("3. Hard (3 guesses)");
                System.out.print("Enter your choice: ");
                difficulty = sc_dificultad.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
                sc_dificultad.nextLine();
            }
        } while (difficulty < 1 || difficulty > 3);
        return difficulty;
    }

    public static void playGame(int difficulty) {
        int guesses = 0;
        switch (difficulty) {
            case 1:
                System.out.println("You've chosen Easy. You have 10 guesses!");
                System.out.println("Let's start the game!, Good Luck!");
                guesses = 10;
                break;
            case 2:
                System.out.println("Great you've chosen Medium. You have 5 guesses!");
                System.out.println("Let's start the game!, Good Luck!");
                guesses = 5;
                break;
            case 3:
                System.out.println("You're brave! You've chosen Hard. You have 3 guesses!");
                System.out.println("Let's start the game!, Good Luck!");
                guesses = 3;
                break;
            default:
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
        }

        int tries = 0;
        int number = (int) (Math.random() * 100) + 1;
        Scanner sc_game = new Scanner(System.in);
        boolean hasWon = false;
        long startTime = System.currentTimeMillis(); // Tiempo de inicio

        while (tries < guesses) {
            System.out.println("Please enter your guess: ");
            try {
                int guess = sc_game.nextInt();
                tries++;
                if (guess < number) {
                    System.out.println("Your guess is too low.");
                } else if (guess > number) {
                    System.out.println("Your guess is too high.");
                } else {
                    hasWon = true;
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 100.");
                sc_game.nextLine();
            }
        }

        long endTime = System.currentTimeMillis(); // Tiempo de finalización
        long timeTaken = endTime - startTime; // Tiempo total en milisegundos

        if (hasWon) {
            System.out.println("Congratulations! You've guessed the correct number in " + tries + " tries.");
        } else {
            System.out.println("Game Over! The correct number was " + number);
        }
        System.out.println("You took " + (timeTaken / 1000) + " seconds to finish the game.");


    }
}
