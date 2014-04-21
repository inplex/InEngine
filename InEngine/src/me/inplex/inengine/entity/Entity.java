package me.inplex.inengine.entity;

import me.inplex.inengine.mesh.Mesh;

public class Entity {

	private float x;
	private float y;
	private float z;

	private float rotationX;
	private float rotationY;
	private float rotationZ;

	private boolean visible;

	private Mesh mesh;
	
	public Entity(Mesh mesh, float x, float y, float z) {
		this.mesh = mesh;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void moveRelative(float x, float y, float z) {
		this.x += x;
		this.y += y;
		this.z += z;
	}

	public void moveAbsolute(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void rotateRelative(float x, float y, float z) {
		this.rotationX += x;
		this.rotationY += y;
		this.rotationZ += z;
	}

	public void rotateAbsolute(float x, float y, float z) {
		this.rotationX = x;
		this.rotationY = y;
		this.rotationZ = z;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public Mesh getMesh() {
		return this.mesh;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}

	public float getRotationX() {
		return rotationX;
	}

	public void setRotationX(float rotationX) {
		this.rotationX = rotationX;
	}

	public float getRotationY() {
		return rotationY;
	}

	public void setRotationY(float rotationY) {
		this.rotationY = rotationY;
	}

	public float getRotationZ() {
		return rotationZ;
	}

	public void setRotationZ(float rotationZ) {
		this.rotationZ = rotationZ;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setMesh(Mesh mesh) {
		this.mesh = mesh;
	}

}
