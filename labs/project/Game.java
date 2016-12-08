package project;

import java.awt.Color;
import java.util.Iterator;
import java.util.LinkedList;

import sedgewick.StdDraw;

/**
 * Plays game by using all created objects and Moveable interface
 * @author Zachary Polsky
 *
 */
public class Game {

	private LinkedList<Alien> aliens;
	private LinkedList<Moveable> move;
	private LinkedList<Bullet> bullets;
	private Player player;
	private double alienSpeed;
	private int score;
	private PowerUp powerup;
	private Mothership mothership;

	public Game() {
		aliens = new LinkedList<Alien>();
		move = new LinkedList<Moveable>();
		bullets = new LinkedList<Bullet>();
		StdDraw.setScale(-1, 1);
		player = new Player(0, -.9, .04, 3);
		move.add(player);
		alienSpeed = 0.04;
		addAliens();
		score = 0;
		powerup = new PowerUp();
		mothership = new Mothership(0.5, 0.9, .15);
	}

	/**
	 * Initializes the board, with a blank back background 
	 * @param score score of the player that will be updated
	 */
	public void drawBoard(int score) {
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(0, 0, 1, 1);
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.text(0.75, 0.9, "Score: " + score);
	}

	/**
	 * Checks whether the game is over
	 * @return true if the player has 0 lives
	 */
	public boolean isOver() {
		return (!(player.getLives() > 0));
	}

	/**
	 * Adds the aliens to the board
	 */
	public void addAliens(){
		addAlien(0.5, 0.5, alienSpeed, true);
		addAlien(-0.5, 0.5, alienSpeed, true);
		addAlien(-0.9, 0.5, alienSpeed, false);
	}
	
	private void addMothership(){
		if (mothership.isCollision() == false){
			mothership.draw();
			mothership.move();
		}
	}
	
	private void addPowerUp(){
		if(powerup.checkCollision(player) == false){
			powerup.draw();
		}
		else if (powerup.isApplied() == false){
			powerup.addPlayerAbility(player);
			powerup.addMothershipAbility(mothership);
		}
	}
	
	/**
	 * Resets the powerups after leveling up
	 */
	private void resetPowerUp(){
		powerup.setApplied(false);
		powerup.setCollision(false);
		powerup.draw();
	}
	
	/**
	 * Resets the mothership after leveling up
	 */
	private void resetMothership(){
		mothership.setDead(false);
		mothership.setCollision(false);
		mothership.draw();
	}
	
	

	/**
	 * Adds new aliens to the list of aliens
	 * @param x x-position of aliens 
	 * @param y y-position of aliens
	 * @param speed speed of aliens
	 * @param upDown whether the alien moves vertically
	 */
	private void addAlien(double x, double y, double speed, boolean upDown)
	{
		Alien a = new Alien(x, y, speed, upDown);
		aliens.add(a);
		move.add(a);
	}
	
	



	public void play(){
		// Draws the board with the score initialized. Implements the Moveable interface
		drawBoard(score);
		for (Moveable m : move) {
			m.move();
			m.draw();
		}

		// If the bullets list is less than 3, than a new bullet will be generated if the "w" key is pressed
		if (player.fire() && bullets.size() < 3) {
			Bullet b = new Bullet(player.getPosX(), player.getPosY() + .15, .05);
			move.add(b);
			bullets.add(b);
		}

	
		addMothership(); // add the mothership to the board
		addPowerUp();// add the powerup to the board
		//
		/*CODE A*/ // start
		for (Bullet b: bullets){
			if (b.hitMothership(mothership) && mothership.isDead() == false){ // if the mothership is hit, kill it and get extra points
				score+= 100;
				mothership.dead();
				mothership.setCollision(true);
				b.setOffScreen();
			}
			else if (b.getPosY() >= 1) {
				b.setOffScreen();
			}

			for (Alien a : aliens) {
				if (player.collide(a)) { // if an alien is hit, kill it and get the point bonus
					player.die();
					score -= 10;
				}
				if (b.collide(a) ) {
					a.die();
					b.setOffScreen();
					score += 50;
				}
				else if (b.getPosY() >= 1) { // if the bullet hits nothing, set it off 
					b.setOffScreen();
				}

			}
		}

		/*CODE A*/ //end

		// Used to prevent concurrent modification errors
		Iterator<Alien> alienIter = aliens.iterator();
		while (alienIter.hasNext()) {
			Alien a = alienIter.next();
			if (!a.isAlive()) {
				alienIter.remove();
				move.remove(a);
			}
		}

		Iterator<Bullet> bulletIter = bullets.iterator();
		while (bulletIter.hasNext()) {
			Bullet b = bulletIter.next();
			if (b.getIsOffScreen()) {
				bulletIter.remove();
				move.remove(b);
			}
		}


		// Calls the levelUp method. If all aliens have been eliminated, the board is reset and faster aliens are generated
		levelUp();
		StdDraw.show(60);

		if (isOver()){
			drawGameEnd();
		}
	}

	/**
	 * If all aliens and the mothership have been killed, this regenerates them and makes them faster to increase difficulty
	 */
	public void levelUp() {
		if (aliens.isEmpty() && mothership.isCollision() == true) {
			alienSpeed *= 1.5;
			mothership.setSpeed(mothership.getSpeed() * 1.25);
			addAliens();
			resetPowerUp();//resets powerup
			resetMothership();//brings back the mothership
			powerup.defaultSpeed(player); //resets the speed of the player to its initial speed at start of game
			for(Bullet b: bullets){
				b.setOffScreen();
			}
		}
	}

	/**
	 * Ends the game by showing a "GAME OVER" text
	 */
	public void drawGameEnd()
	{
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(0, 0, 1, 1);
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.text(0, 0, "GAME OVER");
		StdDraw.show(100);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
		while (!game.isOver()){
			game.play();
		}
	}
}
