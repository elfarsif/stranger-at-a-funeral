package io.github.elfarsif.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import io.github.elfarsif.entity.Entity;
import io.github.elfarsif.gdx.GamePanel;


public class Mushroom extends Entity {

    public Mushroom(GamePanel gp) {
        super(gp);
        name = "mushroom";
        down1 = setup("objects/mushroom.png");
        description = "Give +10 health and +5 energy";
    }

    @Override
    public Sprite setup(String filePath) {
        Sprite image = null;
        try {
            image = new Sprite(new Texture(filePath));
            image.setSize(gp.tileSize * 2, gp.tileSize * 2);
        } catch (Exception e) {
            throw new RuntimeException("Error reading image for mushroom:" + e);
        }
        return image;
    }
}
