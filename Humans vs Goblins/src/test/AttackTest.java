import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttackTest {

    @Test
    void attack() {
        Human human = new Human();
        Goblin goblin = new Goblin();
        int humanHp = human.getHp();
        int goblinHp = goblin.getHp();

        String testString1 = human.attack(goblin);
        String testString2 = goblin.attack(human);

        int humanHpAfter = human.getHp();
        int goblinHpAfter = goblin.getHp();
        assertTrue(goblinHp - goblinHpAfter <= 5, "Damage seems wrong");

        assertTrue(String.format("%s attacks %s for %d damage.%n", human.getClass().getSimpleName(),
                goblin.getClass().getSimpleName(), goblinHp - goblinHpAfter).equals(testString1), "Bad string for human attack goblin");

        assertTrue(String.format("%s attacks %s for %d damage.%n", goblin.getClass().getSimpleName(),
                human.getClass().getSimpleName(), humanHp - humanHpAfter).equals(testString2), "Bad string for goblin attack human");

        goblin.setHp(1);
        goblinHp = 1;
        String testString3 = human.attack(goblin);
        goblinHpAfter = goblin.getHp();

        assertTrue(String.format("%s attacks %s for %d damage.%n%s dies.", human.getClass().getSimpleName(),
                goblin.getClass().getSimpleName(), goblinHp - goblinHpAfter,
                goblin.getClass().getSimpleName()).equals(testString3), "Bad string for human kills goblin");


    }
}