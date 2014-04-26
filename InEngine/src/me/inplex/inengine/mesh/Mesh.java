package me.inplex.inengine.mesh;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glNormal3f;
import static org.lwjgl.opengl.GL11.glVertex3f;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class Mesh {

	private static int lastId = 0;

	private List<Face> faces;

	private int id;

	public Mesh() {
		this.faces = new ArrayList<Face>();
		this.id = lastId++;
	}

	// TODO: Make this better (use VBO, VertexAttribArray)
	public void render() {
		
		glColor3f(1f, 1f, 1f);
		for (Face face : faces) {
			glColor3f(1f, 1f, 1f);
			GL11.glBegin(face.isEdge() ? GL11.GL_TRIANGLES : GL11.GL_QUADS);
			for (int i = 0; i < (face.isEdge() ? 2 : 3); i++) {
				Vector3f vertex = face.getVertices()[i];
				GL11.glVertex3f(vertex.x, vertex.y, vertex.z);
				if (face.hasNormals() && i < 3) {
					Vector3f normal = face.getNormals()[i];
					GL11.glVertex3f(normal.x, normal.y, normal.z);
				}
			}
		}
		
		// Draw Outline
		glColor3f(0f, 0f, 0f);
		for (Face face : faces) {
			glColor3f(0f, 0f, 0f);
			GL11.glBegin(GL11.GL_LINES);
			for (int i = 0; i < (face.isEdge() ? 2 : 3); i++) {
				Vector3f vertex = face.getVertices()[i];
				GL11.glVertex3f(vertex.x, vertex.y, vertex.z);
				if (face.hasNormals() && i < 3) {
					Vector3f normal = face.getNormals()[i];
					GL11.glVertex3f(normal.x, normal.y, normal.z);
				}
			}
			GL11.glEnd();
		}
		glColor3f(1f, 1f, 1f);
	}
	
	public void render2() {
		glColor3f(1f, 1f, 1f);
		glBegin(GL_TRIANGLES);
		for (Face face : faces) {
			if(face.hasNormals()) {
				Vector3f n1 = face.normals[0];
				glNormal3f(n1.x, n1.y, n1.z);
			}
			Vector3f v1 = face.vertices[0];
			glVertex3f(v1.x,v1.y,v1.z);
			if(face.hasNormals()) {
				Vector3f n2 = face.normals[1];
				glNormal3f(n2.x, n2.y, n2.z);
			}
			Vector3f v2 = face.vertices[1];
			glVertex3f(v2.x,v2.y,v2.z);
			if(face.hasNormals()) {
				Vector3f n3 = face.normals[2];
				glNormal3f(n3.x, n3.y, n3.z);
			}
			Vector3f v3 = face.vertices[2];
			glVertex3f(v3.x,v3.y,v3.z);
		}
		glEnd();
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