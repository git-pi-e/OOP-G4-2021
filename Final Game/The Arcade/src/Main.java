import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import BrickBreaker.BrickBreakerGameFrame;
import Snake.SnakeGameFrame;

public class Main {
    public static void main(String[] args) throws Exception {
        JFrame obJFrame = new JFrame();
        JPanel gameChooserFrame = new JPanel();
        gameChooserFrame.setBackground(Color.black);
        gameChooserFrame.setLayout(new GridLayout(3, 1));

        JLabel titLabel = new JLabel("The Arcade", SwingConstants.CENTER);
        titLabel.setFont(new Font(titLabel.getFont().getName(), Font.PLAIN, 25));
        // titLabel.setBounds(250, 50, 700, titLabel.getHeight());
        titLabel.setForeground(Color.white);

        JLabel chooseGame = new JLabel("Choose game:", SwingConstants.CENTER);
        chooseGame.setFont(new Font(chooseGame.getFont().getName(), Font.PLAIN, 14));
        chooseGame.setBounds(200, 300, chooseGame.getWidth(), chooseGame.getHeight());
        chooseGame.setForeground(Color.white);

        JButton snakeGameButton = new JButton("Snake Game");
        snakeGameButton.setFont(new Font(snakeGameButton.getFont().getName(), Font.PLAIN, 14));
        snakeGameButton.setBackground(Color.RED);
        snakeGameButton.setForeground(Color.white);
        snakeGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SnakeGameFrame snakeGameFrame = new SnakeGameFrame();
                gameChooserFrame.setVisible(false);
                obJFrame.add(snakeGameFrame);
                snakeGameFrame.requestFocus();
            }
            
        });

        JButton flappyBirdGameButton = new JButton("Flappy Bird");
        flappyBirdGameButton.setFont(new Font(flappyBirdGameButton.getFont().getName(), Font.PLAIN, 14));
        flappyBirdGameButton.setBackground(Color.GREEN);
        flappyBirdGameButton.setForeground(Color.white);
        flappyBirdGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FlappyBirdRenderer flappyBird = new FlappyBirdRenderer();
                // gameChooserFrame.setVisible(false);
                // obJFrame.add(flappyBird);
                // flappyBird.requestFocus();
            }
        });

        JButton brickBreakerGameButton = new JButton("Brick Breaker");
        brickBreakerGameButton.setFont(new Font(brickBreakerGameButton.getFont().getName(), Font.PLAIN, 14));
        brickBreakerGameButton.setBackground(Color.BLUE);
        brickBreakerGameButton.setForeground(Color.white);
        brickBreakerGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BrickBreakerGameFrame brickBreakerGameFrame = new BrickBreakerGameFrame();
                gameChooserFrame.setVisible(false);
                obJFrame.add(brickBreakerGameFrame);
                brickBreakerGameFrame.requestFocus();
            }
        });
        
        JButton pongGameButton = new JButton("Pong");
        pongGameButton.setFont(new Font(pongGameButton.getFont().getName(), Font.PLAIN, 14));
        pongGameButton.setBackground(Color.ORANGE);
        pongGameButton.setForeground(Color.white);

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(2, 1));
        labelPanel.setBackground(Color.black);
        labelPanel.add(titLabel);
        labelPanel.add(chooseGame);
        gameChooserFrame.add(labelPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2, 10, 10));
        buttonPanel.setBackground(Color.black);
        buttonPanel.add(snakeGameButton);
        buttonPanel.add(flappyBirdGameButton);
        buttonPanel.add(brickBreakerGameButton);
        buttonPanel.add(pongGameButton);
        gameChooserFrame.add(buttonPanel);

        obJFrame.setBounds(10, 10, 700,600);
        obJFrame.setTitle("The Arcade");
        obJFrame.setResizable(false);
        obJFrame.setVisible(true);
        obJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obJFrame.add(gameChooserFrame);
    }
}
