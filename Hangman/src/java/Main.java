import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] words = {"cat", "dog", "bird", "apple", "banana", "orange"};

        do {
            ArrayList<String> hangman;
            int guesses = 0;
            ArrayList<String> lettersGuessed = new ArrayList<>();
            ArrayList<String> word = getWord(words);
            String secret = "";

            for(String s : word){
                secret += s;
            }

            System.out.println("HANGMAN");
            do {
                hangman = getHangman(guesses);
                for (String s : hangman) {
                    System.out.println(s);
                }

                System.out.print("Missed Letters: ");
                for (var c : lettersGuessed) {
                    if (!word.contains(c)) {
                        System.out.print(c);
                    }
                }
                System.out.println();

                for (String s : word) {
                    if (lettersGuessed.contains(s)) {
                        System.out.print(s);
                    } else {
                        System.out.print("-");
                    }
                }
                System.out.println();

                System.out.println("Enter a guess");

                while (true) {
                    try {
                        getGuess(input, lettersGuessed);
                        if (!word.contains(lettersGuessed.get(lettersGuessed.size() - 1))) {
                            guesses++;
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

            } while (guesses < 6 && !checkWin(word, lettersGuessed));

            hangman = getHangman(guesses);
            for (String s : hangman) {
                System.out.println(s);
            }

            System.out.println(checkWin(word, lettersGuessed) ? "You win!" : "You lose!");
            System.out.printf("The secret word was %s!\n", secret);
            System.out.println("Would you like to play again? (Yes / No)");

        }while(input.next().toLowerCase().charAt(0) != 'n');
    }

    public static ArrayList<String> getWord(String[] words){
        Random random = new Random();
        String choice = words[random.nextInt(words.length)];
        ArrayList<String> word = new ArrayList<>(Arrays.asList(choice.split("")));

        return word;
    }
    public static ArrayList<String> getHangman(int guesses){
        ArrayList<String> hangman = new ArrayList<>();
        hangman.add(" +---+");

        hangman.add((guesses == 0) ? "     |" : " O   |");

        if(guesses < 2){
            hangman.add("     |");
        }else if(guesses <= 4){
            hangman.add(" |   |");
        }else if(guesses == 5){
            hangman.add("/|   |");
        }else{
            hangman.add("/|\\  |");
        }

        if(guesses < 3) {
            hangman.add("     |");
        }else if(guesses == 3){
            hangman.add("/    |");
        }else {
            hangman.add("/ \\  |");
        }

        hangman.add("    ===");

        return hangman;
    }
    public static void getGuess(Scanner input, ArrayList<String> guesses) throws Exception {
        String guess = input.next().substring(0,1);
        if(Character.isAlphabetic(guess.charAt(0)) && !guesses.contains(guess)){
            guesses.add(guess);
        }else if(guesses.contains(guess)){
            throw new Exception("You already guessed that letter");
        }else{
            throw new Exception("Guess a letter");
        }
    }
    public static boolean checkWin(ArrayList<String> word, ArrayList<String> lettersGuessed){
        return lettersGuessed.containsAll(word);
    }
}