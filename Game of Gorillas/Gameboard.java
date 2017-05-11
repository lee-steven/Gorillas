package project;
import java.awt.Color;
import sedgewick.StdDraw;

public class Gameboard implements Animation{

	private double buildingHeight;
	private double[] heights;
	private Color[] palette; 
	private int[] store;

	public Gameboard() {
		Color[] palette = {new Color(191,0,0), new Color(85,208,222), new Color(199,199,199)};
		this.palette = palette;
		this.heights = new double[5];
		this.store = new int[5];
		for(int i=0; i<this.heights.length; i++){
			this.buildingHeight = 0.05+Math.random()*0.725;
			this.heights[i] = buildingHeight;
		}
		for(int i=0; i<this.heights.length; i++){
			int chooseColor = (int)(Math.round(Math.random()*2));
			store[i] = chooseColor;
		}
	}

	/**
	 * Interface
	 */
	public void anime() {
		draw();
	}

	/**
	 * Draws out the buildings and sets their individual colors
	 */
	public void draw(){
		StdDraw.setPenColor(Color.BLUE);
		StdDraw.filledRectangle(0.5, 0.5, 0.5, 0.5);
		double centerRect = 0.1;
		for(int i=0; i<this.heights.length; i++){
			StdDraw.setPenColor(palette[store[i]]);
			StdDraw.filledRectangle(centerRect, this.heights[i]/2, 0.1, this.heights[i]/2);
			centerRect = centerRect + 0.2;
		}
	}

	/**
	 * 
	 * @return an array of building heights
	 */
	public double[]	getBuildings(){
		return heights;
	}

}
