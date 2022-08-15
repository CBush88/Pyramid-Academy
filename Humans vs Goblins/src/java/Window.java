import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Window {
    public JLabel[] getMapLines() {
        return new JLabel[] {mapLine1, mapLine2, mapLine3, mapLine4, mapLine5,
                mapLine6, mapLine7, mapLine8, mapLine9, mapLine10};
    }
    private JLabel mapLine1;
    private JLabel mapLine2;
    private JLabel mapLine3;
    private JLabel mapLine4;
    private JLabel mapLine5;
    private JLabel mapLine6;
    private JLabel mapLine7;
    private JLabel mapLine8;
    private JLabel mapLine9;
    private JLabel mapLine10;
    private JLabel outputLab;
    private JLabel vsLab;
    private JLabel playerHpLab;
    private JLabel enemyHpLab;
    public JPanel window;

    public Window() {
        window.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                mapLine1.setText("Hello!");
                mapLine1.repaint();
                window.repaint();
            }
        });
        mapLine1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                mapLine1.setText("Hello?");
                mapLine1.repaint();
            }
        });
    }
    public JLabel getOutputLab(){
        return outputLab;
    }
    public JLabel getPlayerHpLab(){
        return playerHpLab;
    }
    public JLabel getEnemyHpLab(){
        return enemyHpLab;
    }
    public JLabel getVsLab(){
        return vsLab;
    }
}
