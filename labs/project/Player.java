package project;

import java.awt.Color;

import sedgewick.StdDraw;

public class Player implements Moveable {
	
	private double posX;
	private double posY; 
	private final double startPosX;
	private final double startPosY;
	private final double width = 0.1;
	private final double height = 0.1;
	private Color color;
	private int lives;
	private double speed;
	


	private final Color [] colors = {StdDraw.RED, StdDraw.YELLOW, StdDraw.WHITE};
	
	/**
	 * Creates a Player object to be implemented in the game
	 * @param x- x-coordinate of player (center)
	 * @param y- y-coordinate of player (center)
	 * @param speed- speed at which the player moves 
	 * @param lives- number of lives the player starts with
	 */
	public Player(double x, double y, double speed, int lives) {
		this.posX = x;
		this.posY = y;
		this.startPosX = x;
		this.startPosY = y;
		this.speed = speed;
		this.lives = lives;
		this.color = colors[(this.lives-1) % 3];
	}
	
	/**
	 * Animates the player
	 */
	public void draw() {
		StdDraw.setPenColor(this.color);
		StdDraw.filledRectangle(this.posX, this.posY, this.width/2, this.height/2);
		StdDraw.filledRectangle(this.posX, (this.posY + this.height/1.5), this.width/6, this.height/2);
	}
	
	/**
	 * Method that moves the player across the screen
	 */
	public void move() {
		
		//If movements are possible:
		if ((ArcadeKeys.isKeyPressed(0, 1)) && (this.posX - this.speed > -1)) {
			this.posX -= this.speed;
		}
		else if ((ArcadeKeys.isKeyPressed(0, 3)) && (this.posX + this.speed < 1)) {
			this.posX += this.speed;
		}
	}
	
	
	
	/**
	 * Finds and returns the x-coordinate of the player
	 * @return the x-coordinate of the player
	 */
	public double getPosX() {
		return this.posX;
	}
	
	

	/**
	 * Finds and returns the y-coordinate of the player
	 * @return the y-coordinate of the player
	 */
	public double getPosY() {
		return this.posY;
	}
	
	/**
	 * Gets the number of lives the player has
	 * @return the number of lives
	 */
	public int getLives() {
		return this.lives;
	}
	
	/**
	 * Get the speed of the playet
	 * @return the player's speed
	 */
	public double getSpeed() {
		return speed;
	}
	
	/**
	 * Fires the bullet if the "w" key is pressed
	 * @return true if the key was pressed, false otherwise
	 */
	public boolean fire() {
		return (ArcadeKeys.isKeyPressed(0, 0)); //key w pushed
	}
	
	/**
	 * Kills player by reducing life and changing colors
	 */
	public void die() {
		this.lives--;
		if (lives != 0) {
			this.color = colors[lives - 1];
		}
		this.posX = this.startPosX;
		this.posY = this.startPosY; //doesn't do anything but good form
	}
	
	/**
	 * Sets the speed of the player to a new value
	 * @param speed new value of the player's speed
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	
	/**
	 * Determine if the player and alien collide based on comparing upper left and bottom right coordinates of each
	 * @param a- alien that player potentially collided with
	 * @return true if collision occurred
	 */
	public boolean collide(Alien a) {	
		double myTopLeftX = posX - width/2;
		double myTopLeftY = posY + height/2;
		double myBottomRightX = posX + width/2;
		double myBottomRightY = posY - height/2;
		
		double otherTopLeftX = a.getPosX() - a.getWidth()/2;
		double otherTopLeftY = a.getPosY() + a.getHeight()/2;
		double otherBottomRightX = a.getPosX() + a.getWidth()/2;
		double otherBottomRightY = a.getPosY() - a.getHeight()/2;
		
		return (myTopLeftY >= otherBottomRightY && myBottomRightY <= otherTopLeftY && myBottomRightX >= otherTopLeftX && myTopLeftX <= otherBottomRightX);
	}

}
