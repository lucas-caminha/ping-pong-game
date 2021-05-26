package br.com.ucsal.jogo.state;

import java.awt.Graphics;

public interface State {
	void init();
	void update();
	void render(Graphics g);
}
