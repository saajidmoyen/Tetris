package tetris;

import java.awt.*;

public class OBlock implements Tetromino {
	private int[] pOne = new int[2];
	private int[] pTwo = new int[2];
	private int[] pThree = new int[2];
	private int[] pFour = new int[2];

	private Block one = new Block(Color.YELLOW);
	private Block two = new Block(Color.YELLOW);
	private Block three = new Block(Color.YELLOW);
	private Block four = new Block(Color.YELLOW);

	public OBlock(Block[][] grid) {
		grid[4][0] = one;
		grid[4][0] = two;
		grid[5][0] = three;
		grid[5][0] = four;

		pOne[0] = 4;
		pOne[1] = 0;
		pTwo[0] = 4;
		pTwo[1] = 1;
		pThree[0] = 5;
		pThree[1] = 0;
		pFour[0] = 5;
		pFour[1] = 1;
	}

	public void moveLeft(Block[][] grid) {

		int[][] arr = {
				{pOne[0]-1,pOne[1]}, {pTwo[0]-1,pTwo[1]}, 
				{pThree[0]-1,pThree[1]}, {pFour[0]-1,pFour[1]},
		};
		if (!checkBlocks(grid, arr)) {
			return;
		}
		
		grid[pOne[0]][pOne[1]] = new EmptyBlock(Color.WHITE);
		grid[pTwo[0]][pTwo[1]] = new EmptyBlock(Color.WHITE);
		grid[pThree[0]][pThree[1]] = new EmptyBlock(Color.WHITE);
		grid[pFour[0]][pFour[1]] = new EmptyBlock(Color.WHITE);

		grid[pOne[0] - 1][pOne[1]] = one;
		grid[pTwo[0] - 1][pTwo[1]] = two;
		grid[pThree[0] - 1][pThree[1]] = three;
		grid[pFour[0] - 1][pFour[1]] = four;

		pOne[0] -= 1;
		pTwo[0] -= 1;
		pThree[0] -= 1;
		pFour[0] -= 1;
	}

	public void moveRight(Block[][] grid) {
		
		int[][] arr = {
				{pOne[0]+1,pOne[1]}, {pTwo[0]+1,pTwo[1]}, 
				{pThree[0]+1,pThree[1]}, {pFour[0]+1,pFour[1]},
		};
		if (!checkBlocks(grid, arr)) {
			return;
		}
		
		grid[pOne[0]][pOne[1]] = new EmptyBlock(Color.WHITE);
		grid[pTwo[0]][pTwo[1]] = new EmptyBlock(Color.WHITE);
		grid[pThree[0]][pThree[1]] = new EmptyBlock(Color.WHITE);
		grid[pFour[0]][pFour[1]] = new EmptyBlock(Color.WHITE);

		grid[pOne[0] + 1][pOne[1]] = one;
		grid[pTwo[0] + 1][pTwo[1]] = two;
		grid[pThree[0] + 1][pThree[1]] = three;
		grid[pFour[0] + 1][pFour[1]] = four;

		pOne[0] += 1;
		pTwo[0] += 1;
		pThree[0] += 1;
		pFour[0] += 1;
	}

	public boolean moveDown(Block[][] grid) {

		int[][] arr = {
				{pOne[0],pOne[1]+1}, {pTwo[0],pTwo[1]+1}, 
				{pThree[0],pThree[1]+1}, {pFour[0],pFour[1]+1},
		};
		if (!checkBlocks(grid, arr)) {
			return false;
		}

		grid[pOne[0]][pOne[1]] = new EmptyBlock(Color.WHITE);
		grid[pTwo[0]][pTwo[1]] = new EmptyBlock(Color.WHITE);
		grid[pThree[0]][pThree[1]] = new EmptyBlock(Color.WHITE);
		grid[pFour[0]][pFour[1]] = new EmptyBlock(Color.WHITE);

		grid[pOne[0]][pOne[1] + 1] = one;
		grid[pTwo[0]][pTwo[1] + 1] = two;
		grid[pThree[0]][pThree[1] + 1] = three;
		grid[pFour[0]][pFour[1] + 1] = four;

		pOne[1] += 1;
		pTwo[1] += 1;
		pThree[1] += 1;
		pFour[1] += 1;

		return true;
	}

	public void hardDrop(Block[][] grid) {
		while (moveDown(grid)) {
			moveDown(grid);
		}
	}

	public void rotate(Block[][] grid) {
		return;
	}

	private boolean checkBlocks(Block[][] grid, int[][] arr) {
		for (int x = 0; x < arr.length; x++) {
			if (arr[x][0] >= grid.length ||
					arr[x][0] < 0 ||
					arr[x][1] >= grid[x].length ||
					arr[x][1] < 0 ||
					!(grid[arr[x][0]][arr[x][1]].isEmpty() || 
							grid[arr[x][0]][arr[x][1]].equals(one) || 
							grid[arr[x][0]][arr[x][1]].equals(two) || 
							grid[arr[x][0]][arr[x][1]].equals(three) || 
							grid[arr[x][0]][arr[x][1]].equals(four))) {
				return false;
			}
		}

		return true;
	}
}
