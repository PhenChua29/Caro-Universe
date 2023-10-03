package Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Frame.*;

public class EndGamePanel extends JPanel implements ActionListener {

	private JButton newGameButton;
	private JButton HomeButton;
	private static JLabel textField;

	public EndGamePanel() {
		init();
		init_button();
		init_tilte();
		init_background();
	}

	private void init() {
		this.setLayout(null);
		this.setVisible(true);
		this.setBackground(Color.BLACK);
		this.setOpaque(true);
		this.setBounds(0, 0, 800, 800);
	}

	private void init_button() {
		// new game button
		newGameButton = new JButton("New game");

		newGameButton.setForeground(Color.WHITE);
		newGameButton.addActionListener(this);
		newGameButton.setBounds(190, 395, 420, 130);
		newGameButton.setFocusable(false);
		newGameButton.setFont(new Font("Ink Free", Font.BOLD, 75));

		newGameButton.setOpaque(false);
		newGameButton.setFocusPainted(false);
		newGameButton.setBorderPainted(false);
		newGameButton.setContentAreaFilled(false);

		this.add(newGameButton);

		HomeButton = new JButton();
		HomeButton.setForeground(Color.BLACK);
		HomeButton.addActionListener(this);
		HomeButton.setBounds(700, 680, 66, 71);
		HomeButton.setFocusable(false);
		HomeButton.setFont(new Font("Ink Free", Font.BOLD, 75));

		HomeButton.setBackground(Color.red);
		HomeButton.setOpaque(false);
		HomeButton.setFocusable(false);
		HomeButton.setFocusPainted(false);
		HomeButton.setBorderPainted(false);
		HomeButton.setContentAreaFilled(false);
		HomeButton.setIcon(new ImageIcon(getClass().getResource("/img/home.png")));

		this.add(HomeButton);
	}

	private void init_background() {
		JLabel imgBg = new JLabel();
		imgBg.setIcon(new ImageIcon(getClass().getResource("/img/2.png")));
		imgBg.setBounds(0, 0, 800, 800);
		this.add(imgBg);
	}

	private void init_tilte() {
		textField = new JLabel("", SwingConstants.CENTER);

		textField.setForeground(new Color(131, 206, 255));
		textField.setBounds(0, 200, 800, 150);
		textField.setFont(new Font("Ink Free", Font.BOLD, 75));
		textField.setBackground(new Color(6, 5, 55));

		textField.setOpaque(false);

		this.add(textField);
	}

	public static void setText(String text) {
		textField.setText(text);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		GamePanel.initNewGame();
		if (e.getSource().equals(newGameButton)) {
			frame.setNewGame_trigger(true);
			return;
		}
		if (e.getSource().equals(HomeButton)) {
			frame.setMenu_trigger(true);
		}
	}
}
