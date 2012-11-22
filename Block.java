package tetris;

import java.awt.*;

public class Block {
	private Color fillColor;
	
	public Block(Color color) {
		this.fillColor = color;
	}
	
	public boolean isEmpty() {
		return (fillColor.equals(Color.WHITE));
	}
	
	// Each block is 25x25 pixels
	public void draw(int x, int y, Graphics g) {
		g.setColor(fillColor);
		g.fillRect(x*25, (y-1)*25, 25, 25);
	}
}
