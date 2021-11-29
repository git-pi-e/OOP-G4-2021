import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) throws Exception {
        JFrame obJFrame = new JFrame();
        GameFrame gameFrame = new GameFrame();

        obJFrame.setBounds(10, 10, 700,600);
        obJFrame.setTitle("Brick Breaker");
        obJFrame.setResizable(false);
        obJFrame.setVisible(true);
        obJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obJFrame.add(gameFrame);
    }
}
