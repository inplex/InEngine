package me.inplex.inengine.mesh;

import java.util.ArrayList;
import java.util.List;

public class Mesh {
	
	private List<Face> faces;
	
	public Mesh() {
		setFaces(new ArrayList<Face>());
	}

	public List<Face> getFaces() {
		return faces;
	}

	public void setFaces(List<Face> faces) {
		this.faces = faces;
	}

	
}