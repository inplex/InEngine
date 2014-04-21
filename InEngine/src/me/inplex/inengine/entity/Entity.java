package me.inplex.inengine.entity;

import me.inplex.inengine.mesh.Mesh;

public class Entity {
	
	float x;
	float y;
	float z;
	
	float rotationX;
	float rotationY;
	float rotationZ;
	
	boolean isVisible;
	
	
	
	public Entity(Mesh mesh){
		
	}
	
	
	public void moveRelative(float x,float y,float z){
		this.x += x;
		this.y += y;
		this.z += z;
	}
	
	public void moveAbsolute(float x,float y,float z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void rotateRelative(float x,float y,float z){
		this.rotationX += x;
		this.rotationY += y;
		this.rotationZ += z;
	}
	
	public void rotateAbsolute(float x,float y,float z){
		this.rotationX = x;
		this.rotationY = y;
		this.rotationZ = z;
	}
	
	public void setVisible(boolean visible){
		this.isVisible = visible;
	}
	
	

}
