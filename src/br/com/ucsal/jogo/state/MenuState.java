package br.com.ucsal.jogo.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import br.com.ucsal.jogo.Jogo;

public class MenuState implements State {
		
	private Font font1;
	private Font font2;
	private String[] options = {"JOGAR", "INFO", "SAIR"};
	private int choice = 0;

	@Override
	public void init() {
		font1 = new Font("Dialog", Font.PLAIN, 48);
		font2 = new Font("Dialog", Font.PLAIN, 24);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics g) {
		String titulo = "PING PONG";
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Jogo.width, Jogo.height);
		
		g.setColor(Color.WHITE);
		g.setFont(font1);
		g.drawString(titulo, Jogo.width / 2 - g.getFontMetrics().stringWidth(titulo)/2, Jogo.height * 1/4);
		
		g.setFont(font2);
		for(int i = 0; i < options.length; i++) {
			g.setColor(Color.WHITE);
			if(i == choice)
				g.setColor(Color.YELLOW);
			g.drawString(options[i], Jogo.width / 2 - g.getFontMetrics().stringWidth(options[i])/2, Jogo.height * 3/4 + g.getFontMetrics(font2).getHeight() * i);
		}
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
