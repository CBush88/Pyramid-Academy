import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean replay;
        String name;
        Scanner input = new Scanner(System.in);

        System.out.println("Hello! What is your name?");
        name = getName(input);

        do {
            int number, guess;
            int guesses = 0;

            number = getRandom();

            System.out.printf("Well, %s, I am thinking of a number between 1 and 20.%n", name);

            do {
                System.out.println("Take a guess");
                guess = getGuess(input);
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
            replay = replay(input);

        }while(replay);
    }

    public static String getName(Scanner input){
        String name;
        while(true) {
            try{
                name = input.next();
                if(name.matches("[A-Za-z]*")) {
                    break;
                }else{
                    throw new Exception("Your name needs to be all letters");
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
                input.nextLine();
            }
        }
        return name;
    }

    public static int getRandom(){
        Random random = new Random();

        return random.nextInt(20) + 1;
    }

    public static int getGuess(Scanner input){
        int guess;

        while (true) {
            try {
                guess = input.nextInt();
                if(guess > 0 && guess <= 20){
                    break;
                }else{
                    throw new Exception("Number must be between 1 and 20");
                }
            } catch (Exception e) {
                if(e instanceof InputMismatchException) {
                    System.out.println("Guess a number");
                }else{
                    System.out.println("Exception caught: " + e.getMessage());
                }
                input.nextLine();
            }
        }
        return guess;
    }

    public static boolean replay(Scanner input){
        char response;
        while(true) {
            try {
                response = input.next().toLowerCase().charAt(0);
                if(response == 'y' || response == 'n'){
                    return (response == 'y');
                } else {
                    throw new Exception("Exception caught: Answer must be y or n");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        }
    }
}