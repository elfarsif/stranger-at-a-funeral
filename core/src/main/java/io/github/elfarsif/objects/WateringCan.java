package io.github.elfarsif.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import io.github.elfarsif.entity.Entity;
import io.github.elfarsif.gdx.GamePanel;

public class WateringCan extends Entity {
    public WateringCan(GamePanel gp) {
        super(gp);
        name = "watering-can";
        type = type_watering_can;
        down1 = setup("tools/wateringCan.png");
        attackValue = 0;
        attackArea.width = gp.tileSize/2;
        attackArea.height = gp.tileSize/2;

    }

    @Override
    public Sprite setup(String filePath) {
        Sprite image = null;
        try {
            image = new Sprite(new Texture(filePath));
            image.setSize(gp.tileSize , gp.tileSize);
        } catch (Exception e) {
            throw new RuntimeException("Error reading image :" + e);
        }
        return image;
    }
}
