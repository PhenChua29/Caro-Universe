package MyLib;

import java.awt.*;
import javax.swing.*;

public class JButtonTemplate extends JButton {

    public JButtonTemplate() {
        super();
        init();
    }

    public JButtonTemplate(Icon icon) {
        super(icon);
        init();
    }

    public JButtonTemplate(String text) {
        super(text);
        init();
    }

    // FULL
    public void set(int x, int y, int width, int height, Color color, Font font) {
        this.setLocation(x, y);
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(color);
        this.setFont(font);

        this.setOpaque(false);
        this.setVisible(true);
        this.setFocusable(false);
    }

    // #2
    public void set(int width, int height, Font font) {
        this.setPreferredSize(new Dimension(width, height));
        this.setFont(font);

        this.setOpaque(false);
        this.setVisible(true);
        this.setFocusable(false);
    }

    // #3
    public void set(int width, int height, Color color) {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(color);
        this.setFont(new Font("Ink Free", Font.PLAIN, 75));

        this.setOpaque(false);
        this.setVisible(true);
        this.setFocusable(false);
    }

    // #4
    public void set(int x, int y, int width, int height, String text, Color BackgroundColor, Color textColor) {
        this.setBounds(x, y, width, height);
        this.setBackground(BackgroundColor);
        this.setForeground(textColor);
        this.setFont(new Font("Ink Free", Font.PLAIN, 75));
        this.setText(text);

        this.setOpaque(false);
        this.setVisible(true);
        this.setFocusable(false);
    }

    public void init() {
        this.setBorderPainted(true);
        this.setRolloverEnabled(true);
        this.setFocusPainted(true);
    }
    
    public void setStyling(boolean flag) {
        this.setOpaque(flag);
        this.setFocusable(flag);
        this.setFocusPainted(flag);
        this.setBorderPainted(flag);
        this.setContentAreaFilled(flag);
    }
}
