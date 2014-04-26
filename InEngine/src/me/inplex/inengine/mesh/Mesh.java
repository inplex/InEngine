package me.inplex.inengine.mesh;

import static org.lwjgl.opengl.GL11.glColor3f;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class Mesh {

	private static int lastId = 0;
	
	private List<Vector3f> vertices;
	private List<Vector3f> normals;
	private List<Face> faces;

	private int id;

	public Mesh() {
		this.vertices = new ArrayList<Vector3f>();
		this.normals = new ArrayList<Vector3f>();
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
				Vector3f vertex = vertices.get(face.getVertexIds()[i]-1);
				GL11.glVertex3f(vertex.x, vertex.y, vertex.z);
				if (face.hasNormals() && i < 3) {
					Vector3f normal = vertices.get(face.getNormalIds()[i]-1);
					GL11.glVertex3f(normal.x, normal.y, normal.z);
				}
			}
			GL11.glEnd();
		}
		
		// Draw Outline
		glColor3f(0f, 0f, 0f);
		for (Face face : faces) {
			glColor3f(0f, 0f, 0f);
			GL11.glBegin(GL11.GL_LINES);
			for (int i = 0; i < (face.isEdge() ? 2 : 3); i++) {
				Vector3f vertex = vertices.get(face.getVertexIds()[i]-1);
				GL11.glVertex3f(vertex.x, vertex.y, vertex.z);
				if (face.hasNormals() && i < 3) {
					Vector3f normal = vertices.get(face.getNormalIds()[i]-1);
					GL11.glVertex3f(normal.x, normal.y, normal.z);
				}
			}
			GL11.glEnd();
		}
		glColor3f(1f, 1f, 1f);
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

	public List<Vector3f> getVertices() {
		return vertices;
	}

	public void setVertices(List<Vector3f> vertices) {
		this.vertices = vertices;
	}

	public List<Vector3f> getNormals() {
		return normals;
	}

	public void setNormals(List<Vector3f> normals) {
		this.normals = normals;
	}

}