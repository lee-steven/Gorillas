package project;

import java.awt.Color;

import sedgewick.StdDraw;

public class Gorilla implements Animation{

	public double x; 
	public double y;

	public Gorilla(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Interface; Draws out Gorilla (circle)
	 */
	public void anime() {
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.filledCircle(x, y, 0.05);
	}
}
