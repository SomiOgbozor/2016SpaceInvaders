package project;

import java.awt.Color;
import java.util.LinkedList;

import sedgewick.StdDraw;

public class PowerUp implements Moveable {
	private double posX, posY;
	private double speedVariable;
	private boolean collision;
	private boolean isApplied;
	private Color color;
	private Color[] colors = {StdDraw.BLUE, StdDraw.YELLOW, StdDraw.RED};
	

	/**
	 * The poweruo adds special abilities that the player can pick up during the game
	 */
	public PowerUp() {
		this.posX = (-1 + (2*Math.random()));
		this.posY = -0.9;
		this.collision = false;
		this.isApplied = false;
		this.color = colors[(int) (3 * Math.random())];
		this.speedVariable = 1.25;
	}

	/**
	 * Finds the x-coordinate of the powerup
	 * @return the powerup's x-coordinate
	 */
	public double getPosX() {
		return posX;
	}

	/**
	 *  Finds the y-coordinate of the powerup
	 * @return the powerup's y-coordinate
	 */
	public double getPosY() {
		return posY;
	}
	
	
	/**
	 * Set the speed variable to a new number
	 * @param speedVariable the new speed variable
	 */
	public void setSpeedVariable(double speedVariable) {
		this.speedVariable = speedVariable;
	}

	/**
	 * Get the speed variable that modify's the player's and mothership's speed
	 * @return
	 */
	public double getSpeedVariable() {
		return speedVariable;
	}

	@Override
	/**
	 * Draws the powerup on the screen
	 */
	public void draw() {
		StdDraw.setPenColor(this.color);
		StdDraw.filledSquare(this.posX, this.posY, .025);
	}
	
	/**
	 * This method adds the special abilities to the player.  Can increase speed, decrease speed, and decrease motherboard's speed
	 * @param p1 the Player
	 */
	public void addPlayerAbility(Player p1){
		if(this.color == StdDraw.BLUE && this.isApplied == false){
			p1.setSpeed(p1.getSpeed() * this.speedVariable);
			this.isApplied = true;
		}
		else if(this.color == StdDraw.RED){
			p1.setSpeed(p1.getSpeed() /this.speedVariable);
			this.isApplied = true;
		}
	}
	
	/**
	 * Resets the speed of the player to it's initial speed
	 * @param p1 the PLayer who's speed is being changed
	 */
	public void defaultSpeed(Player p1){
		if (this.color == StdDraw.BLUE){
			p1.setSpeed(p1.getSpeed()/this.speedVariable);
		}
		else if (this.color == StdDraw.RED){
			p1.setSpeed(p1.getSpeed() * this.speedVariable);
		}
	}
	
	/**
	 * Checks whether the powerup has been applied
	 * @return true if it has, false otherwise
	 */
	public boolean isApplied() {
		return isApplied;
	}

	/**
	 * Set whether the powerup has been applied
	 * @param isApplied boolean that changes whether the powerup has been applied
	 */
	public void setApplied(boolean isApplied) {
		this.isApplied = isApplied;
	}

	/**
	 * Adds the powerup that affects the mothership
	 * @param m mothership whose abilities are being modified
	 */
	public void addMothershipAbility(Mothership m){
		if (this.color == StdDraw.YELLOW){
			m.setSpeed(m.getSpeed() /this.speedVariable);
			this.isApplied = true;
		}
	}
	
	/**
	 * Set whether the player hits the powerup
	 * @param collision boolean that sets whether the collsion occurred
	 */
	public void setCollision(boolean collision) {
		this.collision = collision;
	}

	/**
	 * Uses the distance formula to check whether the player came in contact with a powerup
	 * @param p1 player that might have found powerup
	 * @return true if the player did find a powerup, false otherwise
	 */
	public boolean checkCollision(Player p1){
		if (Math.sqrt(Math.pow(this.posX - p1.getPosX(), 2) + Math.pow(this.posY - p1.getPosY(), 2)) < 0.025){
			this.collision = true;
		}
		return this.collision;
	}

	@Override
	public void move() {
	}


}


