package io.github.elfarsif.environment;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.elfarsif.gdx.GamePanel;
public class Lighting {
    GamePanel gp;
    Texture darknessTexture;
    int lightedCircleSize;

    public Lighting(GamePanel gp, int lightedCircleSize) {
        this.gp = gp;
        this.lightedCircleSize = lightedCircleSize;
        updateLightingTexture();  // create initial texture
    }

    public void updateLightingTexture() {
        if (darknessTexture != null) darknessTexture.dispose(); // dispose old

        int width = gp.screenWidth;
        int height = gp.screenHeight;

        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);

        // Fill the entire screen with black (95% opacity)
        pixmap.setColor(0f, 0f, 0f, 0.95f);
        pixmap.fill();

        // Get center of light
        int centerX = gp.player.screenX + gp.tileSize / 2;
        int centerY = gp.player.screenY + gp.tileSize / 2;

        // Cut a transparent circle in the black overlay
        pixmap.setBlending(Pixmap.Blending.None); // disable blending for alpha punch-through
        pixmap.setColor(0f, 0f, 0f, 0f); // fully transparent
        pixmap.fillCircle(centerX, centerY, lightedCircleSize / 2);

        darknessTexture = new Texture(pixmap);
        pixmap.dispose();
    }

    public void draw(SpriteBatch batch) {
        batch.setBlendFunction(com.badlogic.gdx.graphics.GL20.GL_SRC_ALPHA, com.badlogic.gdx.graphics.GL20.GL_ONE_MINUS_SRC_ALPHA);
        batch.draw(darknessTexture, 0, 0);
    }

    public void dispose() {
        if (darknessTexture != null) {
            darknessTexture.dispose();
        }
    }
}
