package MyLib;
import java.awt.*;
import javax.swing.*;

public class JFrameTemplate extends JFrame {

    // FULL
    public void set(int x, int y, int width, int height, String layoutManager, Color color) {
        if ("BorderLayout".equals(layoutManager)) {
            this.setLayout(new BorderLayout());
            this.setBounds(x, y, width, height);
            this.getContentPane().setBackground(color);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.setVisible(true);
        } else {
            this.setLayout(null);
            this.setBounds(x, y, width, height);
            this.getContentPane().setBackground(color);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.setVisible(true);
        }
    }
    // #2
    public void set(int x, int y, int width, int height, Color color) {
        this.setLayout(null);
        this.setBounds(x, y, width, height);
        this.getContentPane().setBackground(color);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
