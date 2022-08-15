import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    @Test
    void testToString() {
        Human human = new Human();
        String stringHuman = human.toString();
        assertTrue(String.format("Player HP: %d", human.getHp()).equals(stringHuman), "String incorrect");
    }

    @Test
    void run() {
        Human human = new Human();
        int xPos = human.getXPos();
        int yPos = human.getYPos();
        human.run();
        assertFalse(human.getXPos() == xPos && human.getYPos() == yPos, "Randomized, should be false try rerun");
        assertTrue(human.getXPos() >= 0 && human.getXPos() <= 9 &&
                human.getYPos() >= 0 && human.getYPos() <= 9, "Out of bounds spawn location");
    }
}