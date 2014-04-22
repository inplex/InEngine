package me.inplex.inengine;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import me.inplex.inengine.entity.Entity;
import me.inplex.inengine.world.World;

import org.lwjgl.opengl.GL11;

public class Renderer {

	private World world;
	private Camera camera;

	public Renderer() {
		this.world = new World();
		this.camera = new Camera();
	}

	public void update() {
		camera.update();
	}
	
	public void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glLoadIdentity();
		glClearColor(0.2f, 0.2f, 0.6f, 1.0f);
		glRotatef(360 - camera.getRotation().x, 1.0f, 0.0f, 0.0f);
		glRotatef(360 - camera.getRotation().y, 0.0f, 1.0f, 0.0f);
		glTranslatef(camera.getTranslation().x, camera.getTranslation().y, camera.getTranslation().z);
		GL11.glColor3f(1f, 1f, 1f);
		for (Entity entity : world.list) {
			glColor3f(1f, 1f, 1f);
			glTranslatef(entity.getX(), entity.getY(), entity.getZ());
			entity.getMesh().render();
			glTranslatef(0, 0, 0);
		}

		glTranslatef(0, 0, 0);
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public World getWorld() {
		return world;
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

}