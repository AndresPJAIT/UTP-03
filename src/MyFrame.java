import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.Flow;

public class MyFrame extends Frame {

    private BallPanel ballPanel;
    private Panel buttonPanel;
    private Button addBall;
    private Button shakePanel;

    public static void main(String[] args){
        MyFrame frame = new MyFrame();
    }

    public MyFrame() {

        this.ballPanel = new BallPanel();
        this.addBall = new Button("Add Ball");
        this.shakePanel = new Button("Shake Ball");
        this.buttonPanel = new Panel();

        FlowLayout layout = new FlowLayout();

        buttonPanel.setLayout(layout);
        buttonPanel.add(addBall);
        buttonPanel.add(shakePanel);

        BorderLayout borderLayout = new BorderLayout();

        this.setLayout(borderLayout);

        this.add(ballPanel, borderLayout.CENTER);
        this.add(buttonPanel, borderLayout.SOUTH);

        setSize(500, 500);

        setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        ballPanel.setBackground(Color.yellow);
        buttonPanel.setBackground(Color.green);

    }


}
