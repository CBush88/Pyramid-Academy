import java.util.*;

public class Hangman {
    private final List<String> word;
    private final List<String> lettersGuessed;
    private int guesses = 0;
    private final String secret;

    Hangman(String[] words){
        this.word = Arrays.asList(words[(int) (Math.random() * words.length)].split(""));
        this.lettersGuessed = new ArrayList<>();
        this.secret = word.stream().reduce("", (s, t) -> s + t);
    }

    public int getGuesses() {
        return guesses;
    }

    public void incrementGuesses() {
        this.guesses++;
    }

    public List<String> getLettersGuessed() {
        return lettersGuessed;
    }

    public int winCheck(){
        if(guesses >= 6){
            return -1;
        }else if(new HashSet<>(lettersGuessed).containsAll(word)){
            return 1;
        }else{
            return 0;
        }
    }

    public boolean checkLastLetter() {
        return (word.contains(lettersGuessed.get(lettersGuessed.size() - 1)));
    }

    @Override
    public String toString() {
        String str = "Word: " + word.stream().map(s -> (lettersGuessed.contains(s))? s : "-")
                .reduce("", (s, t) -> s + t) + "\n";
        str += "Missed Letters: " + lettersGuessed.stream().filter(s -> !word.contains(s))
                .reduce("", (s, t) -> s + t) + "\n";

        return str;
    }

    public String getSecret() {
        return secret;
    }
    public void guess(Scanner input) throws Exception {
        String letter = input.next().toLowerCase().substring(0, 1);
        if (lettersGuessed.contains(letter)) {
            throw new Exception("You guessed that letter already!");
        }
        if (Character.isAlphabetic(letter.charAt(0))) {
            lettersGuessed.add(letter);
        } else {
            throw new Exception("Guess a letter");
        }
    }
}
