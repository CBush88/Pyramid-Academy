import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

class MainTest {
Hangman hangman;
String[] words = {"dog", "bird"};
Path inPath = Paths.get("src/files/input.txt");
File inFile = new File(inPath.toString());

Path outPath = Paths.get("src/files/test_output.txt");
File outFile = new File(outPath.toString());


    @BeforeEach
    void setUp() {
        hangman = new Hangman(words);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void hangmanGraphic() throws FileNotFoundException {
        for(int i = 0; i <= 6; i++){
            switch(hangman.getGuesses()){
                case 0:
                    assertEquals(" +---+\n     |\n     |\n     |\n    ===\n", Main.hangmanGraphic(hangman.getGuesses(), new Scanner(inFile)), "Bad string 0 guesses");
                    break;
                case 1:
                    assertEquals(" +---+\n O   |\n     |\n     |\n    ===\n", Main.hangmanGraphic(hangman.getGuesses(), new Scanner(inFile)), "Bad string 1 guess");
                    break;
                case 2:
                    assertEquals(" +---+\n O   |\n |   |\n     |\n    ===\n", Main.hangmanGraphic(hangman.getGuesses(), new Scanner(inFile)), "Bad string 2 guesses");
                    break;
                case 3:
                    assertEquals(" +---+\n O   |\n |   |\n/    |\n    ===\n", Main.hangmanGraphic(hangman.getGuesses(), new Scanner(inFile)), "Bad string 3 guesses");
                    break;
                case 4:
                    assertEquals(" +---+\n O   |\n |   |\n/ \\  |\n    ===\n", Main.hangmanGraphic(hangman.getGuesses(), new Scanner(inFile)), "Bad string 4 guesses");
                    break;
                case 5:
                    assertEquals(" +---+\n O   |\n/|   |\n/ \\  |\n    ===\n", Main.hangmanGraphic(hangman.getGuesses(), new Scanner(inFile)),"Bad string 5 guesses");
                    break;
                case 6:
                    assertEquals(" +---+\n O   |\n/|\\  |\n/ \\  |\n    ===\n", Main.hangmanGraphic(hangman.getGuesses(), new Scanner(inFile)), "Bad string 6 guesses");
                    break;
                default:
                    break;
            }
            hangman.incrementGuesses();
        }
    }

    @Test
    void writeOutput() throws IOException {
        String test = "Bob: 1\n";
        Files.write(outPath, "".getBytes());
        assertEquals("", Files.readString(outPath), "Bad read empty file");
        Main.writeOutput(outFile, "Bob", 1);
        assertEquals(test, Files.readString(outPath), "Bad write one name");
        test += "Tom: 2\n";
        Main.writeOutput(outFile, "Tom", 2);
        assertEquals(test, Files.readString(outPath));
    }

    @Test
    void getHighScore() throws IOException {
        Files.write(outPath, "Tom: 2".getBytes());
        assertEquals("Tom has the high score of: 2 consecutive wins.", Main.getHighScore(outFile, 1));
        assertEquals("You currently have the high score with 3 consecutive wins!", Main.getHighScore(outFile, 3));
    }
}