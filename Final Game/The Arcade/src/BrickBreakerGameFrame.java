import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//x = 0 to x = 683
//y = 0 to y = 560

public class BrickBreakerGameFrame extends JPanel implements KeyListener, ActionListener{
    int xboundStart = 0;
    int xboundEnd = 683;
    int yboundStart = 0;
    int yboundEnd = 560;

    private boolean play = false, gameOver=false;
    private int lives = 3;
    private int level = 1;
    private int score = 0;
    private int brickRows = 3;
    private int brickColumns = 7;
    private int numOfUnbreakableBricks = 5;
    private Brick[] bricks = new Brick[brickRows * brickColumns];
    private int[] unbreakableBricksIndex = new int[numOfUnbreakableBricks];
    Ball ball = new Ball(120, 350, 3, 3, 20, 20);

    private Timer timer;
    private int delay = 8;

    private Slider slider = new Slider(310, 0, 100, 8);

    public BrickBreakerGameFrame() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        timer = new Timer(delay, this);
        timer.start();

        Brick.initBricks(numOfUnbreakableBricks, unbreakableBricksIndex, brickRows, brickColumns, bricks, level);
        ball = Ball.initBall(ball);
    }

    public void paint(Graphics g) {
        //background
        g.setColor(Color.black);
        g.fillRect(0, 0, 1000, 1000);

        //borders
        g.setColor(Color.yellow);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(683, 0, 3, 592);
        g.fillRect(0, 560, 692, 3);

        //the ball
        g.setColor(Color.yellow);
        g.fillOval(ball.getX()-ball.width/2, ball.getY()-ball.height/2, ball.width, ball.height);

        //bricks
        for(int i = 0; i < brickRows; i++){
            for(int j = 0; j < brickColumns; j++){
                if(!bricks[i * brickColumns + j].broken){
                    switch (bricks[i * brickColumns + j].brickHealth) {
                        case 1:
                            g.setColor(Brick.healthColor1);
                            break;
                        case 2:
                            g.setColor(Brick.healthColor2);
                            break;
                        case 3:
                            g.setColor(Brick.healthColour3);
                            break;
                        default:
                            break;
                    }

                    if(bricks[i * brickColumns + j].unbreakable){
                        g.setColor(Brick.unbreakableColor);
                    }
                    g.fillRect(bricks[i * brickColumns + j].x - Brick.width/2, bricks[i * brickColumns + j].y - Brick.height/2, Brick.width, Brick.height);
                }
            }
        }

        //the slider
        g.setColor(Color.green);
        g.fillRect(slider.getX(), 500, slider.width, slider.height);

        //Text overlays
        g.setColor(Color.white);
        g.drawString("LEVEL: " + level, 50, 450);
        g.drawString("Score: " + score, 50, 470);
        g.drawString("Lives: "+ lives, 600, 50);
        if(!play)
            g.drawString("PAUSED", 600, 70);
        if(gameOver)
            g.drawString("GAME OVER", 600, 90);

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(play){
            ball.updatePositions();
            slider.updatePositions(xboundStart, xboundEnd);

            ball.checkCollision(xboundStart, xboundEnd, yboundStart, yboundEnd, slider.getX());
            if(ball.outOfBounds()){
                lives--;
                ball = Ball.initBall(ball);
                play = !play;
                if(lives==0)
                    gameOver = true;
                return;
            }
            if(ball.checkForCollisionWithBrick(bricks, level)){
                score++;
                if(score % 7 == 0){
                    ball.updateVelocities(1, 1);
                }
            }
            if(Brick.checkAllBricksDestroyed(bricks)){
                level++;
                Brick.initBricks(numOfUnbreakableBricks, unbreakableBricksIndex, brickRows, brickColumns, bricks, level);
                ball = Ball.initBall(ball);
            }
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            play = true;
            slider.updateVelocity(7);
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            play = true;
            slider.updateVelocity(-7);
        }
        if(e.getKeyCode()== KeyEvent.VK_ESCAPE){
            play = !play;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT  || e.getKeyCode() == KeyEvent.VK_LEFT){
            slider.updateVelocity(0);
        }
    }
    
}
