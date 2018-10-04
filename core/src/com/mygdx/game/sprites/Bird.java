package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.graphics.Texture;


public class Bird {
    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 100;

    private Vector3 position;
    private Vector3 velocity;
    private Texture bird;
    private Texture texture;

    private Rectangle boundsBird;

    private Animation birdAnimation;

    public Bird(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0,0,0);
        bird = new Texture("bird.png");
        texture = new Texture("animationbyrd.png");
        birdAnimation = new Animation(new TextureRegion(texture),3,0.5f);
        boundsBird = new Rectangle(x,y, texture.getWidth() / 3, texture.getHeight());
    }

    public void update(float dt){
        birdAnimation.update(dt);
        if(position.y > 0) {
            velocity.add(0, GRAVITY, 0);
        }
        velocity.scl(dt);
        position.add(MOVEMENT * dt,velocity.y,0);
        if(position.y < 0){
            position.y = 0;
        }
        velocity.scl(1/dt);
        boundsBird.setPosition(position.x,position.y);
    }

    public void jump(){
        velocity.y = 250;
    }

    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getTexture() {
        return birdAnimation.getFrame();
    }

    public Rectangle getBoundsBird(){
        return boundsBird;
    }

    public void dispose(){
        texture.dispose();
    }
}
