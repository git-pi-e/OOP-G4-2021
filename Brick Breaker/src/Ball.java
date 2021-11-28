import java.util.Random;

public class Ball {
    private int x, y, velocityX, velocityY;
    private boolean out = false;
    int width, height;
    Ball(int x, int y, int velocityX, int velocityY, int width, int height){
        this.x = x;
        this.y = y;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.width = width;
        this.height = height;
    }
    public static Ball initBall(Ball ball){
        return new Ball(120, 350, 3, 3, 20, 20);
    }
    public void setPositions(int x,int y){
        this.x = x;
        this.y = y;
        this.velocityX = 3;
        this.velocityY = 3;
    }
    public void updatePositions(){
        x += velocityX;
        y += velocityY;
    }

    public void updateVelocities(int changeInX, int changeInY){
        velocityX = (velocityX/Math.abs(velocityX)) * (Math.abs(velocityX) + changeInX);
        velocityY = (velocityY/Math.abs(velocityY)) * (Math.abs(velocityY) + changeInY);
    }

    public void checkCollision(int xboundStart, int xboundEnd, int yboundStart, int yboundEnd, int sliderX){
        if(x < xboundStart){
            x = xboundStart;
            velocityX *= -1;
        }
        if(x > xboundEnd){
            x = xboundEnd;
            velocityX *= -1;
        }
        if(y < yboundStart){
            y = yboundStart;
            velocityY *= -1;
        }
        if(y > yboundEnd){
            out = true;            
            y = yboundEnd;
        }

        if(x > sliderX && x < sliderX + 100 && y >= 500 && y <= 500 + velocityY){
            velocityY *= -1;
            y = 500;
        }
    }

    public boolean checkForCollisionWithBrick(Brick[] bricks, int level){
        boolean collided = false;

        for(int i = 0; i < bricks.length; i++){
            if(!bricks[i].broken){
                if(bricks[i].x - Brick.width/2 <= x && x <= bricks[i].x + Brick.width/2 && bricks[i].y - Brick.height/2 <= y && y <= bricks[i].y + Brick.height/2){
                    collided = true;
                    if(bricks[i].unbreakable){
                        collided = false;
                    }
                    bricks[i].hitBrick();
                    if(bricks[i].brickHealth != 0){
                        Random r = new Random();
                        velocityX = -1 *  (Math.abs(velocityX) / velocityX) * (r.nextInt(Math.abs(velocityX)) + 3);
                        velocityY = -1 * (Math.abs(velocityY) / velocityY) * (r.nextInt(Math.abs(velocityY)) + 3);
                        switch (level) {
                            case 1:
                                velocityX = (int)Math.round((double)velocityX * 4.2/Math.pow((velocityX * velocityX + velocityY * velocityY), 0.5));
                                velocityY = (int)Math.round((double)velocityY * 4.2/Math.pow((velocityX * velocityX + velocityY * velocityY), 0.5));
                                break;
                            case 2:
                                velocityX = (int)Math.round((double)velocityX * 5.2/Math.pow((velocityX * velocityX + velocityY * velocityY), 0.5));
                                velocityY = (int)Math.round((double)velocityY * 5.2/Math.pow((velocityX * velocityX + velocityY * velocityY), 0.5));
                                break;
                            case 3:
                                velocityX = (int)Math.round((double)velocityX * 6.2/Math.pow((velocityX * velocityX + velocityY * velocityY), 0.5));
                                velocityY = (int)Math.round((double)velocityY * 6.2/Math.pow((velocityX * velocityX + velocityY * velocityY), 0.5));
                                break;
                            default:
                                velocityX = (int)Math.round((double)velocityX * 7.0/Math.pow((velocityX * velocityX + velocityY * velocityY), 0.5));
                                velocityY = (int)Math.round((double)velocityY * 7.0/Math.pow((velocityX * velocityX + velocityY * velocityY), 0.5));
                                break;
                        }
                        System.out.println(velocityX + " " + velocityY);
                    }
                }
            }
        }

        return collided;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public boolean outOfBounds(){
        return out;
    }
}
