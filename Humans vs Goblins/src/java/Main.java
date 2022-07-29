import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Human human = new Human();
        ArrayList<Humanoid> humanoids = new ArrayList<>();
        ArrayList<Goblin> combatants = new ArrayList<>();
        humanoids.add(human);

        Character[] moveKeys = {'w','a','s','d'};
        ArrayList<Character> moveInputs = new ArrayList<>(Arrays.asList(moveKeys));
        Character[] battleKeys = {'e', 'r'};
        ArrayList<Character> battleInputs = new ArrayList<>(Arrays.asList(battleKeys));

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
            while(true) {
                try {
                    human.move(getInput(input, moveInputs));
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            while(combatCheck(humanoids, combatants)) {
                Goblin goblin = combatants.get(0);
                System.out.println(human);
                System.out.println("vs");
                System.out.println(goblin);
                System.out.println("E to attack or R to run");
                while(true) {
                    try {
                        char keyPress = getInput(input, battleInputs);
                        if (keyPress == 'e') {
                            System.out.println(human.attack(goblin));
                            break;
                        }else if(keyPress == 'r'){
                            human.run();
                            System.out.println("You ran away randomly until you ran out of breath!");
                            combatants.removeAll(combatants);
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                Thread.sleep(1000);
                if(goblin.getHp() > 0 && combatCheck(humanoids, combatants)){
                    System.out.println(goblin.attack(human));
                }
                Thread.sleep(1000);

                try {
                    removeDead(humanoids, combatants);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
                if(humanoids.size() == 1) {
                    if (humanoids.get(0) instanceof Human) {
                        System.out.println("You win!");
                    }
                }
                if(human.getHp() <= 0){
                    System.out.println("You lose!");
                    System.out.println("Better luck next time");
                    }
            }
        }while(human.getHp() > 0 && humanoids.size() > 1);
    }
    public static char getInput(Scanner input, ArrayList<Character> allowableInputs) throws Exception {
        char keyPress = input.next().toLowerCase().charAt(0);
        if(allowableInputs.contains(keyPress)){
            return keyPress;
        }else{
            throw new Exception("Invalid input, try again");
        }

    }
    public static boolean combatCheck(ArrayList<Humanoid> humanoids, ArrayList<Goblin> combatants){

        if(humanoids.get(0) instanceof Goblin){
            return false;
        }

        Human player = (Human) humanoids.get(0);

        if(humanoids.size() > 1) {
            for (int i = 1; i < humanoids.size(); i++) {

                if (humanoids.get(i).getXPos() == player.getXPos() &&
                        humanoids.get(i).getYPos() == player.getYPos()) {
                    combatants.add((Goblin)humanoids.get(i));
                    return true;
                }
            }
        }

        return false;
    }

    public static void removeDead(ArrayList<Humanoid> humanoids, ArrayList<Goblin> combatants){

        humanoids.removeIf(h -> h.getHp() <= 0);
        combatants.removeIf(h -> h.getHp() <= 0);
    }

}