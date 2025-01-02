import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");

        int difficulty = 0;
        do {
            try {
                System.out.println("Please enter the difficulty level");
                System.out.println("1. Easy (10 guesses)");
                System.out.println("2. Medium (5 guesses)");
                System.out.println("3. Hard (3 guesses)");
                System.out.print("Enter your choice: ");
                difficulty = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
                sc.nextLine();
            }
        } while (difficulty < 1 || difficulty > 3);

        switch (difficulty) {
            case 1:
                System.out.println("You've chosen Easy. You have 10 guesses!");
                System.out.println("Let's start the game!, Good Luck!");
                playGame(10);
                break;
            case 2:
                System.out.println("Great you've chosen Medium. You have 5 guesses!");
                System.out.println("Let's start the game!, Good Luck!");
                playGame(5);
                break;
            case 3:
                System.out.println("You're brave! You've chosen Hard. You have 3 guesses!");
                System.out.println("Let's start the game!, Good Luck!");
                playGame(3);
                break;
            default:
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
        }



    }

    public static void playGame(int i) {
        int tries = 0;
        int number = (int) (Math.random() * 100) + 1;
        Scanner sc = new Scanner(System.in);
        boolean hasWon = false;
        while (tries < i) {
            System.out.println("Please enter your guess: ");
            try {
                int guess = sc.nextInt();
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
                sc.nextLine();
            }


        }
        if (hasWon) {
            System.out.println("Congratulations! You've guessed the correct number in " + tries + " tries.");
        } else {
            System.out.println("Game Over! The correct number was " + number);
        }
    }
}
