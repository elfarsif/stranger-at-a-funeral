package io.github.elfarsif.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import io.github.elfarsif.entity.Entity;
import io.github.elfarsif.gdx.GamePanel;

public class Hoe extends Entity {
    public Hoe(GamePanel gp) {
        super(gp);
        name = "hoe";
        type = type_hoe;
        down1 = setup("tools/hoe.png");
        attackValue = 0;
        attackArea.width = gp.tileSize/2;
        attackArea.height = gp.tileSize/2;

    }

    @Override
    public Sprite setup(String filePath) {
        Sprite image = null;
        try {
            image = new Sprite(new Texture(filePath));
            image.setSize(gp.tileSize, gp.tileSize);
        } catch (Exception e) {
            throw new RuntimeException("Error reading image :" + e);
        }
        return image;
    }
}
