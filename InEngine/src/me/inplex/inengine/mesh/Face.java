package me.inplex.inengine.mesh;

import org.lwjgl.util.vector.Vector3f;

public class Face {

	Vector3f[] vertex = new Vector3f[3];

	boolean isEdge(){
		return (vertex[3]==null);
	}

	public void vectorSet(int n,Vector3f vector){
		vertex[n] = vector;
	}

}
