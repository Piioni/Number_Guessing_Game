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
        } while (difficulty != 0);

        switch (difficulty) {
            case 1:
                playGame(10);
                break;
            case 2:
                playGame(5);
                break;
            case 3:
                playGame(3);
                break;
            default:
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
        }

    }

    public static void playGame(int i) {


    }
}

