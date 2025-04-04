package io.github.elfarsif.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import io.github.elfarsif.entity.Entity;
import io.github.elfarsif.gdx.GamePanel;

public class SingleBed extends Entity {


    GamePanel gp;

    public SingleBed(GamePanel gp) {
        super(gp);
        this.gp = gp;

        type = type_obstacle;
        name = "bed";
        down1 = this.setup("/objects/single-bed.png");
        collision = true;

    }

    @Override
    public void interact(){
        gp.gameState = gp.dialogueState;
        gp.ui.currentDialogue = "The door is locked. you need an axe";
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
