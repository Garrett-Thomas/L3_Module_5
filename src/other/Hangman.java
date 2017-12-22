package other;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Hangman implements KeyListener {
	Stack<String> words = new Stack<String>();
	ArrayList<JLabel> boxes = new ArrayList<JLabel>();
	Random rand = new Random();
	int lines = 0;
	int lives = 0;
	String currentWord = "";
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();

	public static void main(String[] args) {
		Hangman daddy = new Hangman();
		daddy.anOriginalMethodName();
		daddy.words();
	}

	public void anOriginalMethodName() {
		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		label.setSize(375, 375);
	}

	public void words() {
		try {
			// Get the amount of lines
			LineNumberReader lnr = new LineNumberReader(new FileReader(new File("/usr/share/dict/words")));
			lnr.skip(Long.MAX_VALUE);// Skip to the end
			lines = lnr.getLineNumber();// Get last line number
			System.out.println("Number of words: " + lines);
			lnr.close();
			BufferedReader br = new BufferedReader(new FileReader(new File("/usr/share/dict/words")));
			for (int i = 0; i < lines; i++) {
				words.add(br.readLine().toLowerCase()); // adds every line to the array
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void checkWord() {
		panel.removeAll();
		boxes.clear();
		for (int i = 0; i < currentWord.length() + 1; i++) {
			boxes.add( new JLabel("_"));
			System.out.println(1);
			panel.add(boxes.get(i));
			panel.updateUI();
		}
		System.out.println(1);
		int lives = boxes.size() - 1; 
	}
	private void updateSpacesWithUserInput(char keyChar) {
		for (int i = 0; i < currentWord.length(); i++) {
			if (currentWord.charAt(i) == keyChar) {
				boxes.get(i).setText("" + keyChar);
			}
		}
			else {
				System.out.println(2);
				lives--;
				boxes.get(boxes.size()-1).setText("" + lives);
				
			
		}
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			int randNum = rand.nextInt(lines);
			label.setText(words.get(randNum));
			currentWord = words.get(randNum);
			checkWord();
			words.remove(randNum);
			lines--;
			
		} 
		updateSpacesWithUserInput(e.getKeyChar());
		}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
