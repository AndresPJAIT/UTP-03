import java.awt.*;
import java.util.Random;

public class Ball implements Runnable{
    protected int x, y, vx, vy, speed;
    Thread thread;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;

        Random random = new Random();
        // Formula: random.nextInt((max - min) + 1) + min
        this.vx = random.nextInt(7)-3;
        this.vy= random.nextInt(7)-3;

        this.speed = random.nextInt(11) + 20;

        this.thread = new Thread(this);
    }

    public void draw(Graphics g) {
        g.fillOval(this.x-5, this.y-5, 10, 10);
    }

    @Override
    public void run() {
        while (true) {
            x += vx;
            y += vy;

            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }




}
