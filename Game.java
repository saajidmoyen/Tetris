package tetris;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.*;

public class Game implements Runnable {
	// Arrays are used to allow other classes to edit values
	// gameStats contains the score, level, and lines
	private int[] gameStats = new int[3];
	private Tetromino[] nextPiece = new Tetromino[1];

	public void run() {
		// Top-level frame		
		final JFrame frame = new JFrame("Tetris");
		frame.setLocation(300, 300);
		
		// A list for formatting
		JPanel list = new JPanel();
		list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
				
		JLabel score = new JLabel();
		score.setText("Score: " + Integer.toString(gameStats[0]));
		
		JLabel level = new JLabel();
		level.setText("Level: " + Integer.toString(gameStats[1]));
		
		JLabel lines = new JLabel();
		lines.setText("Lines: " + Integer.toString(gameStats[2]));

		// Main playing area
		final TetrisGrid game = new TetrisGrid(gameStats, score, level, lines,
				nextPiece);
		
		// Start button
		final JButton start = new JButton("Start/Restart");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.start();
			}
		});
		
		// The instructions are drawn from a .txt file in the package
		final JButton instructions = new JButton("Instructions");
		instructions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFrame help = new JFrame("Instructions");
				help.setLocation(700,100);				
				InputStream in = getClass().getResourceAsStream("instructions.txt");
				JTextArea text = new JTextArea();				
				try {
		            text.read(new InputStreamReader(in), null);
		        } catch (IOException ex) {
		            ex.printStackTrace();
		        }
				help.add(text);
				help.pack();
				help.setVisible(true);
			}
		});
		
		// RigidAreas are used to space out the parts of the game
		list.add(start);
		list.add(Box.createRigidArea(new Dimension(10, 10)));
		list.add(instructions);
		list.add(Box.createRigidArea(new Dimension(10, 10)));
		list.add(score);
		list.add(Box.createRigidArea(new Dimension(10, 10)));
		list.add(level);
		list.add(Box.createRigidArea(new Dimension(10, 10)));
		list.add(lines);
		
		frame.add(game, BorderLayout.CENTER);
		frame.add(list, BorderLayout.EAST);



		// Put the frame on the screen
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	// Starts the game
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Game());
	}

}
