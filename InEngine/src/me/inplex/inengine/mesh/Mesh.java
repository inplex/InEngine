package me.inplex.inengine.mesh;

import static org.lwjgl.opengl.GL11.glColor3f;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;
import static org.lwjgl.opengl.ARBBufferObject.*;
import static org.lwjgl.opengl.ARBVertexBufferObject.*;


public class Mesh {
	
	private enum RenderMethod{
		NORMAL,
		VBO,
		LIST;
	}
	
	final RenderMethod renderMethod = RenderMethod.LIST;

	private static int lastId = 0;
	
	private List<Vector3f> vertices;
	private List<Vector3f> normals;
	private List<Face> faces;
	private int id;
	private int displayList;

	public Mesh() {
		this.vertices = new ArrayList<Vector3f>();
		this.normals = new ArrayList<Vector3f>();
		this.faces = new ArrayList<Face>();
		this.id = lastId++;
		
		if (renderMethod==RenderMethod.LIST){
			this.displayList = GL11.glGenLists(1);
			fillDisplayList();
		}
		
	}
	
	
	private void fillDisplayList(){
		GL11.glNewList(displayList, GL11.GL_COMPILE);
		
		glColor3f(1f, 1f, 1f);
		GL11.glBegin(GL11.GL_TRIANGLES);
		for (Face face : faces) {
			for (int i = 0; i < (face.isEdge() ? 2 : 3); i++) {
				Vector3f vertex = vertices.get(face.getVertexIds()[i]-1);
				GL11.glVertex3f(vertex.x, vertex.y, vertex.z);
				if (face.hasNormals() && i < 3) {
					Vector3f normal = normals.get(face.getNormalIds()[i]-1);
					GL11.glNormal3f(normal.x, normal.y, normal.z);
				}
			}
		}
		GL11.glEnd();
		// Draw Outline
		glColor3f(0f, 0f, 0f);
		for (Face face : faces) {
			GL11.glBegin(GL11.GL_LINES);
			for (int i = 0; i < (face.isEdge() ? 2 : 3); i++) {
				Vector3f vertex = vertices.get(face.getVertexIds()[i]-1);
				GL11.glVertex3f(vertex.x, vertex.y, vertex.z);
				if (face.hasNormals() && i < 3) {
					Vector3f normal = normals.get(face.getNormalIds()[i]-1);
					GL11.glNormal3f(normal.x, normal.y, normal.z);
				}
			}
			GL11.glEnd();
		}
		
		GL11.glEndList();
	}


	public void render() {
		if (renderMethod==RenderMethod.NORMAL){	//Render Normal (GL11)
		glColor3f(1f, 1f, 1f);
		GL11.glBegin(GL11.GL_TRIANGLES);
		for (Face face : faces) {
			for (int i = 0; i < (face.isEdge() ? 2 : 3); i++) {
				Vector3f vertex = vertices.get(face.getVertexIds()[i]-1);
				GL11.glVertex3f(vertex.x, vertex.y, vertex.z);
				if (face.hasNormals() && i < 3) {
					Vector3f normal = normals.get(face.getNormalIds()[i]-1);
					GL11.glNormal3f(normal.x, normal.y, normal.z);
				}
			}
		}
		GL11.glEnd();
		// Draw Outline
		glColor3f(0f, 0f, 0f);
		for (Face face : faces) {
			GL11.glBegin(GL11.GL_LINES);
			for (int i = 0; i < (face.isEdge() ? 2 : 3); i++) {
				Vector3f vertex = vertices.get(face.getVertexIds()[i]-1);
				GL11.glVertex3f(vertex.x, vertex.y, vertex.z);
				if (face.hasNormals() && i < 3) {
					Vector3f normal = normals.get(face.getNormalIds()[i]-1);
					GL11.glNormal3f(normal.x, normal.y, normal.z);
				}
			}
			GL11.glEnd();
		}

		
		}else if(renderMethod==RenderMethod.VBO){ //Render using VBOs
			//TODO VBO rendering
		}else if(renderMethod==RenderMethod.LIST){ //Render using lists
			GL11.glCallList(displayList);
		}
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