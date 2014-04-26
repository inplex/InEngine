package me.inplex.inengine.mesh;

import java.util.Arrays;

public class Face {

	int[] vertexIds;
	int[] normalIds;

	public Face() {
		vertexIds = new int[4];
		normalIds = new int[4];
		Arrays.fill(vertexIds, -1);
		Arrays.fill(normalIds, -1);
	}
	
	public boolean isEdge() {
		return vertexIds[3] == -1;
	}
	
	public boolean isSurface() {
		return !isEdge();
	}
	
	public boolean hasNormals() {
		return normalIds[0] != -1;
	}

	public void setVertexId(int index, int id) {
		vertexIds[index] = id;
	}

	public int[] getVertexIds() {
		return vertexIds;
	}

	public void setVertexIds(int[] vertexIds) {
		this.vertexIds = vertexIds;
	}
	
	public void setNormalId(int index, int id) {
		normalIds[index] = id;
	}

	public int[] getNormalIds() {
		return normalIds;
	}

	public void setNormalIds(int[] normalIds) {
		this.normalIds = normalIds;
	}

}
