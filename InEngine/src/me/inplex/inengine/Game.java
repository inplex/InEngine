package me.inplex.inengine;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Cursor;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Game implements Runnable {

	private boolean running;
	private long ticks;

	private Renderer renderer;

	public Game() {
		this.renderer = new Renderer();
	}

	/*
	 * *****
	 * Methods to be implemented if extending this class
	 */

	/**
	 * Called when Game has been initialized Used to initialize variables No
	 * super() call needed
	 */
	protected void onInit() {
	}

	/**
	 * Called when Game stops Used to shut down everything No super() call
	 * needed
	 */
	protected void onExit() {
	}

	/*
	 * *****
	 */

	@Override
	public final void run() {
		while (!Display.isCloseRequested() && running) {
			update();
			render();
			ticks++;
			Display.sync(60);
			Display.update();
		}
		stop();
	}
	
	private final void update() {
		while (Keyboard.next()) {
			if (Keyboard.getEventKey() == Keyboard.KEY_ESCAPE) {
				stop();
			}
		}
	}

	private final void render() {
	}

	public final void setupDisplay(String title, int width, int height, boolean fullscreen, boolean resizable) throws LWJGLException {
		Display.setTitle(title);
		Display.setDisplayMode(new DisplayMode(width, height));
		Display.setResizable(resizable);
		Display.setFullscreen(fullscreen);
		Display.create();
		Keyboard.create();
		Mouse.create();
		Mouse.setCursorPosition(width / 2, height / 2);
		Mouse.setGrabbed(true);
		Cursor emptyCursor = new Cursor(1, 1, 0, 0, 1, BufferUtils.createIntBuffer(1), null);
		Mouse.setNativeCursor(emptyCursor);
		onInit();
	}

	/**
	 * Start the game. This method does block!
	 */

	public void start() {
		running = true;
		run();
	}

	public void stop() {
		onExit();
		running = false;
	}

	public final long getTicks() {
		return ticks;
	}

	public final int getWidth() {
		return Display.getWidth();
	}

	public final int getHeight() {
		return Display.getHeight();
	}

	public final Renderer getRenderer() {
		return renderer;
	}

	public final void setRenderer(Renderer renderer) {
		this.renderer = renderer;
	}

}