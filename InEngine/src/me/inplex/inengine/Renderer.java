package me.inplex.inengine;

import me.inplex.inengine.entity.Entity;
import me.inplex.inengine.mesh.Face;
import me.inplex.inengine.world.World;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class Renderer {
	World world = null;

	public void setWorld(World world) {
		this.world = world;
	}

	public void render() {
		GL11.glBegin(GL11.GL_TRIANGLES);
		GL11.glColor3f(1f, 1f, 1f);
		for (Entity entity : world.list) {
			for (Face face : entity.getMesh().getFaces()) {
				for (int i = 0; i < (face.isEdge() ? 2 : 3); i++) {
					Vector3f v = face.getVertices()[i];
					GL11.glVertex3f(v.x, v.y, v.z);
				}
			}
		}
		GL11.glEnd();
	}

}