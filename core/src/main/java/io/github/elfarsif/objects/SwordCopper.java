package io.github.elfarsif.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import io.github.elfarsif.entity.Entity;
import io.github.elfarsif.gdx.GamePanel;

public class SwordCopper extends Entity {
    public SwordCopper(GamePanel gp) {
        super(gp);
        name = "copper sword";
        type = type_sword_copper;
        down1 = setup("tools/sword_copper.png");
        attackValue = 2;
        attackArea.width = gp.tileSize;
        attackArea.height = gp.tileSize;
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
