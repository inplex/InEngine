package me.inplex.inengine.mesh;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector3f;

public class Mesh {

	List<Vector3f> vertexes = new ArrayList<Vector3f>();
	List<Vector3f> faces    = new ArrayList<Vector3f>();


	public void addVertex(Vector3f vertex){
		vertexes.add(vertex);
	}

	public void addFace(Vector3f face){
		faces.add(face);
	}

}
