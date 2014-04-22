package me.inplex.inengine.mesh;

import static org.lwjgl.opengl.GL11.glColor3f;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class Mesh {

	private static int lastId = 1;

	private List<Face> faces;

	private int id;

	public Mesh() {
		this.faces = new ArrayList<Face>();
		this.id = lastId++;
	}

	public void render() {
		glColor3f(1f, 1f, 1f);
		GL11.glBegin(GL11.GL_QUADS);
		{
			for (Face face : faces) {
				for (int i = 0; i < (face.isEdge() ? 2 : 3); i++) {
					Vector3f vertex = face.getVertices()[i];
					GL11.glVertex3f(vertex.x, vertex.y, vertex.z);
					if (face.hasNormals() && i < 3) {
						Vector3f normal = face.getNormals()[i];
						GL11.glVertex3f(normal.x, normal.y, normal.z);
					}
				}
			}
		}
		GL11.glEnd();

		// Draw Outline
		glColor3f(0f, 0f, 0f);
		GL11.glBegin(GL11.GL_LINES);
		{
			for (Face face : faces) {
				for (int i = 0; i < (face.isEdge() ? 2 : 3); i++) {
					Vector3f vertex = face.getVertices()[i];
					GL11.glVertex3f(vertex.x, vertex.y, vertex.z);
					if (face.hasNormals() && i < 3) {
						Vector3f normal = face.getNormals()[i];
						GL11.glVertex3f(normal.x, normal.y, normal.z);
					}
				}
			}
		}
		GL11.glEnd();
	}

	public List<Face> getFaces() {
		return faces;
	}

	public void setFaces(List<Face> faces) {
		this.faces = faces;
	}

	public int getId() {
		return id;
	}

}