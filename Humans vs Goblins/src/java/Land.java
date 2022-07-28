import java.util.ArrayList;

public class Land {
    public static String[][] map = new String[10][10];

    public Land(ArrayList<Humanoid> humanoids){
        this.update(humanoids);
    }

    public void update(ArrayList<Humanoid> humanoids){
        for(int i = 0; i < 10; i++){
            map[0][i] = "=";
            map[9][i] = "=";
        }
        for(int i = 1; i < 9; i++){
            map[i][0] = ":";
            map[i][9] = ":";
        }
        for(int i = 1; i < 9; i++){
            for(int j = 1; j < 9; j++){
                map[i][j] = " ";
            }
        }
        for(int i = 0; i < humanoids.size(); i++){
            Humanoid humanoid = humanoids.get(i);
            String marker = (humanoid instanceof Human)? "X" : "G";
            map[humanoid.getYPos()][humanoid.getXPos()] = marker;
        }
    }

    public String toString(){
        String mapString = "";
        for(String[] x : map){
            for(String y : x) {
                mapString += (y + " ");
            }
            mapString += "\n";
        }
        return mapString;
    }
}
