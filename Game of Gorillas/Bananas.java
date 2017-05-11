package project;

import java.awt.Color;

import sedgewick.StdDraw;

public class Bananas{

	public double velocity;
	public double xVelocity;
	public double yVelocity;
	public int angle; 
	//(e)XPosition <-- GET IT???? ok....
	public double xPosition;
	public double yPosition;
	public Gorilla character;
	public double startingYPosition;
	public double time;
	private double gravity;
	private double otherGorillaXLocation;
	private double otherGorillaYLocation;
	//	hehe XD
	//	public String potassium;

	public Bananas(double velocity, int angle, Gorilla character1, Gorilla character2) {
		this.velocity = velocity;
		this.angle = angle;
		this.xVelocity = (this.velocity*Math.cos(this.angle*(Math.PI/180)))/1400;
		this.yVelocity = (this.velocity*Math.sin(this.angle*(Math.PI)/180))/1400;;
		//		this.potassium = potassium;
		this.xPosition = character1.x;
		this.yPosition = character1.y + 0.052;
		this.gravity = -9.3/10000;
		this.otherGorillaXLocation = character2.x;
		this.otherGorillaYLocation = character2.y;
	}

	/**
	 * 
	 * @param which Gorilla?
	 * @param board object Gameboard
	 * @return an int which that states what kind of collision Banana hit
	 */
	public int chchChanges(int which, Gameboard board){
		int check = 0;
		double distanceCollision = Math.sqrt(Math.pow(this.otherGorillaXLocation - this.xPosition,2) + Math.pow(this.otherGorillaYLocation - this.yPosition, 2));

		//Checking to see if x and y position outside boundaries
		for(int i=0; i<5; i++){
			if(xPosition > 0.2*i && xPosition < 0.2*i +0.2 && yPosition < board.getBuildings()[i]){
				check = 1;
			}

		}
		if(xPosition > 1|| yPosition < 0 || xPosition < 0 || distanceCollision<=0.060){
			check = 1;
			if(distanceCollision<=0.1){
				check = 2; 
			}
		}
		//Drawing out Banana
		StdDraw.setPenColor(Color.YELLOW);
		StdDraw.filledCircle(xPosition, yPosition, 0.010);
		//Updating position, velocity
		if(which == 1){
			this.xPosition = this.xPosition + this.xVelocity;
		}
		else{
			this.xPosition = this.xPosition - this.xVelocity;
		}
		this.yPosition = this.yPosition + this.yVelocity;
		this.yVelocity = this.yVelocity + this.gravity;
		return check;
	}
}
