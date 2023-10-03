package Panel;

import java.awt.*;

import MyLib.JPanelTemplate;

// Doesn't even need this anymore
public class InGamePanel extends JPanelTemplate {

    private GamePanel gamePanel;
    private TitlePanel TitlePanel;

    public InGamePanel() {
        init();
        initTitlePanel();
        initGamePanel();
    }

    private void init() {
        this.set(0, 0, 800, 800, "BorderLayout", Color.GREEN);
    }

    private void initTitlePanel() {
        TitlePanel = new TitlePanel();
        this.add(TitlePanel, java.awt.BorderLayout.NORTH);
    }

    private void initGamePanel() {
        gamePanel = new GamePanel();
        this.add(gamePanel, java.awt.BorderLayout.CENTER);
    }

    void update_text() {
        if (GamePanel.isPlayer_one_turn() == true) {
            TitlePanel.setText("X turn");
        } else {
            TitlePanel.setText("O turn");
        }
    }
}