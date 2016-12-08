package project;

import java.awt.Color;

import sedgewick.StdDraw;

public class Mothership implements Moveable {
	private double posX;
	private double posY;
	private double speed;
	private boolean collision;
	private boolean isDead;
	
	/**
	 * Creates a mothership object that will be used in the game
	 * @param posX the x-coordinate of the mothership
	 * @param posY the y-coordinate of the mothership
	 * @param speed the speed at which the mothership
	 */
	public Mothership(double posX, double posY, double speed) {
		this.posX = posX;
		this.posY = posY;
		this.speed = speed;
		this.collision = false;
		this.isDead = false;
	}
	

	/**
	 *Finds the x-coordinate of the mothership
	 * @return the mothership's x-coordinate
	 */
	public double getPosX() {
		return posX;
	}

	/**
	 * Finds the y-coordinate of the mothership
	 * @return the mothership's y-coordinate
	 */
	public double getPosY() {
		return posY;
	}
	
	/**
	 * Checks to see if the mothership collided with something
	 * @return the status of the collision boolean
	 */
	public boolean isCollision() {
		return collision;
	}
	
	/**
	 * A boolean that checks if the mothership has been killed by a bullet
	 * @return true if the mothership is dead, false otherwise
	 */
	public boolean isDead() {
		return isDead;
	}


	/**
	 * Get's the speed at which the mothership is moving
	 * @return the speed of the mothership
	 */
	public double getSpeed() {
		return speed;
	}

	/**
	 * Sets the speed of the mothership
	 * @param speed the speed the mothership will begin moving at
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}


	/**
	 * Sets the status of the collision boolean
	 * @param collision boolean that the collision will be set to
	 */
	public void setCollision(boolean collision) {
		this.collision = collision;
	}
	
	/**
	 * Sets the status of the dead boolean
	 * @param isDead boolean that the isDead boolean will be set to
	 */
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	
	/**
	 * Checks whether the mothtership is dead or not. Always true when called.
	 */
	public void dead(){
			this.isDead = true;
		}


	@Override
	/**
	 * Controls the movement of the mothership
	 */
	public void move() {
		this.posX = this.posX + this.speed;
		if (this.posX > 0.95 || this.posX < -0.9){
			this.speed = this.speed * -1;
		}
	}


	@Override
	/**
	 * Draws the mothership
	 */
	public void draw() {
		StdDraw.setPenColor(Color.RED);
		StdDraw.filledSquare(this.posX, this.posY, .05);
		
	}

	

}
