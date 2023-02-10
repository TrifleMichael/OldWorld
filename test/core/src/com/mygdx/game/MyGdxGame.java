package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	BasicInputProcessor inputProcessor = new BasicInputProcessor();
	DrawManager drawManager;

	float color = 0.1f;

	// For some reason texture don't work outside of this class
	public ArrayList<TextureRecord> getTextures() {
		ArrayList<TextureRecord> textureRecords = new ArrayList<>();
//		textureRecords.add(new TextureRecord(new Texture("badlogic.jpg"), "badlogic"));
		textureRecords.add(new TextureRecord(new Texture("hexagon.png"), "hexagon"));
		return textureRecords;
	}

	@Override
	public void create () {
		drawManager = new DrawManager(getTextures());
		batch = new SpriteBatch();
		Gdx.input.setInputProcessor(inputProcessor);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, color, 1);
		batch.begin();
		drawManager.draw(batch);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		drawManager.dispose();
	}
}
