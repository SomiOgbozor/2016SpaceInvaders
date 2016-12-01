package lab10;

import java.awt.Color;

import sedgewick.StdDraw;

public class SpaceInvaders {


	public static class Player implements Lives{
		private double[] position = new double[2];
		public int lives, score;
		private Bullet b;
		private boolean bulletActive;

		public Player(){
			this.position[0]=.5;
			this.position[1]=.03;
			this.lives = 3;
			this.bulletActive = false;
			this.score = 0;
		}
		double[] move(int key){
			if(key==ArcadeKeys.KEY_RIGHT&&this.position[0]<.95){
				this.position[0]=this.position[0]+.05;
			}
			if(key==ArcadeKeys.KEY_LEFT&&this.position[0]>.05){
				this.position[0]=this.position[0]-.05;
			}
			return this.position;
		}
		@Override
		public void loseLife() {
			this.lives = this.lives-1;
		}
		@Override
		public void gainLife() {
			this.lives = this.lives+1;
		}
		public void move(){
			if(ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_RIGHT)){
				this.move(ArcadeKeys.KEY_RIGHT);
				StdDraw.filledCircle(this.position[0], this.position[1], .03);
			}
			else if(ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_LEFT)){
				this.move(ArcadeKeys.KEY_LEFT);
				StdDraw.filledCircle(this.position[0], this.position[1], .03);
			}
			else{
				StdDraw.filledCircle(this.position[0], this.position[1], .03);
			}
			if(ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_UP)){
				this.b = new Bullet(this.position[0], this.position[1]);
				this.bulletActive = true;
			}
			if(this.bulletActive){
				if(this.b.collision == false && this.b.position[1]<1){
					this.b.moveUp();
				}
				else{
					this.bulletActive = false;
					this.b = new Bullet(this.position[0], this.position[1]);
				}
			}
			StdDraw.text(.8, .9, "Score:" +this.score);
			StdDraw.text(.05, .9, "Lives: "+this.lives);
		}


	}

	public static class Alien implements Lives{
		private double[] position = new double[2];
		private int lives;
		private int x, y;
		boolean special, dead;

		public Alien(int x, int y){
			this.lives = 1;
			this.position[0]= x*.1 +.05;
			this.position[1]= y*.1 +.25;
			this.x = x;
			this.y = y;
			if(Math.random()<.25){
				this.special = true;
			}
			else{
				this.special = false;
			}
		}

		public void moveRight(){
			this.position[0]= this.position[0]+.01;
		}
		public void moveLeft(){
			this.position[0] = this.position[0]-.01;
		}

		public void moveDown(){
			this.position[1] = this.position[1]-.001;
		}

		@Override
		public void loseLife() {
			this.lives--;
		}

		@Override
		public void gainLife() {
			this.lives++;
		}
		public void reset(){
			this.position[0] = x*.1+.05;
			this.position[1] = y*.1+.25;
		}


	}

	public static class Bullet{
		boolean collision;
		double[] position = new double[2];

		public Bullet(double x, double y){
			this.collision = false;
			this.position[0] = x;
			this.position[1] = y+.01;
		}

		public void moveUp(){
			this.position[1] = this.position[1]+.05;
			if(collision == false){
				StdDraw.filledCircle(this.position[0], this.position[1], .02);
			}

		}


	}
	public static class AlienField{
		private Alien[][] field = new Alien[9][7];
		boolean movingRight;
		public AlienField(){
			for(int i = 0; i<9; i++){
				for (int j = 0; j<7; j++){
					this.field[i][j] = new Alien(i, j);
				}
			}
			this.movingRight = true;
		}
		public void move(){
			for(int i = 0; i<9; i++){
				for (int j = 0; j<7; j++){
					if(this.field[i][j].position[0]>=.95){
						movingRight = false;
					}
					if(this.field[i][j].position[0]<=.05){
						movingRight = true;
						for(int k = 0; k<9; k++){
							for (int l = 0; l<7; l++){
								if(this.field[k][l].dead==false){
									this.field[k][l].moveDown();
								}

							}
						}
					}
				}
			}

			if(movingRight==true){
				for(int i = 0; i<9; i++){
					for (int j = 0; j<7; j++){
						if(this.field[i][j].dead == false){
							this.field[i][j].moveRight();
							if(this.field[i][j].special){
								StdDraw.setPenColor(Color.GREEN);
							}
							StdDraw.filledSquare(this.field[i][j].position[0], this.field[i][j].position[1], .03);
							StdDraw.setPenColor(Color.BLACK);
						}
					}
				}
			}
			if(movingRight==false){
				for(int i = 0; i<9; i++){
					for (int j = 0; j<7; j++){
						if(this.field[i][j].dead == false){
							this.field[i][j].moveLeft();
							if(this.field[i][j].special){
								StdDraw.setPenColor(Color.GREEN);
							}
							StdDraw.filledSquare(this.field[i][j].position[0], this.field[i][j].position[1], .03);
							StdDraw.setPenColor(Color.BLACK);
						}
					}
				}
			}

		}

	}
	public static class Board{
		private Player p1;
		private AlienField alienField;
		boolean collision;
		public Board(Player p1, AlienField alienField){
			this.p1 = p1;
			this.alienField = alienField;
			this.collision = false;
		}

		public void setBoard(){
			StdDraw.filledCircle(p1.position[0], p1.position[1], .03);
			for(int i = 0; i<9; i++){
				for (int j = 0; j<7; j++){
					if(alienField.field[i][j].dead==false){
						if(alienField.field[i][j].special){
							StdDraw.setPenColor(Color.GREEN);
						}
						StdDraw.filledSquare(alienField.field[i][j].position[0], alienField.field[i][j].position[1], .03);
						StdDraw.setPenColor(Color.BLACK);
					}
				}
			}
		}
		public void checkCollide(){
			for(int i = 0; i<9; i++){
				for (int j = 0; j<7; j++){
					if(Math.sqrt(Math.pow(alienField.field[i][j].position[0] - p1.position[0], 2) + Math.pow(alienField.field[i][j].position[1] - p1.position[1], 2)) < 0.05&&alienField.field[i][j].dead==false){
						this.collision = true;
					}
					if(p1.bulletActive&&Math.sqrt(Math.pow(alienField.field[i][j].position[0] - p1.b.position[0], 2) + Math.pow(alienField.field[i][j].position[1] - p1.b.position[1], 2)) < 0.05&&alienField.field[i][j].dead==false){
						p1.b.collision = true;
						alienField.field[i][j].loseLife();
						if(alienField.field[i][j].lives<1){
							alienField.field[i][j].dead = true;
						}
						p1.bulletActive = false;
						if(alienField.field[i][j].special){
							p1.score = p1.score + 2;
						}
						else{
							p1.score++;
						}

					}
				}
			}
			if(this.collision == true){

				p1.loseLife();
				for(int i = 0; i<9; i++){
					for (int j=0; j<7; j++){
						this.alienField.field[i][j].reset();
					}
				}
				this.collision = false;
			}
		}

		public boolean checkDead(){
			for(int i=0; i<9; i++){
				for(int j=0; j<7; j++){
					if(alienField.field[i][j].dead==false){
						return false;
					}
				}
			}
			return true;
		}
		public void gameOver(){
			StdDraw.clear();
			StdDraw.setPenColor(Color.RED);
			StdDraw.text(.5, .5, "Game Over!");
			StdDraw.text(.5, .25, "Score: "+p1.score);
		}

	}


	public static void main(String[] args){
		while(true){
			//Setting the board
			Player p = new Player();
			AlienField alienField = new AlienField();
			Board b = new Board(p, alienField);
			b.setBoard();
			//Movement
			while(b.p1.lives>0){
				//Player Movement
				StdDraw.clear();
				b.p1.move();
				//Alien Movement
				alienField.move();
				//Collision check
				b.checkCollide();
				if(b.checkDead()){
					alienField = new AlienField();
					b = new Board(p, alienField);
				}
				StdDraw.show(100);
			}
			//GAME OVER
			b.gameOver();
			StdDraw.show(10000);
		}

	}
}