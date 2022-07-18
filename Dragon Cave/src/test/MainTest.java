import org.junit.jupiter.api.*;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @BeforeEach
    void setUp() {
    }

    @DisplayName("getChoice 1")
    @Test
    void getChoice1() throws Exception {
        String s = "1";
        Scanner input = new Scanner(s);
        assertEquals('1', Main.getChoice(input), "Broken");
    }

    @DisplayName("getChoice 2")
    @Test
    void getChoice2() throws Exception {
        String s = "2";
        Scanner input = new Scanner(s);
        assertEquals('2', Main.getChoice(input), "Broken");
    }

    @AfterEach
    void tearDown() {
    }

}