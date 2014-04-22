package me.inplex.inengine.mesh;

import java.util.ArrayList;
import java.util.List;

public class Mesh {

	private static int lastId = 1;

	private List<Face> faces;

	/**
	 * Used for Array Buffers, Call List etc.
	 */
	private int id;

	public Mesh() {
		this.faces = new ArrayList<Face>();
		this.id = lastId++;
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