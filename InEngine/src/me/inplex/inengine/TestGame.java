package me.inplex.inengine;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import me.inplex.inengine.entity.Entity;
import me.inplex.inengine.mesh.Mesh;
import me.inplex.inengine.mesh.ObjLoader;
import me.inplex.inengine.world.World;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class TestGame extends Game {
	
	World world = new World();

	
	@Override
	protected void onInit() {
		getRenderer().setWorld(world);
		Entity teapot = new Entity(ObjLoader.load("res//teapot.obj"));
		world.add(teapot);



		 GLU.gluPerspective (200f,800f/600f, 1f, 500.0f);
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