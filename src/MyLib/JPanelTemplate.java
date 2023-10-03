package MyLib;

import java.awt.*;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.swing.*;

public class JPanelTemplate extends JPanel {

	// FULL
	public void set(int x, int y, int width, int height, String layoutManager, Color color) {
		if (layoutManager.equals("BorderLayout")) {
			this.setLayout(new BorderLayout());
			this.setLocation(x, y);
			this.setPreferredSize(new Dimension(width, height));
			this.setBackground(color);
			this.setOpaque(false);
			this.setVisible(true);
		} else {
			this.setLayout(null);
			this.setLocation(x, y);
			this.setPreferredSize(new Dimension(width, height));
			this.setBackground(color);
			this.setOpaque(false);
			this.setVisible(true);
		}
	}

	// #2
	public void set(int x, int y, int width, int height, Color color) {
		this.setLayout(null);
		this.setLocation(x, y);
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(color);
		this.setOpaque(false);
		this.setVisible(true);
	}

	// #3
	public void set(int width, int height, Color color) {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(color);
		this.setOpaque(false);
		this.setVisible(true);
	}

	public void playSound(String soundName) {
		String filePath = String.format("../audio/%s.png", soundName);
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}
}
