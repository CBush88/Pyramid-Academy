import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Human human = new Human();
        ArrayList<Humanoid> humanoids = new ArrayList<>();
        ArrayList<Humanoid> combatants = new ArrayList<>();
        humanoids.add(human);
        for(int i = 0; i <= (int)((Math.random() * 2) +1); i++){
            Goblin goblin = new Goblin();
            humanoids.add(goblin);
        }
        Scanner input = new Scanner(System.in);
        Land map = new Land(humanoids);

        do{
            map.update(humanoids);
            System.out.println(map);
            System.out.println("Move with WASD");
            human.move(human, input.next().toLowerCase().charAt(0));

            while(combatCheck(humanoids, combatants)) {
                Goblin goblin = (Goblin) combatants.get(0);
                System.out.println(human);
                System.out.println("vs");
                System.out.println(goblin);
                System.out.println("E to attack");
                if(getInput(input) == 'e'){
                    System.out.println(human.attack(human, goblin));
                }
                Thread.sleep(1000);
                if(goblin.getHp() > 0){
                    System.out.println(goblin.attack(goblin, human));
                }
                Thread.sleep(1000);

                try {
                    removeDead(humanoids, combatants);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }while(human.getHp() > 0);
    }
    public static char getInput(Scanner input){
        return input.next().toLowerCase().charAt(0);
    }
    public static boolean combatCheck(ArrayList<Humanoid> humanoids, ArrayList<Humanoid> combatants){

        if(humanoids.get(0) instanceof Goblin){
            return false;
        }
        if(humanoids.size() > 1) {
            for (int i = 1; i < humanoids.size(); i++) {

                if (humanoids.get(i).getXPos() == humanoids.get(0).getXPos() &&
                        humanoids.get(i).getYPos() == humanoids.get(0).getYPos()) {
                    combatants.add(humanoids.get(i));
                    return true;
                }
            }
        }

        return false;
    }

    public static void removeDead(ArrayList<Humanoid> humanoids, ArrayList<Humanoid> combatants){

        humanoids.removeIf(h -> h.getHp() <= 0);
        combatants.removeIf(h -> h.getHp() <= 0);
    }

}