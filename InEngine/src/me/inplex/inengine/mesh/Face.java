package me.inplex.inengine.mesh;

import org.lwjgl.util.vector.Vector3f;

public class Face {

	Vector3f[] vertices = new Vector3f[4];

	boolean isEdge() {
		return vertices[3] == null;
	}
	
	boolean isSurface() {
		return !isEdge();
	}

	public void setVertex(int index, Vector3f vector) {
		vertices[index] = vector;
	}

	public Vector3f[] getVertices() {
		return vertices;
	}

	public void setVertices(Vector3f[] vertices) {
		this.vertices = vertices;
	}

}
