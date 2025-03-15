package io.github.elfarsif.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import io.github.elfarsif.entity.Entity;
import io.github.elfarsif.gdx.GamePanel;

public class Sword extends Entity {
    public Sword(GamePanel gp) {
        super(gp);
        name = "normal sword";
        down1 = setup("tools/sword.png");
        attackValue = 1;
        attackArea.width = gp.tileSize/2;
        attackArea.height = gp.tileSize/2;
    }
    @Override
    public Sprite setup(String filePath) {
        Sprite image = null;
        try {
            image = new Sprite(new Texture(filePath));
            image.setSize(gp.tileSize * 2, gp.tileSize * 2);
        } catch (Exception e) {
            throw new RuntimeException("Error reading image :" + e);
        }
        return image;
    }

}
