import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoblinTest {

    @Test
    void testToString() {
        Goblin goblin = new Goblin();
        assertTrue(String.format("Enemy Goblin HP: %d", goblin.getHp()).equals(goblin.toString()), "String incorrect");
    }
}