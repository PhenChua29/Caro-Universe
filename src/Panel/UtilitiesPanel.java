package Panel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UtilitiesPanel extends JPanel implements ActionListener {
    private JButton checkButton;
    private JButton newGameButton;
    private boolean new_game = false;

    private int[][] playing_history = {
            { 0, 0, 0 },
            { 0, 0, 0 },
            { 0, 0, 0 }
    };

    UtilitiesPanel() {
        init();
        init_button();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.setBackground(Color.GREEN);
        this.setOpaque(true);
        this.setBounds(0, 0, 100, 100);
    }

    // Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkButton) {
            System.out.println("");
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    System.out.print(playing_history[i][j] + " ");
                }
                System.out.println("");
            }
            System.out.println("");
        } else if (e.getSource() == newGameButton) {
            System.out.println("new button is pushed");
            this.new_game = true;
        }
    }

    private void init_button() {
        // check matrix Button
        checkButton = new JButton("Check Matrix");

        checkButton.setForeground(Color.RED);
        checkButton.addActionListener(this);

        this.add(checkButton, BorderLayout.CENTER);

        // new game button
        newGameButton = new JButton("New game");

        newGameButton.setForeground(Color.PINK);
        newGameButton.addActionListener(this);

        this.add(newGameButton, BorderLayout.EAST);
    }

    void update_playing_history(int i, int j, int value) {
        playing_history[i][j] = value;
    }

    boolean get_newGame_state() {
        return this.new_game;
    }

    void set_newGame_state(boolean b) {
        this.new_game = b;
    }
}
