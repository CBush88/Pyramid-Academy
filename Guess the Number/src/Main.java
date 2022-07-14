import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char replay;
        String name = "";
        Scanner input = new Scanner(System.in);

        //loop to catch exception and require input
        while(name.isBlank()) {
            System.out.println("Hello! What is your name?");
            try{
                name = input.next();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        //loop to replay
        do {
            Random random = new Random();
            int number, guess;
            int guesses = 0;


            number = random.nextInt(20) + 1;

            System.out.printf("Well, %s, I am thinking of a number between 1 and 20.%n", name);

            //loop for each guess
            do {
                //reinitialize for the loop
                guess = -1;
                boolean guessValidated = false;
                System.out.println("Take a guess");

                //input loop requires an integer
                while (!guessValidated) {

                    try {
                        guess = Integer.parseInt(input.next());
                        guessValidated = true;
                    } catch (Exception e) {
                        System.out.println("Caught Number Format Exception " + e.getMessage());
                        System.out.println("Guess a number");
                    }
                }
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
            //loop to require y or n answer
            do {
                System.out.println("Would you like to play again? (y or n)");
                try {
                    replay = input.next().toLowerCase().charAt(0);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                    //guarantees replay gets set to something
                    replay = '1';
                }
            }while(replay != 'y' && replay != 'n');
        }while(replay == 'y');
    }
}