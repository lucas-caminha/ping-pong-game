package br.com.ucsal.jogo.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import br.com.ucsal.jogo.Jogo;

public class MenuState implements State {
		
	private Font font1;

	@Override
	public void init() {
		font1 = new Font("Dialog", Font.PLAIN, 48);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Jogo.width, Jogo.height);
		
		g.setColor(Color.WHITE);
		g.setFont(font1);
		g.drawString("PING PONG", Jogo.width / 2 - g.getFontMetrics().stringWidth("PING PONG")/2, Jogo.height * 1/4);
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
