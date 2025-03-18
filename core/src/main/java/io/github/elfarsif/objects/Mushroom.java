package io.github.elfarsif.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import io.github.elfarsif.entity.Entity;
import io.github.elfarsif.gdx.GamePanel;


public class Mushroom extends Entity {
    GamePanel gp;
    int healthValue = 1;
    public Mushroom(GamePanel gp) {
        super(gp);
        this.gp = gp;

        name = "mushroom";
        type = type_consumable;
        down1 = setup("objects/mushroom.png");
        description = "Give +10 health and +5 energy";
    }

    @Override
    public void applyConsumable(Entity entity){
        gp.gameState = gp.dialogueState;
        gp.ui.currentDialog = "You ate the mushroom. You feel better."+healthValue+" health";
        entity.currentLife += healthValue;
        if (gp.player.currentLife > gp.player.maxLife){
            gp.player.currentLife = gp.player.maxLife;
        }
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
