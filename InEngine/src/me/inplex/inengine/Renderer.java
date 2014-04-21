package me.inplex.inengine;

import me.inplex.inengine.entity.Entity;
import me.inplex.inengine.world.World;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class Renderer {
	World world = null;
	
	public void setWorld(World world){
		this.world = world;
	}
	
	public void render() {
		 GL11.glBegin(GL11.GL_TRIANGLES);
		 GL11.glColor3f(1f, 1f, 1f);
		for (Entity model : world.list){
			for (Vector3f face : model.getMesh().faces){
				GL11.glVertex3f(model.getMesh().vertexes.get((int) (face.x-1)).x, model.getMesh().vertexes.get((int) (face.x-1)).y, model.getMesh().vertexes.get((int) (face.x-1)).z);
				GL11.glVertex3f(model.getMesh().vertexes.get((int) (face.y-1)).x, model.getMesh().vertexes.get((int) (face.y-1)).y, model.getMesh().vertexes.get((int) (face.y-1)).z);
				GL11.glVertex3f(model.getMesh().vertexes.get((int) (face.z-1)).x, model.getMesh().vertexes.get((int) (face.z-1)).y, model.getMesh().vertexes.get((int) (face.z-1)).z);
			}
		}
		GL11.glEnd();
	}
	
}