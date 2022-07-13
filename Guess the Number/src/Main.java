import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char replay;
        String name;

        Scanner input = new Scanner(System.in);
        System.out.println("Hello! What is your name?");
        name = input.nextLine();


        do {
            input = new Scanner(System.in);
            Random random = new Random();
            int number, guess;
            int guesses = 0;



            number = random.nextInt(20) + 1;

            System.out.printf("Well, %s, I am thinking of a number between 1 and 20.%n", name);

            do {
                System.out.println("Take a guess");
                guess = input.nextInt();
                guesses++;

                switch (Integer.compare(guess, number)) {
                    case 1:
                        System.out.println("Your guess is too high.");
                        break;
                    case -1:
                        System.out.println("Your guess is too low.");
                        break;
                    default:
                        System.out.printf("Good job, %s! You guessed my number in " +
                                "%d %s%n", name, guesses, (guesses > 1) ? "guesses!" : "guess!");

                }
            } while (guesses < 6 && guess != number);
            if (guess != number) {
                System.out.printf("Sorry, %s, but you lose.%n", name);
            }
            do {
                System.out.println("Would you like to play again?");
                replay = input.next().toLowerCase().charAt(0);
            }while(replay != 'y' && replay != 'n');
        }while(replay == 'y');
    }
}