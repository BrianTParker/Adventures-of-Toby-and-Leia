package com.adventures.game;

import java.util.ArrayList;

import com.adventures.objects.PlayerObject;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;


public class AdventuresGame extends Game implements ApplicationListener {
	
	private Game game;
	private SpriteBatch batch;
	private PlayerObject toby;
	private PlayerObject leia;
	private float gravity;
	private int leiaJumpCount;
	private int leiaFallCount;
	private ArrayList<PlayerObject> activePlayers;
	private String tobyJumpImage = "assets/toby_right_jump.png";
	private String tobyStandImage = "assets/toby_right.png";
	private String leiaJumpImage = "assets/leia_right_jump.png";
	private String leiaStandImage = "assets/leia_right.png";
	public Screen curScreen;
	public Screen previousScreen;
	
	
	//this will keep the state of the game.  Used to know what to render and whatnot
	public enum gameState{
		MENU, PLAY
	}
	
	//I made this static so it could be accessed from other classes like the main menu
	public static gameState state;
	
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		toby = new PlayerObject(10, 10, "assets/toby_right.png");
		leia = new PlayerObject(10, 10, "assets/leia_right.png");
		gravity = -0.4f;
		leiaJumpCount = 0;
		activePlayers = new ArrayList();
		activePlayers.add(toby);
		activePlayers.add(leia);
		
		//initiall set the state to menu so the main game doesn't get drawn yet
		state = gameState.MENU;
		game = this;
		
		//this function is defined below.  It just changes the screen to the main menu
		changeScreen(new MainMenu());
		
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
		super.render();
		
	
		
		//only render the main loop if the game state is PLAY
		if(state == gameState.PLAY){
			
			//apply movement and gravity to toby and leia
			for(PlayerObject player : activePlayers){
				player.increaseVelocity(gravity);
			    player.move();
			    
			    if(player.getPosition().y < 15.0)
			    {
			    	player.updateY(15.0f);
			    	player.setVelocity(0.0f);
			    	player.setGrounded(true);
			    }
			    
			    
			}
			
			if(toby.getVelocity() > 0 && !(toby.getImageString().equals(tobyJumpImage))){
				toby.setImage(tobyJumpImage);
			}else{
				if(toby.getVelocity() < 0 && !(toby.getImageString().equals(tobyStandImage))){
					toby.setImage(tobyStandImage);
				}
				
			}
			
			if(leia.getVelocity() > 0 && !(leia.getImageString().equals(leiaJumpImage))){
				leia.setImage(leiaJumpImage);
			}else{
				if(leia.getVelocity() < 0 && !(leia.getImageString().equals(leiaStandImage))){
					leia.setImage(leiaStandImage);
				}
				
			}
			
			
			//some jumping logic to make leia jump just behind toby
			if(toby.isJumping()){
				leiaFallCount = 0;
				if(leiaJumpCount == 10){
					leiaJumpCount = 0;
					leia.startJump();
				}else{
					leiaJumpCount++;
				}
			}else{
				leiaJumpCount = 0;
				if(leiaFallCount == 10){
					leiaFallCount = 0;
					leia.endJump();
				}else{
					leiaFallCount++;
				}
			}
			
			
			//get keyboard input
			if(Gdx.input.isKeyPressed(Keys.SPACE)){
				toby.startJump();
			}else{
				toby.endJump();	
			}
			
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // This cryptic line clears the screen.
			Gdx.gl.glClearColor(135/255f, 206/255f, 235/255f, 1); //somehow this turns the color blue as described here: http://stackoverflow.com/questions/24985945/how-do-i-set-background-color-in-libgdx
			
			
			
			//all drawing happens between batch begin and batch end
	        batch.begin();
	        
	        batch.draw(toby.getImage(), toby.getPosition().x, toby.getPosition().y);
	        batch.draw(leia.getImage(), leia.getPosition().x, leia.getPosition().y);
	        
	        batch.end();
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
	
	public void changeScreen(Screen s){
		
		if(curScreen != null){
			curScreen.hide();
			curScreen.dispose();
		}
		curScreen = s;
		setScreen(curScreen);
		
	}

	


}
