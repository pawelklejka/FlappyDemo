package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuState extends State {
    private Texture bg;
    private Texture playBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        bg = new Texture("bg.png");
        playBtn = new Texture("playbutton.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
            dispose();
        }
    }

    @Override
    protected void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(bg,0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() );
        sb.draw(playBtn, (Gdx.graphics.getWidth() / 2 ) - (playBtn.getWidth() /2 ), Gdx.graphics.getHeight()/2);
        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        playBtn.dispose();
    }
}
