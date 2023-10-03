package Frame;

import java.awt.Color;
import javax.swing.JPanel;

import Panel.*;
import MyLib.*;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class frame extends JFrameTemplate {

	public static final String menuPanel = "MenuPanel";
	public static final String inGamePanel = "InGamePanel";
	public static final String inGamePanelBg = "InGamePanelBg";
	public static final String endGamePanel = "EndGamePanel";
	public static final String creditPanel = "CreditPanel";

	private static boolean newGame_trigger = false;
	private static boolean quitGame_trigger = false;
	private static boolean credit_trigger = false;
	private static boolean endGame_trigger = false;
	private static boolean menu_trigger = false;

	private MenuPanel MenuPanel;
	private JPanel InGamePanel;
	private JPanelTemplate InGamePanelBg;
	private EndGamePanel EndGamePanel;
	private CreditPanel CreditPanel;

	public frame() {
		this.set(0, 0, 800, 800, "BorderLayout", Color.BLACK);
		this.setResizable(false);
		this.setTitle("Tic Tac Toe");
		initPanels();
	}

	private void initPanels() {
		MenuPanel = new MenuPanel();
		this.add(MenuPanel);

		InGamePanelBg = new JPanelTemplate();
		initInGamePanelBg();
		this.add(InGamePanelBg);

		InGamePanel = (JPanel) this.getGlassPane();
		initGlassPanel();

		EndGamePanel = new EndGamePanel();
		this.add(EndGamePanel);

		CreditPanel = new CreditPanel();
		this.add(CreditPanel);

		switchPanel(menuPanel);
	}

	/**
	 * Methods for switching panel depends on states: new game, credit, quit, end
	 * game
	 */
	public void switchPanel() {
		if (newGame_trigger) {
			System.out.println("Switched into " + inGamePanel);
			switchPanel(inGamePanelBg);
			setNewGame_trigger(false);
			TitlePanel.label.setText("Tic Tac Toe");
			try {
				Thread.sleep(2000);
				TitlePanel.label.setText(GamePanel.isPlayer_one_turn() ? "X turn" : "O turn");
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
			return;
		}
		if (credit_trigger) {
			switchPanel(creditPanel);
			System.out.println("Switched into " + creditPanel);
			setCredit_trigger(false);
			return;
		}
		if (endGame_trigger) {
			System.out.println("Switched into " + endGamePanel);
			switchPanel(endGamePanel);
			setEndGame_trigger(false);
			return;
		}
		if (menu_trigger) {
			System.out.println("Switched into " + menuPanel);
			switchPanel(menuPanel);
			setMenu_trigger(false);
			return;
		}
		if (quitGame_trigger) {
			System.out.println("Quitted Game");
			setQuitGame_trigger(false);
			this.dispose();
			System.exit(0);
		}
	}

	/**
	 * A method for switching panel depends on states: new game, credit, quit, end
	 * game
	 *
	 * @param panel A {@code String} that has the JPanel's name(predefined inside
	 * of this class).
	 */
	private void switchPanel(String panel) {
		InGamePanel.setVisible(false);
		System.out.println(panel);
		System.out.println(inGamePanelBg);
		if (panel.equals(menuPanel)) {
			this.setContentPane(MenuPanel);
		} else if (panel.equals(inGamePanelBg)) {
			this.setContentPane(InGamePanelBg);
			InGamePanel.setVisible(true);
		} else if (panel.equals(endGamePanel)) {
			this.setContentPane(EndGamePanel);
		} else if (panel.equals(creditPanel)) {
			this.setContentPane(CreditPanel);
		}
		this.repaint();
		this.validate();
	}

	/**
	 * Switch to another panel if state change
	 *
	 * @return {@code true} if there is a change in an of the states,
	 * {@code false} otherwise
	 */
	public static boolean isStateChange() {
		return (newGame_trigger
						|| quitGame_trigger
						|| credit_trigger
						|| endGame_trigger
						|| menu_trigger);
	}

	/**
	 * Setting up some necessary properties for the frame's glass {@code JPanel}.
	 * This {@code JPanel} contains the {@code inGame JPanel} and
	 * {@code Title JPanel} inside.
	 */
	private void initGlassPanel() {
		GamePanel gamePanel;
		TitlePanel TitlePanel;

		InGamePanel.setBounds(0, 0, 800, 800);
		InGamePanel.setLayout(new BorderLayout());
		InGamePanel.setBackground(Color.GREEN);
		InGamePanel.setVisible(false);

		boolean testing = false;
		if (testing) {
			InGamePanel.setOpaque(true);
		}

		TitlePanel = new TitlePanel();
		InGamePanel.add(TitlePanel, java.awt.BorderLayout.NORTH);

		gamePanel = new GamePanel();
		InGamePanel.add(gamePanel, java.awt.BorderLayout.CENTER);
	}

	private void initInGamePanelBg() {
		InGamePanelBg.set(0, 0, 800, 800, "null", Color.GREEN);

		JLabel imgBg = new JLabel();
		imgBg.setIcon(new ImageIcon(getClass().getResource("/img/4.png")));
		imgBg.setIcon(new ImageIcon(getClass().getResource("/img/4.png")));

		imgBg.setBounds(0, 0, 800, 800);
		InGamePanelBg.add(imgBg);
	}

	// GETTERS & SETTERS
	public static boolean isNewGame_trigger() {
		return newGame_trigger;
	}

	public static void setNewGame_trigger(boolean newGame_state) {
		newGame_trigger = newGame_state;
	}

	public static boolean isQuitGame_trigger() {
		return quitGame_trigger;
	}

	public static void setQuitGame_trigger(boolean QuitGame_trigger) {
		quitGame_trigger = QuitGame_trigger;
	}

	public static boolean isCredit_trigger() {
		return credit_trigger;
	}

	public static void setCredit_trigger(boolean Credit_trigger) {
		credit_trigger = Credit_trigger;
		System.out.println("Credit_trigger set:" + isCredit_trigger());
	}

	public static boolean isEndGame_trigger() {
		return endGame_trigger;
	}

	public static void setEndGame_trigger(boolean EndGame_trigger) {
		endGame_trigger = EndGame_trigger;
	}

	public static boolean isMenu_trigger() {
		return menu_trigger;
	}

	public static void setMenu_trigger(boolean Menu_trigger) {
		menu_trigger = Menu_trigger;
	}
}
