package FlappyBird;
import java.awt.*;

import javax.swing.*;

public class FlappyBirdRenderer extends JPanel {

    private static final long serialVersionUID = 1L;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        FlappyBird.flappyBird.repaint(g);
    }

}