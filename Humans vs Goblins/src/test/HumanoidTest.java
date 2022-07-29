import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanoidTest {
    Human human;

    @BeforeEach
    void setUp() {
        human = new Human();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getHp() {
        assertSame(20, human.getHp(), "Wrong value for HP");
    }

    @Test
    void setHp() {
        human.setHp(19);
        assertSame(19, human.getHp(), "HP set incorrectly");
    }

    @Test
    void getDamage() {
        assertSame(1, human.getDamage(), "Wrong value for damage");
    }

    @Test
    void setDamage() {
        human.setDamage(2);
        assertSame(2, human.getDamage(), "Damage set incorrectly");
    }

    @Test
    void getXPos() {
        assertTrue(human.getXPos() >= 0 && human.getXPos() <= 9, "X position out of bounds");
    }

    @Test
    void setXPos() {
        human.setXPos(4);
        assertSame(4, human.getXPos(), "X position set incorrectly");
    }

    @Test
    void getYPos() {
        assertTrue(human.getYPos() >= 0 && human.getYPos() <= 9, "Y position out of bounds");
    }

    @Test
    void setYPos() {
        human.setYPos(4);
        assertSame(4, human.getYPos(), "Y position set incorrectly");
    }
}