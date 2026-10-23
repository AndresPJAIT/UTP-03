import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;



public class BallPanel extends Panel implements Runnable, ActionListener {

    private List<Ball> ballList;

    public BallPanel() {
        this.ballList = new ArrayList<>();

        new Thread(this).start();


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Ball b : ballList ) {
            b.draw(g);
        }

    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            repaint();

            try {
                Thread.sleep(33);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int startX = getWidth() > 0 ? getWidth() / 2 : 250;
        int startY = getHeight() > 0 ? getHeight() / 2 : 250;

        Ball b = new Ball(startX, startY);

        synchronized (ballList) {
            ballList.add(b);
        }
        b.thread.start();
        repaint();
    }

}
