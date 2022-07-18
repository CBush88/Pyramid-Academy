import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean replay;
        String name;
        Scanner input = new Scanner(System.in);

        System.out.println("Hello! What is your name?");

        //name validation loop
        while(true) {
            try {
                name = getName(input);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        //game loop
        do {
            int number, guess;
            int guesses = 0;

            number = getRandom();

            System.out.printf("Well, %s, I am thinking of a number between 1 and 20.%n", name);

            //loop for up to 6 guesses
            do {
                System.out.println("Take a guess");

                //guess validation loop
                while(true) {
                    try {
                        guess = getGuess(input);
                        break;
                    }catch(Exception e){
                        if(e instanceof InputMismatchException){
                            System.out.println("Guess a number.");
                        }else{
                            System.out.println(e.getMessage());
                        }
                        input.nextLine();
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
            System.out.println("Would you like to play again? (y or n)");

            //replay validation loop
            while(true) {
                try {
                    replay = replay(input);
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

        }while(replay);
    }

    public static String getName(Scanner input) throws Exception {
        String name;
        name = input.next();
        if(name.matches("[A-Za-z]*")) {
            return name;
        }else{
            throw new Exception("Your name needs to be all letters");
        }
    }

    public static int getRandom(){
        Random random = new Random();

        return random.nextInt(20) + 1;
    }

    public static int getGuess(Scanner input) throws Exception {
        int guess;

        guess = input.nextInt();
        if(guess > 0 && guess <= 20){
            return guess;
        }else{
            throw new Exception("Number must be between 1 and 20");
        }
    }

    public static boolean replay(Scanner input) throws Exception {
        char response;

        response = input.next().toLowerCase().charAt(0);
        if(response == 'y' || response == 'n'){
            return (response == 'y');
        } else {
            throw new Exception("Answer must be y or n");
        }
    }
}