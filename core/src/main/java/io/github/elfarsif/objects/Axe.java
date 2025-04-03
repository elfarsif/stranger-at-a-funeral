package io.github.elfarsif.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import io.github.elfarsif.entity.Entity;
import io.github.elfarsif.gdx.GamePanel;

public class Axe extends Entity {
    public Axe(GamePanel gp) {
        super(gp);
        name = "axe";
        type = type_axe;
        down1 = setup("tools/axe.png");
        attackValue = 0;
        attackArea.width = gp.tileSize;
        attackArea.height = gp.tileSize;
    }


    @Override
    public Sprite setup(String filePath) {
        Sprite image = null;
        try {
            image = new Sprite(new Texture(filePath));
            image.setSize(gp.tileSize, gp.tileSize);
        } catch (Exception e) {
            throw new RuntimeException("Error reading image for mushroom:" + e);
        }
        return image;
    }
}
