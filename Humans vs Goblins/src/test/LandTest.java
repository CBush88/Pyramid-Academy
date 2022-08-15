import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LandTest {

    @Test
    void update() {
        int mapHeight = 10;
        ArrayList<Humanoid> humanoids = new ArrayList<>();
        Land map = new Land(humanoids);
        for(int i = 0; i < mapHeight; i++){
            assertSame("=", Land.map[0][i], "Map draw issue north wall");
            assertSame("=", Land.map[9][i], "Map draw issue south wall");
            if(i > 0 && i < 9) {
                assertSame(":", Land.map[i][0], "Map draw issue west wall");
                assertSame(":", Land.map[i][9], "Map draw issue east wall");
                assertSame(" ", Land.map[i][i], "Map draw issue open space");
            }
        }
        Human human = new Human();
        humanoids.add(human);
        human.setXPos(5);
        human.setYPos(5);

        Goblin goblin = new Goblin();
        humanoids.add(goblin);
        goblin.setXPos(4);
        goblin.setYPos(4);

        map.update(humanoids);

        assertSame("X", Land.map[5][5], "Error drawing human");
        assertSame("G", Land.map[4][4], "Error drawing goblin");

        human.move(human, 's');
        map.update(humanoids);

        assertSame("X", Land.map[6][5], "Error updating human location");
        assertSame(" ", Land.map[5][5], "Error removing old human location");
    }

    @Test
    void testToString() {
        Human human = new Human();
        ArrayList<Humanoid> humanoids = new ArrayList<>();
        humanoids.add(human);
        human.setXPos(5);
        human.setYPos(5);
        Land map = new Land(humanoids);
        String mapTestString = "";

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                mapTestString += Land.map[i][j] + "  ";
            }
            mapTestString += "\n";
        }
        assertEquals(map.toString(), (mapTestString), "Error printing map");

    }
}