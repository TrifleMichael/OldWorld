package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Objects;

public class DrawManager {
    ArrayList<TextureRecord> textureRecords;

    public DrawManager(ArrayList<TextureRecord> textureRecords) {
        this.textureRecords = textureRecords;
    }

    public void draw(SpriteBatch batch) {
//        batch.draw(hexImg, 0, 0);

        for(TextureRecord record : textureRecords) {
            if (Objects.equals(record.name, "badlogic")) {
                batch.draw(record.texture, 100, 100);
            }

            if (Objects.equals(record.name, "hexagon")) {
                Texture hexagon = record.texture;
                int textureX = Settings.horizontalResolution/Settings.gridSizeX;
                int textureY = Settings.verticalResolution/Settings.gridSizeY;
                for(int x = 0; x < Settings.gridSizeX + 1; x++) {
                    for (int y = 0; y < (int)Settings.gridSizeY * 1.5; y++) {
                        if (y % 2 == 0) {
                            float xRes = x * textureX;
                            float yRes = (float)y * textureY * 3/4 - (float)textureY / 4;
                            batch.draw(hexagon, xRes, yRes, textureX, textureY);
                        } else {
                            float xRes = (float)x * textureX - (float)textureX / 2;
                            float yRes = (float)y * textureY * 3/4 - (float)textureY / 4;
                            batch.draw(hexagon, xRes, yRes, textureX, textureY);
                        }
                    }
                }
                batch.draw(hexagon, 300, 300, 20, 20);
            }
        }
    }

    public void dispose() {
        for(TextureRecord record : textureRecords) {
            record.texture.dispose();
        }
    }
}
