package me.inplex.inengine;

import me.inplex.inengine.entity.Entity;
import me.inplex.inengine.world.World;

import org.lwjgl.opengl.GL11;

public class Renderer {
	World world = null;
	
	public void setWorld(World world){
		this.world = world;
	}
	
	public void render() {
		 GL11.glBegin(GL11.GL_TRIANGLES);
		 GL11.glColor3f(1f, 1f, 1f);
		for (Entity model : world.list){

		}
		GL11.glEnd();
	}
	
}