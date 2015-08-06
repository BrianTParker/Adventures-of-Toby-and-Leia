package com.adventures.objects;

import java.awt.geom.Point2D;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class PlayerObject {
	
	Point2D.Float pos;
	Texture image;
	float yVelocity;
	float gravity = 0.5f;  
	boolean onGround;
	private String imageString;
	
	public PlayerObject(float x, float y, String imageLocation){
		this.pos = new Point2D.Float(x, y);
		this.image = new Texture(Gdx.files.internal(imageLocation));
		onGround = false;
		imageString = imageLocation;
	}
	
	
	public Point2D.Float getPosition(){
		return pos;
	}
	
	public void move(){
		this.pos.y += yVelocity;
	}
	
	public Texture getImage(){
		return image;
	}
	
	public boolean isGrounded(){
		return onGround;
	}
	
	public void updateY(float y){
		this.pos.y = y;
	}
	
	public void setVelocity(float yVelocity){
		this.yVelocity = yVelocity;
	}
	
	public void increaseVelocity(float velocity){
		this.yVelocity += velocity;
	}
	
	public void setGrounded(boolean grounded){
		this.onGround = grounded;
	}
	
	public void startJump(){
		if(onGround)
	    {
			
	        this.setVelocity(12.0f);
	        onGround = false;
	    }
	}
	
	public void endJump(){
		if(this.yVelocity > 20.0)
	        this.yVelocity = -6.0f;
	}
	
	public boolean isJumping(){
		if(yVelocity > 0){
			return true;
		}else{
			return false;
		}
	}
	
	public void setImage(String imageLocation){
		this.image = new Texture(Gdx.files.internal(imageLocation));
		imageString = imageLocation;
	}
	
	public float getVelocity(){
		return this.yVelocity;
	}
	
	public String getImageString(){
		return imageString;
	}
	

}
