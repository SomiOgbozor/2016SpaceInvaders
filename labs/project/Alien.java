package project;

import sedgewick.StdDraw;

public class Alien implements Moveable {
	
	private double posX;
	private double posY;
	private final double startX;
	private final double startY;
	private final double width = 0.15;
	private final double height = 0.15;
	private double speed;	
	private boolean upDown;
	private boolean isAlive = true;
	
	/**
	 * Creates an Alien object to be implemented in the game
	 * @param x- x-coordinate of alien (center)
	 * @param y- y-coordinate of alien (center)
	 * @param speed- speed at which the alien moves 
	 * @param upDown- true if alien moves up/down pattern; false if alien moves side-to-side pattern
	 */
	public Alien(double x, double y, double speed, boolean upDown) {
		this.posX = x;
		this.posY = y;
		this.startX = x;
		this.startY = y;
		this.speed = -speed;
		this.upDown = upDown;
	}
	
	/**
	 * Find and return the x-coordinate of an alien
	 * @return the alien's x-coordinate
	 */
	public double getPosX() {
		return this.posX;
	}
	
	/**
	 * Find and return the y-coordinate of an alien
	 * @return the alien's y-coordinate
	 */
	public double getPosY() {
		return this.posY;
	}
	
	/**
	 * Find and return the width of an alien
	 * @return the alien's width
	 */
	public double getWidth() {
		return this.width;
	}
	
	/**
	 * Find and return the height of an alien
	 * @return the alien's height
	 */
	public double getHeight() {
		return this.height;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	/**
	 * Draws the visual representation of the alien
	 */
	public void draw() {
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(this.posX, this.posY, this.width/2, this.height/2);
	}
	
	/**
	 * Method that moves the alien around the screen
	 */
	public void move() {
		if (isOffScreen()) {
			speed *= -1;
		}
		if (upDown) {
			this.posY += speed;
		} else {
			this.posX += speed;
		}

	}
	
	

	/**
	 * Finds if the alien is going off the screen
	 * @return true or false if the alien is going off the screen
	 */
	public boolean isOffScreen() {
		return (this.posX > 1 || this.posX < -1 || this.posY > 1 || this.posY < -1);
	}
		
	/**
	 * Sets the initial position of the aliens
	 */
	public void moveToStart() {
		this.posX = startX;
		this.posY = startY;
	}
	
	/**
	 * Returns whether the alien is alive or not. If not, it will no longer be displayed
	 * @return
	 */
	public boolean isAlive() {
		return this.isAlive;
	}
	
	/**
	 * Checks whether the alien died
	 */
	public void die() {
		this.isAlive = false;
	}
	

}
