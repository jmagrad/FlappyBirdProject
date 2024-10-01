import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;

public class TopClass {
    // global constant variables
    private static final int SCREEN_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static final int SCREEN_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    // global variables
    private JFrame frame = new JFrame("John's Game");
    private static TopClass tc = new TopClass();

    public TopClass() {
    }

    // main method

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                tc.buildFrame();
                // create a new thread to keep the GUI responsive while the game runs
                Thread t = new Thread() {
                    public void run() {
                        // in here we will call a function to start the game
                    }
                };
                t.start();
            }
        });
    }

    private void buildFrame() {
        Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("resources/blue_bird.png"));
        frame.setContentPane(createContentPane());
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(false);
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(SCREEN_WIDTH * 1 / 4, SCREEN_HEIGHT * 1 / 4));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setIconImage(icon);
    }

    private JPanel createContentPane() {
        JPanel topPanel = new JPanel(); // top-most JPanel in layout hierarchy
        return topPanel; // return a blank panel
    }
}
