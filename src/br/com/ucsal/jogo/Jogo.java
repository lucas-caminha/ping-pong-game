package br.com.ucsal.jogo;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import br.com.ucsal.jogo.display.Display;
import br.com.ucsal.jogo.state.StateManager;

public class Jogo implements Runnable{
	
	private Display display;
	private Thread thread;
	private boolean running = false;
	
	public static int width = 400, height = 300;
	
	private StateManager stateManager;
	
	public Jogo() {
		this.display = new Display("Ping Pong", width, height);	
		this.stateManager = new StateManager();
	}

	@Override
	public void run() {
		init();
		int FPS = 60;
		double timePerTick = 1000000000 / FPS;
		double delta = 0;
		long now; 
		long lastTime = System.nanoTime();
		
		while(this.running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			lastTime = now;
			
			if (delta >= 1) {
				update();
				render();
				delta--;
			}
			
		}
		stop();
	}
	
	private void render() {
		BufferStrategy buffer = display.getBufferStrategy();
		if(buffer == null) {
			display.createBufferStrategy();
			buffer = display.getBufferStrategy();
		}
		
		Graphics g = buffer.getDrawGraphics();
		
		g.clearRect(0, 0, width, height);
		
		if(StateManager.getState() != null)
			stateManager.render(g);
		
		g.dispose();
		buffer.show();
	}

	private void update() {
		if (StateManager.getState() == null) {
			return ;
		}
		stateManager.update();
	}

	private void init() {
		
		
	}

	public synchronized void start() {
		if(thread != null) {
			return;
		}
		thread = new Thread(this);
		
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		if(thread == null) {
			return;
		}
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
