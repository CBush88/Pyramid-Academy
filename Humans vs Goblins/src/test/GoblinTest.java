import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoblinTest {

    @Test
    void testToString() {
        Goblin goblin = new Goblin();
        assertTrue(String.format("Enemy Goblin%nHP: %d", goblin.getHp()).equals(goblin.toString()));
    }
}