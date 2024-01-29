import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Vector;
import acm.util.SwingTimer;
import acm.graphics.*;

import javax.imageio.ImageIO;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class CharacterSelectPane extends GraphicsPane implements ActionListener {
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program; 
	private GLabel orangLabel;
	private GLabel gorillaLabel;
	private GLabel monkeyLabel;
	private GLabel dogLabel;
	private GLabel tigerLabel;
	private GLabel deerLabel;
	private GLabel donkeyLabel;
	private GLabel fishLabel;
	private GButton charSelect = new GButton("SELECTED", 0, 0, 0, 0);
	private GButton next = new GButton("NEXT", 1200, 25, 60, 60);
	//1400
	private GImage charOrang;
	private GImage charGorilla;
	private GImage charMonkey;
	private GImage charTiger;
	private GImage charDog;
	private GImage charDeer;
	private GImage charDonkey;
	private GImage charFish;
	//private GImage pickles;
	private GParagraph para;
	private GButton rect;
	private GImage display;
	private boolean monkey,orang,gorilla = false;
	private static final String LABEL_FONT = "Arial-Bold-32";
	private static final int DELAY = 100;

	private int choice = 0;

	public CharacterSelectPane(MainApplication app) {
		this.program = app;
		para = new GParagraph("Character Select(select by clikcing ont he anme you want)", app.getWidth() / 5.3, app.getHeight() / 10);
		para.setFont("Arial-26");
		//SwingTimer timer = new SwingTimer(DELAY, this);
		SwingTimer timer = new SwingTimer(DELAY, this);
		timer.start();

		rect = new GButton("Back", 25, 25, 60, 60);
		rect.setFillColor(Color.RED);
		
		charMonkey = new GImage("Chimp_Cartoon.jpg", 800, 150);
		charGorilla = new GImage("Gorilla_Cartoon.jpg",800, 150);
		charOrang = new GImage ("Orangutan_Cartoon.jpg", 800, 150);
		charTiger = new GImage("images/Tiger.png",800,150); 
		charDog = new GImage("images/Border.png",800,150); 
		charDeer = new GImage("images/deer.png",800,150);
		charFish = new GImage("images/fesh.png",800,150); 
		charDonkey = new GImage("images/donkey.png",800,150);
		
		charDog.setSize(350,350);
		charTiger.setSize(350,350);
		charDeer.setSize(350,350);
		charMonkey.setSize(350,350);
		charOrang.setSize(350,350);
		charGorilla.setSize(350,350);
		charDonkey.setSize(350,350);
		charFish.setSize(350,350);
		
		dogLabel = new GLabel("Dog", 25, 225);
		tigerLabel = new GLabel("Tiger", 200, 225);
		deerLabel =  new GLabel("Deer", 375, 225);
		fishLabel = new GLabel("Fish", 550, 225);
		monkeyLabel = new GLabel("Monkey", 25, 525);
		gorillaLabel = new GLabel("Gorilla", 200, 525);
		orangLabel =  new GLabel("Orangutan", 375, 525);
		donkeyLabel =  new GLabel("Donkey", 550, 525);
		
		monkeyLabel.setFont(LABEL_FONT);
		gorillaLabel.setFont(LABEL_FONT);
		orangLabel.setFont(LABEL_FONT);
		dogLabel.setFont(LABEL_FONT);
		tigerLabel.setFont(LABEL_FONT);
		deerLabel.setFont(LABEL_FONT);
		fishLabel.setFont(LABEL_FONT);
		donkeyLabel.setFont(LABEL_FONT);
		
		monkeyLabel.setColor(Color.DARK_GRAY);
		gorillaLabel.setColor(Color.LIGHT_GRAY);
		orangLabel.setColor(Color.ORANGE);
	}
	
	public char getChar()
	{
		if(monkey)
		{
			return 'm';
		}
		else if(gorilla)
		{
			return 'g';
		}
		else if(orang)
		{
			return 'o';
		}
		return ' ';
	}

	@Override
	public void showContents() {
		program.add(para);
		program.add(rect);
		//program.add(charOrang);
		//program.add(charGorilla);
		//program.add(charMonkey);
		program.add(fishLabel);
		program.add(donkeyLabel);
		program.add(dogLabel);
		program.add(tigerLabel);
		program.add(deerLabel);
		program.add(gorillaLabel);
		program.add(monkeyLabel);
		program.add(orangLabel);
	}

	@Override
	public void hideContents() {
		program.remove(para);
		program.remove(rect);
		program.remove(fishLabel);
		program.remove(donkeyLabel);
		program.remove(gorillaLabel);
		program.remove(monkeyLabel);
		program.remove(orangLabel);
		program.remove(charOrang);
		program.remove(charGorilla);
		program.remove(charMonkey);
		program.remove(charSelect);
		program.remove(next);
		program.remove(display);	
		program.remove(dogLabel);	
		program.remove(tigerLabel);	
		program.remove(deerLabel);	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (display!= null) {
			program.remove(display);
			
		}
		if (charSelect.isVisible()) {
			program.remove(charSelect);
			program.remove(next);
		}
		
		if (obj == charOrang || obj == orangLabel) {
			//charSelect = new GButton("SELECTED", 1054, 575, 100, 50);
			display = charOrang;
			orang = true;
			choice = 3;
		}
		if (obj == charGorilla || obj == gorillaLabel) {
			//charSelect = new GButton("SELECTED", 703, 575, 100, 50);
			display = charGorilla;
			gorilla = true;
			choice = 2;
		}
		if (obj == charMonkey || obj == monkeyLabel) {
			//charSelect = new GButton("SELECTED", 384, 575, 100, 50);
			display = charMonkey;
			monkey = true;
			choice = 1;
		}
		if (obj == tigerLabel) {
			display = charTiger;
			monkey = true;
			choice = 4;
		}
		if (obj == deerLabel) {
			display = charDeer;
			monkey = true;
			choice = 5;
		}
		if (obj == dogLabel) {
			display = charDog;
			monkey = true;
			choice = 6;
		}
		if (obj == fishLabel) {
			display = charFish;
			monkey = true;
			choice = 7;
		}
		if (obj == donkeyLabel) {
			display = charDonkey;
			monkey = true;
			choice = 8;
		}
		program.add(display);
		charSelect.setFillColor(Color.RED);
		next.setFillColor(Color.RED);
		program.add(charSelect);
		program.add(next);
		
		if (charSelect.isVisible()) {
			program.add(next);
		}
		if (obj == next) {
			LevelSelectPane levelSelect = new LevelSelectPane(program, choice);
			program.switchToLevelSelect(levelSelect);
		}
		if (obj == rect) {
			program.switchToMenu();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
