package project;

import java.awt.Color;
import java.awt.Font;

import sedgewick.StdDraw;

public class Points implements Animation {
	private int points1;
	private int points2;
	private int totalPoints;

	public Points(int points1, int points2, int totalPoints) {
		this.points1 = points1;
		this.points2 = points2;
		this.totalPoints = totalPoints;		
	}

	public int getPoints1() {
		return points1;
	}

	public int getPoints2() {
		return points2;
	}

	/**
	 * adds points to player 1 and checks if total points equals to number of points needed to win. If so, animates Gameover screen 
	 */
	public void add1(){
		this.points1 = this.points1 + 1; 
		StdDraw.setPenColor(Color.WHITE);
		Font win = new Font("Arial", Font.BOLD, 12);
		StdDraw.setFont(win);
		StdDraw.text(0.5, 0.8, "Player 1 Wins!");
		StdDraw.pause(1000);

		//Redraw
		if(this.points1 == this.totalPoints){
			for(int i=1; i<26; i++){
				StdDraw.clear();
				StdDraw.setPenColor(Color.BLACK);
				StdDraw.filledRectangle(0.5, 0.5, 0.5, 0.5);
				StdDraw.setPenColor(Color.WHITE);
				Font gameOver = new Font("Arial", Font.BOLD, i);
				StdDraw.setFont(gameOver);
				StdDraw.text(0.5,0.6, "Player 1 Wins");
				StdDraw.text(0.5, 0.4, "GameOver!");
				StdDraw.show(15);
			}
			StdDraw.pause(1000);
		}
	}

	/**
	 * adds points to player 2 and checks if total points equals to number of points needed to win. If so, animates Gameover screen
	 */
	public void add2(){
		this.points2 = this.points2 + 1;
		StdDraw.setPenColor(Color.WHITE);
		Font win = new Font("Arial", Font.BOLD, 20);
		StdDraw.setFont(win);
		StdDraw.text(0.5, 0.8, "Player 2 Wins!");
		StdDraw.pause(1000);

		if(this.points2 == this.totalPoints){
			for(int i=1; i<26; i++){
				StdDraw.clear();
				StdDraw.setPenColor(Color.BLACK);
				StdDraw.filledRectangle(0.5, 0.5, 0.5, 0.5);
				StdDraw.setPenColor(Color.WHITE);
				Font gameOver = new Font("Arial", Font.BOLD, i);
				StdDraw.setFont(gameOver);
				StdDraw.text(0.5,0.6, "Player 2 Wins");
				StdDraw.text(0.5, 0.4, "GameOver!");
				StdDraw.show(10);
			}
			StdDraw.pause(1000);
		}
	}
	/**
	 * Draws Text Player 1 & 2 and their total Points
	 */
	public void anime() {
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.setFont();
		StdDraw.text(0.1, 0.95, "Player 1");
		StdDraw.text(0.1, 0.9, Integer.toString(this.points1));
		StdDraw.text(0.9, 0.95, "Player 2");
		StdDraw.text(0.9, 0.9, Integer.toString(this.points2));
	}
}
