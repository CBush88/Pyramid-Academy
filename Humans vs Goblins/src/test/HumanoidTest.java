import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanoidTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getHp() {
        Human human = new Human();
        assertSame(20, human.getHp());
    }

    @Test
    void setHp() {
        Human human = new Human();
        human.setHp(19);
        assertSame(19, human.getHp());
    }

    @Test
    void getDamage() {
        Human human = new Human();
        assertSame(1, human.getDamage());
    }

    @Test
    void setDamage() {
        Human human = new Human();
        human.setDamage(2);
        assertSame(2, human.getDamage());
    }

    @Test
    void getXPos() {
        Human human = new Human();
        assertTrue(human.getXPos() >= 0 && human.getXPos() <= 9);
    }

    @Test
    void setXPos() {
        Human human = new Human();
        human.setXPos(4);
        assertSame(4, human.getXPos());
    }

    @Test
    void getYPos() {
        Human human = new Human();
        assertTrue(human.getYPos() >= 0 && human.getYPos() <= 9);
    }

    @Test
    void setYPos() {
        Human human = new Human();
        human.setYPos(4);
        assertSame(4, human.getYPos());
    }
}