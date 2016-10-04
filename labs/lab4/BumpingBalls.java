package lab4;

import java.awt.Color;

import cse131.ArgsProcessor;
import sedgewick.StdDraw;

public class BumpingBalls {

	public static void main(String[] args) {

		ArgsProcessor ap = new ArgsProcessor(args);
		int numBalls = ap.nextInt("How many balls?");
		double[]posBallsx = new double[numBalls];
		double[]velBallsx = new double[numBalls];
		double[]posBallsy = new double[numBalls];
		double[]velBallsy = new double[numBalls];
		double[]radius = new double[numBalls];

		for (int i=0; i < numBalls; i++) {
			StdDraw.setPenColor(Color.BLUE);
			posBallsx[i] = Math.random();
			posBallsy[i] = Math.random();
			velBallsx[i] = (Math.random()/(100));
			velBallsy[i] = (Math.random()/100);

		}

		while (true) {
			StdDraw.clear();
			for (int j=0; j < numBalls; j++) {
				StdDraw.filledCircle(posBallsx[j], posBallsy[j], .05);
				posBallsx[j] = posBallsx[j] + velBallsx[j];
				posBallsy[j] = posBallsy[j] + velBallsy[j];

				if (posBallsx[j] > 1 || posBallsx[j] < 0) {
					velBallsx[j] = velBallsx[j]*-1;
				}
				if (posBallsy[j] > 1 || posBallsy[j] < 0) {
					velBallsy[j] = velBallsy[j]*-1;
				}
				for (int k=0; k < numBalls; k++) {
					double vely=0;
					double velx =0;
					double distance = Math.sqrt(Math.pow(posBallsx[j]-posBallsx[k], 2)+ Math.pow(posBallsy[j]-posBallsy[k], 2));
					if (distance <= 0.1) {
						velx= velBallsx[j];
						velBallsx[j]= velBallsx[k];
						velBallsx[k]= velx;
						
						vely= velBallsy[j];
						velBallsy[j]= velBallsy[k];
						velBallsy[k] = vely;
						
					
					}

				}
			}
			StdDraw.show(10);
		}

	}







}


