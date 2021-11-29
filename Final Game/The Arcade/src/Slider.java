public class Slider {
    private int x;
    private int velocityX;
    int width, height;
    Slider(int x, int velocityX, int width, int height){
        this.x = x;
        this.velocityX = velocityX;
        this.width = width;
        this.height = height;
    }

    public void updatePositions(int xboundStart, int xboundEnd){
        x += velocityX;
        if(x < xboundStart){
            x = xboundStart;
        }
        if(xboundEnd < x + width){
            x = xboundEnd - width;
        }
    }

    public void updateVelocity(int velocity){
        velocityX = velocity;
    }

    public int getX(){
        return x;
    }
}
