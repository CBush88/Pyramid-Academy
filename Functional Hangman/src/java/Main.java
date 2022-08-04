import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String[] words = {"cat", "dog", "bird", "apple", "banana", "orange"};
        File fileIn = new File("src/files/input.txt");
        File fileOut = new File("src/files/output.txt");
        Scanner input = new Scanner(System.in);
        char playAgain = 'y';
        Hangman hangman = new Hangman(words);

        System.out.println("What's your name?");
        String playerName = input.next();
        int score = 0;

        while (playAgain != 'n') {
            if(playAgain == 'y') {

                if (hangman.winCheck() == 1) {
                    score++;
                    writeOutput(fileOut, playerName, score);
                    System.out.println(getHighScore(fileOut, playerName, score));
                }
                if (hangman.winCheck() != 0) {
                    hangman = new Hangman(words);
                }
                System.out.println("HANGMAN");
                try (Scanner fileReader = new Scanner(fileIn)) {
                    printHangman(hangman.getGuesses(), fileReader);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println(hangman);

                System.out.println("Enter a guess!");
                try {
                    if (hangman.winCheck() == 0) {
                        getGuess(hangman.getLettersGuessed(), input);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    continue;
                }

                if (!hangman.checkLastLetter()) {
                    hangman.incrementGuesses();
                }
            }
            if (hangman.winCheck() != 0) {
                try (Scanner fileReader = new Scanner(fileIn)) {
                    printHangman(hangman.getGuesses(), fileReader);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                if (hangman.winCheck() == 1) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lose!");
                }

                System.out.println("The secret word was: " + hangman.getSecret());
                System.out.println("Play again? (Y/N)");
                playAgain = input.next().toLowerCase().charAt(0);
            }
        }
        if(hangman.winCheck() == 1){
            score++;
        }
        writeOutput(fileOut, playerName, score);
        System.out.println(getHighScore(fileOut, playerName, score));
    }

    public static void printHangman(int guesses, Scanner fileReader) {
        List<String> hangman = Arrays.asList(fileReader.nextLine().split(";")[guesses].split(","));
        hangman.forEach(System.out::println);
    }

    public static void getGuess(List<String> lettersGuessed, Scanner input) throws Exception {
        String letter = input.next().toLowerCase().substring(0, 1);
        if (lettersGuessed.contains(letter)) {
            throw new Exception("You guessed that letter already!");
        }
        if (Character.isAlphabetic(letter.charAt(0))) {
            lettersGuessed.add(letter);
        } else {
            throw new Exception("Enter a letter");
        }
    }
    public static void writeOutput(File fileOut, String playerName, int score){
        try{
            //no loops
            List<String> lines = Files.readAllLines(Paths.get(fileOut.getPath()));
            //add all lines not associated with player name for output
            String output = lines.stream().filter(s -> !s.contains(playerName)).map(s -> s + "\n").collect(Collectors.joining());
            //if player is in file
            if(lines.stream().filter(s -> s.contains(playerName)).collect(Collectors.joining()).contains(playerName)) {
                //if old score is less than new score
                if(Integer.parseInt(lines.stream().filter(s -> s.contains(playerName)).map(s -> s.substring(s.indexOf(':') + 2)).collect(Collectors.joining())) <= score) {
                    //update with new score
                    output += lines.stream().filter(s -> s.contains(playerName)).map(s -> s.substring(0, s.indexOf(':') + 2) + (score)).collect(Collectors.joining());
                }else{
                    //keep old score
                    output += lines.stream().filter(s -> s.contains(playerName)).collect(Collectors.joining());
                }
            }else {
                //add new user to score list
                output += playerName + ": " + score + "\n";
            }
            Files.write(Paths.get(fileOut.getPath()), output.getBytes());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static String getHighScore(File fileOut, String playerName, int score){
        try{
            List<String> lines = Files.readAllLines(Paths.get(fileOut.getPath()));
            String highScore = String.valueOf(lines.stream().max(Comparator.comparingInt(s -> Integer.parseInt(s.substring(s.indexOf(':') + 2)))));
            int scoreInt = Integer.parseInt(highScore.substring(highScore.indexOf(':') + 2, highScore.indexOf(']')));
            String scoreName = highScore.substring(highScore.indexOf('[') + 1, highScore.indexOf(':'));

            if(scoreName.equals(playerName) && scoreInt <= score){
                return String.format("You currently have the high score with %d consecutive wins!", score);
            }else{
                return String.format("%s has the high score of: %d consecutive wins.", scoreName, scoreInt);
            }
        }catch(Exception e){
            return e.getMessage();
        }
    }
}