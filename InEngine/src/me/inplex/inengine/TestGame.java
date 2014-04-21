package me.inplex.inengine;

import me.inplex.inengine.entity.Entity;
import me.inplex.inengine.mesh.ObjLoader;
import me.inplex.inengine.world.World;

import org.lwjgl.LWJGLException;

public class TestGame extends Game {
	
	World world = new World();
	
	@Override
	protected void onInit() {
		getRenderer().setWorld(world);
		Entity entity1 = new Entity(ObjLoader.load("res//test1.obj"), 0f, 0f, 0f);
		Entity entity2 = new Entity(ObjLoader.load("res//test2.obj"), 50f, 0f, 0f);
		world.add(entity1);
		world.add(entity2);
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