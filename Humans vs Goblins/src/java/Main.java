import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;


public class Main {

    public static void main(String[] args) {
        Window window = new Window();
        Human human = new Human();
        Goblin goblin;
        Semaphore moveSem = new Semaphore(0);
        Semaphore battleSem = new Semaphore(0);
        Semaphore inputSem = new Semaphore(0);

        ArrayList<Humanoid> humanoids = new ArrayList<>();
        ArrayList<Goblin> combatants = new ArrayList<>();
        humanoids.add(human);

        String moveControls = "Move with WASD";
        String combatControls = "E to attack or R to run";



        for(int i = 0; i <= (int)((Math.random() * 2) +1); i++){
            goblin = new Goblin();
            humanoids.add(goblin);
        }
        Land map = new Land(humanoids);

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Window");
            frame.setContentPane(window.window);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(450, 275);
            frame.setVisible(true);
            frame.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    super.keyPressed(e);
                    if((e.getKeyChar() == 'w' || e.getKeyChar() == 'a' || e.getKeyChar() == 's'
                    || e.getKeyChar() == 'd')){
                        if(!combatCheck(humanoids, combatants)) {
                            try {
                                inputSem.acquire();
                            } catch (InterruptedException ex) {
                                exceptionDialog(ex.getMessage());
                            }
                            human.move(e.getKeyChar());
                            frame.repaint();
                            moveSem.release();
                        }
                    }
                    else if((e.getKeyChar() == 'e' || e.getKeyChar() == 'r') && combatants.size() > 0) {
                        if (inputSem.availablePermits() > 0) {
                            try {
                                if (e.getKeyChar() == 'e') {
                                    inputSem.acquire();
                                    writeOutput(window, human.attack(combatants.get(0)));
                                    battleSem.release();
                                } else if (e.getKeyChar() == 'r') {
                                    inputSem.acquire();
                                    human.run();
                                    window.getOutputLab().setText("You ran away randomly until you were out of breath!");
                                    combatants.clear();
                                    battleSem.release();
                                }
                            } catch (Exception ex) {
                                exceptionDialog(ex.getMessage());
                            }
                        }
                    }
                }
            });
        });


        do{
            battleSem.drainPermits();
            window.getPlayerHpLab().setText(human.toString());
            window.getEnemyHpLab().setVisible(false);
            window.getVsLab().setVisible(false);

            map.update(humanoids);
            for(int i = 0; i < window.getMapLines().length; i++){
                window.getMapLines()[i].setText(map.toString().split("\n")[i]);
                window.getMapLines()[i].repaint();
            }
            window.getOutputLab().setText(moveControls);
            window.getOutputLab().repaint();

            inputSem.release();
            try{
                moveSem.acquire();
            }catch(Exception ex){
                exceptionDialog(ex.getMessage());
            }

            while(combatCheck(humanoids, combatants)) {
                goblin = combatants.get(0);
                window.getPlayerHpLab().setText(human.toString());
                window.getVsLab().setText("vs");
                window.getEnemyHpLab().setText(goblin.toString());
                window.getOutputLab().setText(combatControls);
                window.getEnemyHpLab().setVisible(true);
                window.getVsLab().setVisible(true);

                inputSem.release();
                try{
                    battleSem.acquire();
                    Thread.sleep(1500);
                }catch(Exception ex){
                    exceptionDialog(ex.getMessage());
                }

                if(goblin.getHp() > 0 && combatCheck(humanoids, combatants)){
                    writeOutput(window, goblin.attack(human));
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException ex) {
                        exceptionDialog(ex.getMessage());
                    }
                }

                removeDead(humanoids, combatants);
                if(humanoids.size() == 1) {
                    if (humanoids.get(0) instanceof Human) {
                        window.getOutputLab().setText("You win!");
                    }
                }
                if(human.getHp() <= 0){
                    window.getOutputLab().setText("You died!");
                    combatants.clear();
                    }
            }
        }while(human.getHp() > 0 && humanoids.size() > 1);
    }
    public static void exceptionDialog(String msg){
        JDialog errWindow = new JDialog();
        errWindow.setTitle("Exception");
        JLabel errLabel = new JLabel(msg);
        errWindow.add(errLabel);
        errLabel.setHorizontalAlignment(SwingConstants.CENTER);
        errWindow.pack();
        errWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        errWindow.setVisible(true);
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
    public static void writeOutput(Window window, String output){
        window.getOutputLab().setText(output);
    }
}