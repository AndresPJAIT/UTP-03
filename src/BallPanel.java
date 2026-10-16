import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BallPanel extends Panel implements Runnable, ActionListener {

    private List<Object> ballList;

    public BallPanel() {
        this.ballList = new List<Object>();

        new Thread(this).start();


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override
    public void run() {
        repaint();
        try {
            Thread.sleep(33);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
