package tetris;

import java.awt.*;

public class EmptyBlock extends Block {
	
	public EmptyBlock(Color color) {
		super(color);
	}
	
	// Empty blocks are identified by their color
	public void draw(int x, int y, Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x*25, (y-1)*25, 25, 25);
	}
}
