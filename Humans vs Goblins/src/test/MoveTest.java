import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveTest {

    @Test
    void move() {
        Human human = new Human();
        human.setXPos(0);
        human.setYPos(0);
        human.move(human, 'n');

        assertDoesNotThrow(() -> human.move(human, 'w'), "Should not allow y to go negative");
        assertSame(0, human.getYPos(), "Issue moving at walls north");

        assertDoesNotThrow(() -> human.move(human, 'a'), "Should not allow x to go negative");
        assertSame(0, human.getYPos(), "Issue moving near walls west");

        human.setXPos(9);
        human.setYPos(9);

        assertDoesNotThrow(() -> human.move(human, 's'), "Should not allow y to go over 9");
        assertSame(9, human.getYPos(), "Issue moving at walls south");

        assertDoesNotThrow(() -> human.move(human, 'd'), "Should not allow x to go over 9");
        assertSame(9, human.getYPos(), "Issue moving near walls east");

        human.move(human, 'w');
        assertSame(8, human.getYPos(), "human not moving north");

        human.move(human, 's');
        assertSame(9, human.getYPos(), "human not moving south");

        human.move(human, 'a');
        assertSame(8, human.getXPos(), "human not moving west");

        human.move(human, 'd');
        assertSame(9, human.getXPos(), "human not moving east");
    }
}