import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getWord() {
        String[] words = {"cat", "dog", "bird"};
        boolean first = false, mid = false, last = false;
        for(int i = 0; i < words.length * words.length; i++){
            ArrayList<String> word = Main.getWord(words);
            if(word.containsAll(Arrays.asList(words[0].split("")))){
                first = true;
            }else if(word.containsAll(Arrays.asList(words[(words.length / 2)].split("")))){
                mid = true;
            }else if(word.containsAll(Arrays.asList(words[words.length-1].split("")))){
                last = true;
            }
        }
        assertTrue((first && mid && last), "Random may be broken, please retest");
    }

    @Test
    void getHangman() {
        int guesses = 0;
        ArrayList<String> hangman;
        while(guesses <= 6){
            hangman = Main.getHangman(guesses);
            assertSame(" +---+", hangman.get(0), "Top of hangman broken");
            assertSame("    ===", hangman.get(4), "Bottom of hangman broken");
            switch(guesses){
                case 0:
                    assertSame("     |", hangman.get(1), "Third empty row broken in case " + guesses);
                    assertSame("     |", hangman.get(2), "Fourth empty row broken in case " + guesses);
                    assertSame("     |", hangman.get(3), "Fifth empty row broken in case " + guesses);
                    break;
                case 1:
                    assertSame(" O   |", hangman.get(1), "Head not added properly in case " + guesses);
                    assertSame("     |", hangman.get(2), "Fourth empty row broken in case " + guesses);
                    assertSame("     |", hangman.get(3), "Fifth empty row broken in case " + guesses);
                    break;
                case 2:
                    assertSame(" O   |", hangman.get(1), "Head not added properly in case " + guesses);
                    assertSame(" |   |", hangman.get(2), "Body not added properly in case " + guesses);
                    assertSame("     |", hangman.get(3), "Fifth empty row broken in case " + guesses);
                    break;
                case 3:
                    assertSame(" O   |", hangman.get(1), "Head not added properly in case " + guesses);
                    assertSame(" |   |", hangman.get(2), "Body not added properly in case " + guesses);
                    assertSame("/    |", hangman.get(3), "Left leg not added properly in case " + guesses);
                    break;
                case 4:
                    assertSame(" O   |", hangman.get(1), "Head not added properly in case " + guesses);
                    assertSame(" |   |", hangman.get(2), "Body not added properly in case " + guesses);
                    assertSame("/ \\  |", hangman.get(3), "Right leg not added properly in case " + guesses);
                    break;
                case 5:
                    assertSame(" O   |", hangman.get(1), "Head not added properly in case " + guesses);
                    assertSame("/|   |", hangman.get(2), "Left arm not added properly in case " + guesses);
                    assertSame("/ \\  |", hangman.get(3), "Right leg not added properly in case " + guesses);
                    break;
                case 6:
                    assertSame(" O   |", hangman.get(1), "Head not added properly in case " + guesses);
                    assertSame("/|\\  |", hangman.get(2), "Right arm not added properly in case " + guesses);
                    assertSame("/ \\  |", hangman.get(3), "Right leg not added properly in case " + guesses);
                    break;
                default:
                    fail("Loop goes beyond 6");
                    break;
            }
            guesses++;
        }
    }

    @Test
    void getGuess() throws Exception {
        Scanner input1 = new Scanner("s");
        Scanner input2 = new Scanner("s");
        Scanner input3 = new Scanner("1");
        ArrayList<String> lettersGuessed = new ArrayList<>();

        Main.getGuess(input1, lettersGuessed);
        assertEquals("s", lettersGuessed.get(0), "Letter not added");

        Exception e = assertThrows(Exception.class,
                () ->Main.getGuess(input2, lettersGuessed), "Should throw already guessed");
        assertSame("You already guessed that letter", e.getMessage());

        e = assertThrows(Exception.class,
                () -> Main.getGuess(input3, lettersGuessed), "Should throw needs to be letter");
        assertSame("Guess a letter", e.getMessage());
    }

    @DisplayName("Winning checkWin")
    @Test
    void checkWin1() {
        String[] secret = {"w", "o", "r", "d"};
        String[] guessed = {"w", "o", "r"};
        ArrayList<String> lettersGuessed = new ArrayList<>(Arrays.asList(guessed));
        lettersGuessed.add("d");
        ArrayList<String> word = new ArrayList<>(Arrays.asList(secret));
        assertTrue(Main.checkWin(word, lettersGuessed), "Should have been a win");
    }
    @DisplayName("Losing checkWin")
    @Test
    void checkWin2() {
        String[] secret = {"w", "o", "r", "d"};
        String[] guessed = {"w", "o", "r"};
        ArrayList<String> lettersGuessed = new ArrayList<>(Arrays.asList(guessed));
        lettersGuessed.add("f");
        ArrayList<String> word = new ArrayList<>(Arrays.asList(secret));
        assertFalse(Main.checkWin(word, lettersGuessed), "Should have been a lose");
    }
}