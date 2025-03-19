package io.github.elfarsif.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import io.github.elfarsif.entity.Entity;
import io.github.elfarsif.gdx.GamePanel;

public class Banana extends Entity {
    GamePanel gp;

    public Banana(GamePanel gp) {
        super(gp);
        this.gp = gp;

        type = type_consumable;
        name = "banana";
        value = 3;
        down1 = setup("objects/banana.png");
    }

    @Override
    public Sprite setup(String filePath) {
        Sprite image = null;
        try {
            image = new Sprite(new Texture(filePath));
            image.setSize(gp.tileSize, gp.tileSize);
        } catch (Exception e) {
            throw new RuntimeException("Error reading image:" + e);
        }
        return image;
    }


    @Override
    public void applyConsumable(Entity entity){
        gp.ui.addMessage("You ate the banana. You feel better.");
    }
}
