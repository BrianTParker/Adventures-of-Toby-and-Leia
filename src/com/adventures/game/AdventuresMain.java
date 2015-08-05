package com.adventures.game;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;



public class AdventuresMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 new LwjglApplication(new AdventuresGame(), "Game", 480, 340);
	}

}
