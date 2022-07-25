import org.junit.jupiter.api.*;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @BeforeEach
    void setUp() {
    }

    @DisplayName("Get name Bob")
    @Test
    void getName1() throws Exception {
        Scanner input = new Scanner("Bob");
        assertEquals("Bob", Main.getName(input), "Name test failed.");
    }
    @DisplayName("Get name John")
    @Test
    void getName2() throws Exception {
        Scanner input = new Scanner("John");
        assertEquals("John", Main.getName(input), "Name test failed.");
    }

    @DisplayName("Get name exceptions")
    @Test
    void getName3() {
        Scanner input = new Scanner("John3");
        Exception e = assertThrows(Exception.class, () -> Main.getName(input), "Should throw exception");
        assertSame("Your name needs to be all letters", e.getMessage(), "Exception is wrong");
    }

    @Test
    void getRandom() {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 20*20; i++) {
            int num = Main.getRandom();
            assertTrue(0 < num && num <= 20, "Random out of range");
            if(num < min){
                min = num;
            }
            if(num > max){
                max = num;
            }
        }
        assertEquals(20, max, "Bad maximum range");
        assertEquals(1, min, "Bad minimum range");
    }

    @DisplayName("Get guess test")
    @Test
    void getGuess1() throws Exception {

        for(int i = 1; i <= 20; i++) {
            Scanner input = new Scanner(String.valueOf(i));
            assertEquals(i, Main.getGuess(input), "Guess test broken");
        }
    }

    @DisplayName("Get guess exception test")
    @Test
    void getGuess2() {
        Exception e;
        Scanner input1 = new Scanner("30");
        Scanner input2 = new Scanner("a");

        e = assertThrows(Exception.class, () -> Main.getGuess(input1), "Should throw exception");
        assertSame("Number must be between 1 and 20", e.getMessage(), "Wrong exception output");

        assertThrowsExactly(InputMismatchException.class,
                () -> Main.getGuess(input2), "Should throw Input Mismatch");
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