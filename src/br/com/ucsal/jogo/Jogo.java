package br.com.ucsal.jogo;

import br.com.ucsal.jogo.display.Display;

public class Jogo implements Runnable{
	
	private Display display;
	private Thread thread;
	private boolean running = false;
	
	public Jogo() {
		this.display = new Display("Ping Pong", 300, 300);		
	}

	@Override
	public void run() {
		
		int FPS = 60;
		double timePerTick = 1000000000 / 60;
		double delta = 0;
		long now; 
		long lastTime = System.nanoTime();
		
		while(this.running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			lastTime = now;
			
			if (delta >= 1) {
				System.out.println(delta);
				delta--;
			}
			
		}
		stop();
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
