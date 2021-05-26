package br.com.ucsal.jogo.state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StateManager implements KeyListener{
	
	public static final int numberStates = 2;
	public static State[] states = new State[numberStates];
	public static int currentState = 0;
	
	public static void setState(int state) {
		currentState = state;
		states[currentState].init();
	}
	
	public StateManager() {
		states[0] = new FPSState();
		states[1] = new MenuState();
		
	}
	
	public void update() {
		states[currentState].update();
	}
	
	public void render(Graphics g) {
		states[currentState].render(g);
	}
	
	public static State getState() {
		return states[currentState];
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		states[currentState].KeyPressed(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		states[currentState].KeyPressed(e.getKeyCode());
	}
	
}
