package me.inplex.inengine.mesh;

import org.lwjgl.util.vector.Vector3f;

public class Face {

	Vector3f[] vertices;
	Vector3f[] normals;

	public Face() {
		vertices = new Vector3f[4];
		normals = new Vector3f[4];
	}
	
	public boolean isEdge() {
		return vertices[3] == null;
	}
	
	public boolean isSurface() {
		return !isEdge();
	}
	
	public boolean hasNormals() {
		return normals[0] != null;
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
	
	public void setNormal(int index, Vector3f vector) {
		normals[index] = vector;
	}

	public Vector3f[] getNormals() {
		return normals;
	}

	public void setNormals(Vector3f[] normals) {
		this.normals = normals;
	}

}
