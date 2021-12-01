package Pong;

import javax.swing.*;
import java.awt.*;

public class PongGameFrame extends JPanel{

    GamePanel panel;

    public PongGameFrame(){
        panel = new GamePanel();
        this.add(panel);
        // this.setTitle("Pong Game");
        // this.setResizable(false);
        this.setBackground(Color.black);
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.pack();
        this.setVisible(true);
        // this.setLocationRelativeTo(null);
    }
}