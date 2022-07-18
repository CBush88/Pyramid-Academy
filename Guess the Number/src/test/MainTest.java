import org.junit.jupiter.api.*;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void getName() throws Exception {
        Scanner input = new Scanner("Bob");
        assertEquals("Bob", Main.getName(input), "Name test failed.");
    }

    @Test
    void getRandom() {
        int num = Main.getRandom();
        assertTrue(0 < num && num <= 20, "Random out of range");
    }

    @Test
    void getGuess() throws Exception {
        Scanner input = new Scanner("10");
        assertEquals(10, Main.getGuess(input), "Guess test broken");
    }

    @Test
    void replayTrue() throws Exception {
        Scanner input = new Scanner("y");
        assertTrue(Main.replay(input), "Replay True test failed");
    }

    @Test
    void replayFalse() throws Exception{
        Scanner input = new Scanner("n");
        assertFalse(Main.replay(input), "Replay False test failed");
    }

    @AfterEach
    void tearDown() {
    }
}