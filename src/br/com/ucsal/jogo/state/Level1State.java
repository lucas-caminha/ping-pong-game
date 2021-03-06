package br.com.ucsal.jogo.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import br.com.ucsal.jogo.Jogo;
import br.com.ucsal.jogo.input.KeyManager;

public class Level1State implements State {
	
	private Rectangle ball = new Rectangle(Jogo.width/2 - 5, Jogo.height/2 - 5, 10, 10);
	private int x = 0, y = 0, movex = 1, movey = 1;
	private Rectangle p1 = new Rectangle(0, 0, 10, 50);
	private Rectangle p2 = new Rectangle(Jogo.width-10, 0, 10, 50);
	
	private int score1 = 0, score2 = 0;

	@Override
	public void init() {
			start();
	}
	
	public void start() {
		ball.x = Jogo.width/2 - 5;
		ball.y = Jogo.height/2 - 5;
		
		Random r = new Random();
		movex = (r.nextInt(2) == 0) ? 2 : -2;
		movey = (r.nextInt(2) == 0) ? 2 : -2;
	}

	@Override
	public void update() {
		ball.x += movex;
		ball.y += movey;
		
		limitsBall();
		
		if (KeyManager.w) {
			p1.y -= 8;
		}
		if (KeyManager.s) {
			p1.y += 8;
		}
		if (KeyManager.up) {
			p2.y -= 8;
		}
		if (KeyManager.down) {
			p2.y += 8;
		}
		
		limitsPlayers();

	}

	private void limitsPlayers() {
		if (p1.y < 0) {
			p1.y = 0;
		}
		if (p1.y > Jogo.height - p1.height) {
			p1.y = Jogo.height - p1.height;
		}
		if (p2.y < 0) {
			p2.y = 0;
		}
		if (p2.y > Jogo.height - p2.height) {
			p2.y = Jogo.height - p2.height;
		}
		
	}

	private void limitsBall() {
		if (ball.x+15 > Jogo.width) {
			score1++;
			start();
		}
		if (ball.y+15 > Jogo.height) {
			movey = -2;
		}
		if (ball.x < 0) {
			score2++;
			start();
		}
		if (ball.y < 0) {
			movey = 2;
		}
		if (p1.intersects(ball) || p2.intersects(ball)) {
			movex *= -1;
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Jogo.width, Jogo.height);
		g.setColor(Color.WHITE);
		
		Font fonte = new Font("Dialog", Font.BOLD, 12);
		g.setFont(fonte);
		
		String player1 = "Player 1: " + score1;
		g.drawString(player1, Jogo.width * 1/4 - g.getFontMetrics().stringWidth(player1)/2,
				g.getFontMetrics(fonte).getHeight());
		
		String player2= "Player 2: " + score2;
		g.drawString(player2, Jogo.width * 3/4 - g.getFontMetrics().stringWidth(player2)/2,
				g.getFontMetrics(fonte).getHeight());
		
		g.fillRect(Jogo.width/2 - 3, 0, 6, Jogo.width);
		
		g.fillRect(ball.x, ball.y, ball.width, ball.height);
		g.fillRect(p1.x, p1.y, p1.width, p1.height);
		g.fillRect(p2.x, p2.y, p2.width, p2.height);
	}

	@Override
	public void KeyPressed(int cod) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void KeyReleased(int cod) {
		// TODO Auto-generated method stub
		
	}

}
