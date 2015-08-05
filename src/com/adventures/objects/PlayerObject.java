package com.adventures.objects;

import java.awt.geom.Point2D;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class PlayerObject {
	
	Point2D.Float pos;
	Texture image;
	
	
	public PlayerObject(float x, float y, String imageLocation){
		this.pos = new Point2D.Float(x, y);
		this.image = new Texture(Gdx.files.internal(imageLocation));
	}
	
	
	public Point2D.Float getPosition(){
		return pos;
	}
	
	public Texture getImage(){
		return image;
	}

}
