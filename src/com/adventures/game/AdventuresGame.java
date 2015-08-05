package com.adventures.game;

import com.adventures.objects.PlayerObject;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AdventuresGame implements ApplicationListener {

	private SpriteBatch batch;
	private PlayerObject toby;
	private PlayerObject leia;
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		toby = new PlayerObject(10, 10, "assets/toby_right.png");
		leia = new PlayerObject(10, 10, "assets/leia.png");
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // This cryptic line clears the screen.
		Gdx.gl.glClearColor(135/255f, 206/255f, 235/255f, 1); //somehow this turns the color blue as described here: http://stackoverflow.com/questions/24985945/how-do-i-set-background-color-in-libgdx
		
		//all drawing happens between batch begin and batch end
        batch.begin();
        batch.draw(toby.getImage(), toby.getPosition().x, toby.getPosition().y);
        batch.draw(leia.getImage(), leia.getPosition().x, leia.getPosition().y);
        batch.end();

	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
