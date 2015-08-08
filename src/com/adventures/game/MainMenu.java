package com.adventures.game;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.adventures.game.AdventuresGame.gameState;


public class MainMenu implements Screen{

	
	//private Texture backgroundImage = new Texture(Gdx.files.internal("assets/main_menu.png"));
	
	private Stage stage;
	private Skin skin;
	private TextureAtlas atlas;
	private Texture background;
	private Image backgroundImage;
	
	private Music menuMusic;

	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		stage.dispose();
		atlas.dispose();
		skin.dispose();
		background.dispose();
		
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float arg0) {
	
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	
		
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		
		//check for mouse click
		if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)){

            menuMusic.stop();
            AdventuresGame.state = gameState.PLAY;
		}
		
		
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		
		menuMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/music/AdventuresIntro.ogg"));
		menuMusic.setLooping(true);
		menuMusic.play();
		stage = new Stage();
		background = new Texture(Gdx.files.internal("assets/main_menu.png"));
		TextureRegion region = new TextureRegion(background, 0, 0, 800, 600); 
		backgroundImage = new Image(region);

		stage.addActor(backgroundImage);
		Gdx.input.setInputProcessor(stage);
	
	}

}
