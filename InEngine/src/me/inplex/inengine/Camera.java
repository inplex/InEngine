package me.inplex.inengine;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class Camera {
	
	private Vector3f translation;
	private Vector2f rotation;
	
	final float speedNormal = 1.2f;
	final float speedSprinting = 12.5f;
	
	public static final float pi180 = 0.017453295f;
	public static final float scale = 0.2f;
	
	boolean sprinting = false;

	boolean onGround = false;
	float jump = 0.0f;
	float acc = 1.0f;

	public Camera() {
		translation = new Vector3f(0, 0, -10);
		rotation = new Vector2f(0, 0);
	}

	public void update() {
		handleKeys();
		handleMouse();
	}

	private void handleKeys() {

		float speed = speedNormal;
		if (sprinting) {
			speed = speedSprinting;
		}
		
		System.out.println("translation: " + translation);
		System.out.println("rotation: " + rotation);
		
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			translation.z += Math.cos(rotation.y * pi180) * scale * speed;
			translation.x += Math.sin(rotation.y * pi180) * scale * speed;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			translation.z -= Math.cos(rotation.y * pi180) * scale * speed;
			translation.x -= Math.sin(rotation.y * pi180) * scale * speed;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			translation.x += Math.cos(rotation.y * pi180) * scale * speed;
			translation.z -= Math.sin(rotation.y * pi180) * scale * speed;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			translation.x -= Math.cos(rotation.y * pi180) * scale * speed;
			translation.z += Math.sin(rotation.y * pi180) * scale * speed;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			sprinting = true;
		} else {
			sprinting = false;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			if (onGround) {
				jump = 10f;
			}
		}

		updateGravity();
	}

	private void updateGravity() {
		if (!(translation.y + scale >= -3))
			onGround = false;
		else
			onGround = true;

		if (!onGround) {
			translation.y += scale;
		}

		if (jump > 0.0f) {
			translation.y -= jump / 10;
			jump -= acc;
		}

	}

	private void handleMouse() {
		if (Mouse.isGrabbed()) {
			int screenMidX = Display.getWidth() / 2;
			int screenMidY = Display.getHeight() / 2;
			int mouseX = Mouse.getX();
			int mouseY = Mouse.getY();
			rotation.y += -((mouseX - screenMidX) * scale);
			rotation.x += ((mouseY - screenMidY) * scale);
			Mouse.setCursorPosition(screenMidX, screenMidY);
		}
	}

	public Vector3f getTranslation() {
		return translation;
	}

	public Vector2f getRotation() {
		return rotation;
	}

}