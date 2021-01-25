/*
* WordSearch.java
* Author: Emily Ockerman
* Submission Date: November 30, 2018
*
* Purpose: For your computer to grow smarter by solving a word search through a formulaic, (hopefully) never-failing method, assuming user input is correct since I was not required to code for user error. :)
*
* Statement of Academic Honesty:
*
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with
* the University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based
* on a programming project created by the Department of
* Computer Science at the University of Georgia. Any publishing
* of source code for this project is strictly prohibited without
* written consent from the Department of Computer Science.
*/

import java.util.Scanner;

public class WordSearch {
	
	public long promptUserForSeed(Scanner input) 
	{
		System.out.println("Enter the seed for a 10x10 board.");
		Long seed = input.nextLong();
		return seed;
	}
	
	
	public WordBoard findWords (int rows, int cols, long seed) 
	{
		WordBoard board = new WordBoard(rows, cols, seed);
		String[] words = board.getDictionary();
		int maxRow = board.getBoard().length;
		int maxCol = board.getBoard()[0].length;
		
		for (String word : words) 
		{
			//scans through rows of 2D board array
			for(int row = 0; row < board.getBoard().length; row++)
			{
				//scans through columns of 2D board array
				for(int col = 0; col < board.getBoard()[row].length; col++)
				{
					//if the character matches the first letter of the word we're spotlighting in the string array...
					if(board.getBoard()[row][col] == word.charAt(0))
					{
						//search up, down, and to the side of that letter for the desired second letter
						int one = row;
						int two = col;
						int three = 0;
						int four = 0;
						
						//making sure it's not looking for something out of bounds
						if (col+1 < maxCol)
						{
							//searching in front of...
							int count = 1;
							for (int i = 1; i < word.length(); i++)
							{	
								if ((col+i < maxCol) && (board.getBoard()[row][col+i] == word.charAt(i)))
								{
									//System.out.println(board.getBoard()[row][col+i]);
									//System.out.println(word.charAt(i));
									count++;
									three = one;
									four = two+(word.length()-1);
								}
								if (count == word.length())
								{
									board.highlightWord(one, two, three, four);
									board.toString();
								}
							}
						}
						
						
						//making sure it's not looking for something out of bounds
						if (col-1 > 0)
						{
							//searching behind...
							int count = 1;
							for (int i = 1; i < word.length(); i++)
							{	
								if ((col-i > 0) && (board.getBoard()[row][col-i] == word.charAt(i)))
								{
									//System.out.println(board.getBoard()[row][col-i]);
									//System.out.println(word.charAt(i));
									count++;
									three = one;
									four = two-(word.length()-1);
								}
								if (count == word.length())
								{
									board.highlightWord(one, two, three, four);
									board.toString();
								}
							}
						}
						
				
						//making sure it's not looking for something out of bounds
						if (row+1 < maxRow)
						{
							//searching below...
							int count = 1;
							for (int i = 1; i < word.length(); i++)
							{
								if ((row+i < maxRow) && (board.getBoard()[row+i][col] == word.charAt(i)))
								{
									//System.out.println(board.getBoard()[row+i][col]);
									//System.out.println(word.charAt(i));
									count++;
									three = one+(word.length()-1);
									four = two;
								}
								if (count == word.length())
								{
									board.highlightWord(one, two, three, four);
									board.toString();
								}
							}
						}
						
						
						//making sure it's not looking for something out of bounds
						if (row-1 > 0)
						{
							//searching above...
							int count = 1;
							for (int i = 1; i < word.length(); i++)
							{
								if ((row-i > 0) && (board.getBoard()[row-i][col] == word.charAt(i)))
								{
									//System.out.println(board.getBoard()[row-i][col]);
									//System.out.println(word.charAt(i));
									count++;
									three = one-(word.length()-1);
									four = two;
								}
								if (count == word.length())
								{
									board.highlightWord(one, two, three, four);
									board.toString();
								}
							}
						}

						
						//searching diagonally...
						//making sure it's not looking for something out of bounds
						if (((row-1) > 0) && ((col-1) > 0))
						{
							//diagonal left and up
							int count = 1;
							for (int i = 1; i < word.length(); i++)
							{
								if ((row-i > 0) && (col-i > 0) && (board.getBoard()[row-i][col-i] == word.charAt(i)))
								{
									count++;
									three = one - (word.length()-1);
									four = two - (word.length()-1);
								}
								if (count == word.length())
								{
									board.highlightWord(one, two, three, four);
									board.toString();
								}
							}
						}
						
						
						//making sure it's not looking for something out of bounds
						if (((row-1) > 0) && ((col+1) < maxCol))
						{
							//diagonal right and up
							int count = 1;
							for (int i = 1; i < word.length(); i++)
							{
								if ((row-i > 0) && (col+i < maxCol) && (board.getBoard()[row-i][col+i] == word.charAt(i)))
								{
									count++;
									three = one - (word.length()-1);
									four = two + (word.length()-1);
								}
								if (count == word.length())
								{
									board.highlightWord(one, two, three, four);
									board.toString();
								}
							}
						}
						
						
						//making sure it's not looking for something out of bounds
						if (((row+1) < maxRow) && ((col-1) > 0))
						{
							//diagonal left and down
							int count = 1;
							for (int i = 1; i < word.length(); i++)
							{
								if ((row+i < maxRow) && (col-i > 0) && (board.getBoard()[row+i][col-i] == word.charAt(i)))
								{
									count++;
									three = one + (word.length()-1);
									four = two - (word.length()-1);
								}
								if (count == word.length())
								{
									board.highlightWord(one, two, three, four);
									board.toString();
								}
							}
						}
						
						
						//making sure it's not looking for something out of bounds
						if (((row+1) < maxRow) && ((col+1) < maxCol))
						{
							//diagonal right and down
							int count = 1;
							for (int i = 1; i < word.length(); i++)
							{
								if ((row+i < maxRow) && (col+i < maxRow) && (board.getBoard()[row+i][col+i] == word.charAt(i)))
								{
									count++;
									three = one + (word.length()-1);
									four = two + (word.length()-1);
								}
								if (count == word.length())
								{
									board.highlightWord(one, two, three, four);
									board.toString();
								}
							}
						}
					}
				}
			}
		}
		return board;
	}
	
	
	
	public static void main(String[] args) {
		
		//declaration and initiation of variables
		Scanner input = new Scanner(System.in);
		
		//CHANGE THESE IF U WANT TO CHANGE THE DIMENSIONS OF THE BOARD
		int rows = 10, cols = 10;
		WordSearch search = new WordSearch();
		long seed = search.promptUserForSeed(input);
		
		//method to find words
		WordBoard board = search.findWords(rows, cols, seed);
		
		//printing out new board with found words capitalized
		System.out.println(board + "\n");
		
		//checking answers
		board.checkAnswers();
	}
}
