package Panel;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

import MyLib.*;
import Frame.*;

public class GamePanel extends JPanelTemplate implements ActionListener {

	private static JButtonTemplate[] button = new JButtonTemplate[9];
	private static boolean player_one_turn;
	private static int player_win = 0;
	private static Random randomizer;
	private static int[][] playing_history = {
		{0, 0, 0},
		{0, 0, 0},
		{0, 0, 0}
	};
	private static ImageIcon ImageX;
	private static ImageIcon ImageO;

	// Init
	public GamePanel() {
		initgamePanel();
		GamePanel.initTurn();
	}

	private void initgamePanel() {
		this.set(0, 100, 800, 700, Color.GREEN);

		this.setLayout(new GridLayout(3, 3));

		for (int i = 0; i < button.length; ++i) {
			button[i] = new JButtonTemplate();
			button[i].setLocation(800 / 3, 700 / 3);
			button[i].setFont(new Font("Ink Free", Font.ITALIC, 75));
			button[i].setFocusable(false);
			button[i].addActionListener(this);
			button[i].setForeground(Color.WHITE);
			button[i].setStyling(false);

			boolean debug = false;
			if (debug) {
				button[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
				button[i].setStyling(debug);
			}

			this.add(button[i]);
		}
	}

	private static void initTurn() {
		randomizer = new Random();
		// Randomize turn
		player_one_turn = (randomizer.nextInt(2) == 1);

		// Randomize move's image of X and O
		int NumX = randomizer.nextInt(5) + 1;
		int NumO;
		do {
			NumO = randomizer.nextInt(5) + 1;
		} while (NumO == NumX);

		String filePathX = String.format("../img/move%s.png", NumX);
		String filePathO = String.format("../img/move%s.png", NumO);

		ImageX = new ImageIcon(GamePanel.class.getResource(filePathX));
		ImageO = new ImageIcon(GamePanel.class.getResource(filePathO));
	}

	static void initNewGame() {
		initTurn();
		for (int i = 0; i < 9; ++i) {
			playing_history[i / 3][i % 3] = 0;
			button[i].setText("");
			button[i].setIcon(null);
		}
		player_win = 0;
		player_one_turn = (randomizer.nextInt(2) == 1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("The button " + e.getSource() + " is pressed");
		for (int i = 0; i < 9; ++i) {
			boolean isEmpty = button[i].getText().equals("") && button[i].getIcon() == null;
			boolean isSource = e.getSource() == button[i];
			if (isSource && isEmpty) {
				draw_XO(button[i]);
				playing_history[i / 3][i % 3] = (player_one_turn) ? 1 : 2;
				System.out.println("Changing playing_history[" + (i / 3) + "][" + (i % 3)
								+ "] = "
								+ ((player_one_turn) ? 1 : 2));
				checkWinner();
				changeTurn();
				break;
			}
		}
	}

	// Logic methods
	private void draw_XO(JButton b) {
//        b.setText((player_one_turn) ? "X" : "O");
		b.setIcon((player_one_turn) ? ImageX : ImageO);
	}

	private void changeTurn() {
		player_one_turn = !player_one_turn;
		TitlePanel.label.setText(GamePanel.isPlayer_one_turn() ? "X turn" : "O turn");
	}

	private void checkWinner() {
		if (horizontalCheck() == 1 || verticalCheck() == 1 || XCheck() == 1) {
			frame.setEndGame_trigger(true);
			EndGamePanel.setText("Player " + player_win + " win!");
			System.out.println("Player " + player_win + " win!");
			return;
		}
		if (isFullBoard()) {
			frame.setEndGame_trigger(true);
			EndGamePanel.setText("We have a tie");
			System.out.println("We have a tie");
		}
	}

	private int horizontalCheck() {
		for (int i = 0; i < 3; ++i) {
			if (playing_history[i][0] != 0) {
				if (playing_history[i][0] == playing_history[i][1]
								&& playing_history[i][1] == playing_history[i][2]) {
					player_win = playing_history[i][0];
					return 1;
				}
			}
		}
		return 0;
	}

	private int verticalCheck() {
		for (int i = 0; i < 3; ++i) {
			if (playing_history[0][i] != 0) {
				if (playing_history[0][i] == playing_history[1][i]
								&& playing_history[1][i] == playing_history[2][i]) {
					player_win = playing_history[0][i];
					return 1;
				}
			}
		}
		return 0;
	}

	private int XCheck() {
		int i = 0, j = 0;
		if (playing_history[i][j] != 0) {
			if (playing_history[i][j] == playing_history[i + 1][j + 1]
							&& playing_history[i + 1][j + 1] == playing_history[i + 2][j + 2]) {
				player_win = playing_history[i][j];
				return 1;
			}
		}
		j = 2;
		if (playing_history[i][j] != 0) {
			if (playing_history[i][j] == playing_history[i + 1][j - 1]
							&& playing_history[i + 1][j - 1] == playing_history[i + 2][j - 2]) {
				player_win = playing_history[i][j];
				return 1;
			}
		}
		return 0;
	}

	static boolean isFullBoard() {
		int count = 0;
		for (int i = 0; i < playing_history.length; ++i) {
			for (int j = 0; j < playing_history[i].length; ++j) {
				count += playing_history[i][j] != 0 ? 1 : 0;
			}
		}
		return count == 9;
	}

	// Getter
	public static boolean isPlayer_one_turn() {
		return player_one_turn;
	}
}
