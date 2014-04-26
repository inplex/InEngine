package me.inplex.inengine.test;

import me.inplex.inengine.Game;
import me.inplex.inengine.entity.Entity;
import me.inplex.inengine.mesh.ObjLoader;

import org.lwjgl.LWJGLException;

public class TestGame extends Game {
	
	@Override
	protected void onInit() {
		Entity entity1 = new Entity(ObjLoader.load("res//test1.obj"), 0f, 1f, 0f);
		Entity entity2 = new Entity(ObjLoader.load("res//test2.obj"), 5f, 1f, 0f);
		Entity entity3 = new Entity(ObjLoader.load("res//test3.obj"), 10f, 1f, 0f);
		Entity entity4 = new Entity(ObjLoader.load("res//test4.obj"), 15f, 1f, 0f);
		getRenderer().getWorld().add(entity1);
		getRenderer().getWorld().add(entity2);
		getRenderer().getWorld().add(entity3);
		getRenderer().getWorld().add(entity4);
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