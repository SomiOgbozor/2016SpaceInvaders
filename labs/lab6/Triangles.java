package lab6;

import java.awt.Color;

import sedgewick.StdDraw;

public class Triangles {

	public static void triangle(double lcx, double lcy, double size)
	{
		if (size < 0.025){
			return;
		}
		StdDraw.setPenColor(Color.BLACK);
	StdDraw.line(lcx, lcy, lcx + size, lcy);
	StdDraw.line(lcx, lcy, lcx + size/2, lcy + size);
	StdDraw.line(lcx + size/2, lcy + size, lcx + size, lcy);
		
		triangle(lcx, lcy, size/2);
		triangle(lcx + size/2, lcy, size/2);
		triangle(lcx + size/4, lcy + size/2, size/2);
	}
	public static void main(String[] args) {
		triangle(0,0,1);
	}
}
