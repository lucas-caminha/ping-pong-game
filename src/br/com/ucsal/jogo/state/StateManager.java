package br.com.ucsal.jogo.state;

import java.awt.Graphics;

public class StateManager {
	
	public static final int numberStates = 2;
	public static State[] states = new State[numberStates];
	public static int currentState = 0;
	
	public static void setState(int state) {
		currentState = state;
		states[currentState].init();
	}
	
	public StateManager() {
		states[0] = new FPSState();
		
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
	
}
