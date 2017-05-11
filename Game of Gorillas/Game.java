package project;
import cse131.ArgsProcessor;
import sedgewick.StdDraw;
public class Game {
	public static void main(String[] args){
		Gameboard board = new Gameboard();
		ArgsProcessor ap = new ArgsProcessor(args);
		Gorilla gorillaKing = new Gorilla(0.1,board.getBuildings()[0] + 0.05); 
		Gorilla gorillaKong = new Gorilla(0.9,board.getBuildings()[4] + 0.05); 
		int points = -1;
			while(points<=0){
				points = ap.nextInt("Play to how many total points?");
			}
			Points calc = new Points(0,0,points);
			while(calc.getPoints1()<points && calc.getPoints2()<points){
			
				play(board, calc, gorillaKing, gorillaKong);
				int angle = -91;
				double velocity = -1;
				while(angle< -90 || angle>90){
					angle = ap.nextInt("Player 1 Angle:");
				}
				while(velocity<0){
					velocity = ap.nextDouble("Player 1 Velocity:");
				}
				int loopTracker = 0;
				Bananas banana = new Bananas(velocity, angle, gorillaKing, gorillaKong);
				while(loopTracker == 0){
					play(board, calc, gorillaKing, gorillaKong);
					loopTracker = banana.chchChanges(1, board);
					if(loopTracker == 2){
						calc.add1();
						StdDraw.clear();
						if(calc.getPoints1() == points){
							break;
						}
						board = new Gameboard();
						gorillaKing = new Gorilla(0.1,board.getBuildings()[0] + 0.05); 
						gorillaKong = new Gorilla(0.9,board.getBuildings()[4] + 0.05); 
					}
				}
				if(calc.getPoints1() == points){
					break;
				}
				play(board, calc, gorillaKing, gorillaKong);
				angle = -91;
				velocity = -1;
				if(calc.getPoints1() != points){
					while(angle< -90 || angle>90){
						angle = ap.nextInt("Player 2 Angle:");
					}
					while(velocity<0){
						velocity = ap.nextDouble("Player 2 Velocity:");
					}
					banana = new Bananas(velocity, angle, gorillaKong,gorillaKing);
					loopTracker = 0;
					while(loopTracker == 0){
						play(board, calc, gorillaKing, gorillaKong);
						loopTracker = banana.chchChanges(2,board);
						StdDraw.show();
						if(loopTracker == 2){
							calc.add2();
							StdDraw.clear();
							if(calc.getPoints2() == points){
								break;
							}
							StdDraw.clear();
							board = new Gameboard();
							gorillaKing = new Gorilla(0.1,board.getBuildings()[0] + 0.05); 
							gorillaKong = new Gorilla(0.9,board.getBuildings()[4] + 0.05); 
						}
					}
					if(calc.getPoints2() == points){
							break;
					}
					play(board, calc, gorillaKing, gorillaKong);
				}
			}
	}
	/**
	 * Short-hand to animate game(show,clear board,etc.)
	 * @param board
	 * @param calc
	 * @param gorillaKing
	 * @param gorillaKong
	 */
	public static void play(Gameboard board, Points calc, Gorilla gorillaKing, Gorilla gorillaKong){
		StdDraw.show(20);
		StdDraw.clear();
		board.anime();
		calc.anime();
		gorillaKing.anime();
		gorillaKong.anime();
		StdDraw.show();
	}
}
