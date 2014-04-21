package me.inplex.inengine;

import org.lwjgl.LWJGLException;

public class TestGame extends Game {
	
	@Override
	protected void onInit() {
		
	}
	
	@Override
	protected void onExit() {
		
	}
	
	
	public static void main(String[] args) throws LWJGLException {
		TestGame g = new TestGame();
		g.setupDisplay("TestGame", 900, 600, false, true);
		g.start();
		// End of the Application reached
	}
	
}