package Snake;
import java.awt.*;

public class Apple {

    int x, y, score;


    public Apple(Snake s) {
        change();

    }

    public void change() {
        x = Snake.SNAKE_WIDTH * (int)(Math.random() * SnakeGameFrame.SCREEN_WIDTH / Snake.SNAKE_WIDTH);
        y = Snake.SNAKE_WIDTH * (int)(Math.random() * SnakeGameFrame.SCREEN_HEIGHT / Snake.SNAKE_WIDTH);
    }

    public int getScore() {
        return score;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, Snake.SNAKE_WIDTH, Snake.SNAKE_WIDTH);
    }

    public static double lerp(double val, double lb, double ub, double lv, double uv) {
        return lv + (val-lb)*(uv-lv)/(ub-lb);
    }

    public boolean snakeCollision() {
        Snake snake = SnakeGameFrame.snake;
        int snakeX = snake.getX();
        int snakeY = snake.getY();
        if(snakeX == x && snakeY == y) {
            change();
            score++;
            System.out.println("Elongate");
            SnakeGameFrame.FPS = (int)lerp(score, 0, 20, 25, 40);
            snake.setElongate(true);
            return true;
        }
        return false;
    }
}
