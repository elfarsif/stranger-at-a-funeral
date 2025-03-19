package io.github.elfarsif.tile_interactive;

import io.github.elfarsif.entity.Entity;
import io.github.elfarsif.gdx.GamePanel;

public class InteractiveTile extends Entity {
    GamePanel gp;
    public boolean destructible = false;

    public InteractiveTile(GamePanel gp) {
        super(gp);
        this.gp = gp;

    }

    public boolean isCorrectTool(Entity entity){
        boolean correctTool = false;
        return correctTool;
    }

    public void playSoundEffect(){}

    public InteractiveTile getDestroyedTile(){
        InteractiveTile tile = null;
        return null;
    }

    @Override
    public void update(){
        if (invincible) {
            invincibleCounter++;
            //60FPS ie 1 second
            if (invincibleCounter > 20) {
                invincible = false;
                invincibleCounter = 0;
            }
        }
    }
}
