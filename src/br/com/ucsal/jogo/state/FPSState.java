package br.com.ucsal.jogo.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import br.com.ucsal.jogo.Jogo;

public class FPSState implements State {

	private long now, lastTime = System.nanoTime();
	private double timer = 0;
	private int tick = 0;
	private int t = 0;
	
	@Override
	public void init() {
		
	}

	@Override
	public void update() {
		now = System.nanoTime();
		timer += now - lastTime;
		lastTime = now;
		tick++;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Jogo.width, Jogo.height);
		
		if (timer >= 1000000000) {
			t = tick;
			tick = 0;
			timer = 0;
		}
		
		g.setColor(Color.WHITE);
		Font font = new Font("Serif", Font.PLAIN, 12);
		g.setFont(font);
		
		String text = "FPS: " + t;
		g.drawString(text, g.getFontMetrics().stringWidth(text), g.getFontMetrics(font).getHeight());
	}

	@Override
	public void KeyPressed(int cod) {
		System.out.println("Press: " + cod);
	}

	@Override
	public void KeyReleased(int cod) {
		System.out.println("Release: " + cod);
	}

}
