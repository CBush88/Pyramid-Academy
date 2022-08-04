import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {
Hangman hangman;
String[] words = {"dog", "bird"};
    @BeforeEach
    void setUp() {
        hangman = new Hangman(words);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getGuesses() {
        assertEquals(0, hangman.getGuesses(), "Guesses didn't properly return");
    }

    @Test
    void incrementGuesses() {
        assertEquals(0, hangman.getGuesses(), "Bad initial guesses");
        hangman.incrementGuesses();
        assertEquals(1, hangman.getGuesses(), "Incrementing isn't properly working");
    }

    @Test
    void getLettersGuessed() throws Exception {
        assertEquals(0, hangman.getLettersGuessed().size(), "Should be empty");
        hangman.guess(new Scanner("s"));
        assertTrue(hangman.getLettersGuessed().contains("s"), "Should contain the guess");
    }

    @Test
    void winCheck() throws Exception {
        assertEquals(0, hangman.winCheck(), "Should be 0, game still going");
        for(String s : hangman.getSecret().split("")){
            hangman.guess(new Scanner(s));
        }
        assertEquals(1, hangman.winCheck(), "Should be a win");
        hangman = new Hangman(words);
        for(int i = 0; i < 6; i++){
            hangman.incrementGuesses();
        }
        assertEquals(-1, hangman.winCheck());
    }

    @Test
    void checkLastLetter() throws Exception {
        hangman.guess(new Scanner("d"));
        assertTrue(hangman.checkLastLetter(), "Should be true, both words contain the letter");
        hangman.guess(new Scanner("z"));
        assertFalse(hangman.checkLastLetter(), "Should be false, neither word contains the letter");

        Exception e = assertThrows(Exception.class, () -> hangman.guess(new Scanner("d")));
        assertEquals("You guessed that letter already!", e.getMessage(), "Wrong exception on already guess");

        e = assertThrows(Exception.class, () -> hangman.guess(new Scanner("3")));
        assertEquals("Guess a letter", e.getMessage(), "Wrong exception on guessing non-letter");

    }

    @Test
    void testToString() throws Exception {
        int wordLength = hangman.getSecret().length();
        String s = "";
        for(int i = 0; i < wordLength; i++){
            s += "-";
        }
        assertEquals(String.format("Word: %s\nMissed Letters: \n", s), hangman.toString(), "String wrong for no guesses");
        if(hangman.getSecret().equals("dog")){
            s = "d--";
        }else if(hangman.getSecret().equals("bird")){
            s = "---d";
        }
        hangman.guess(new Scanner("d"));
        assertEquals(String.format("Word: %s\nMissed Letters: \n", s), hangman.toString(), "String wrong for correct letters");
        hangman.guess(new Scanner("z"));
        assertEquals(String.format("Word: %s\nMissed Letters: z\n", s), hangman.toString(), "String wrong for either correct letters or wrong letters");
    }

    @Test
    void getSecret() {
        assertTrue(hangman.getSecret().equals("bird") || hangman.getSecret().equals("dog"));
    }
}