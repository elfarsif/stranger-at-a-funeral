package io.github.elfarsif.tile_interactive;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import io.github.elfarsif.entity.Entity;
import io.github.elfarsif.gdx.GamePanel;

public class HoeableGrass extends InteractiveTile {
    GamePanel gp;

    public HoeableGrass(GamePanel gp) {
        super(gp);
        this.gp = gp;
        name = "hoeable-grass";
        down1 = setup("tiles/left-border.png");
        down2 = setup("tiles/left-border.png");
        destructible = true;
        currentLife = 1;
        walkOverable = true;




    }

    public boolean isCorrectTool(Entity entity){
        boolean correctTool = false;
        if(entity.currentWeapon.type== type_hoe){
            correctTool = true;
        }
        return correctTool;
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
