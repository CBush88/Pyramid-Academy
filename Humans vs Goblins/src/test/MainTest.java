import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void combatCheck() {
        Human human = new Human();
        human.setYPos(0);
        human.setXPos(0);
        Goblin goblin = new Goblin();
        goblin.setXPos(0);
        goblin.setYPos(1);
        ArrayList<Goblin> combatants = new ArrayList<>();

        ArrayList<Humanoid> humanoids = new ArrayList<>();
        humanoids.add(human);
        humanoids.add(goblin);

        combatants.add(goblin);
        assertFalse(Main.combatCheck(humanoids, combatants), "Should not be in combat unless same x and y, different y");
        goblin.setYPos(0);
        goblin.setXPos(1);
        assertFalse(Main.combatCheck(humanoids, combatants), "Should not be in combat unless same x and y, different x");
        goblin.setXPos(0);
        assertTrue(Main.combatCheck(humanoids, combatants), "Should be in combat with same x and y");
    }

    @Test
    void removeDead() {
        Human human = new Human();
        Goblin goblin = new Goblin();

        ArrayList<Humanoid> humanoids = new ArrayList<>();
        humanoids.add(human);
        humanoids.add(goblin);

        ArrayList<Goblin> combatants = new ArrayList<>();
        combatants.add(goblin);

        Main.removeDead(humanoids, combatants);

        assertTrue(humanoids.size() == 2 && combatants.size() == 1, "There should be no dead removed");

        goblin.setHp(0);
        Main.removeDead(humanoids, combatants);

        assertTrue(humanoids.size() == 1 && combatants.size() == 0, "Dead should be removed");
    }

    @AfterEach
    void tearDown() {
    }
}