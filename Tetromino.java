package tetris;

public interface Tetromino {
	
	public void moveLeft(Block[][] grid);

	public void moveRight(Block[][] grid); 
	
	public boolean moveDown(Block[][] grid); 

	public void hardDrop(Block[][] grid); 

	public void rotate(Block[][] grid);
}
