import javax.swing.JFrame;
import javax.swing.JLabel;
    

public class LeagueInvaders {
    
    public static void setup(){
    GamePanel gamePanel = new GamePanel();
    
    final int HEIGHT = 800;
    final int WIDTH = 300;

    JFrame frame = new JFrame();

    frame.setSize(WIDTH, HEIGHT);

    JLabel label = new JLabel("League Invaders");

    frame.add(label);
    frame.add(gamePanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setVisible(true);}
public static void main(String[] args){
setup();
}    

}
