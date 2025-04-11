package io.github.elfarsif.environment;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.elfarsif.gdx.GamePanel;

/**
 * Manages the environment effects of the game, such as lighting, weather, rain, fog, etc.
 */
public class EnvironmentManager {
    GamePanel gp;
    Lighting lighting;

    public EnvironmentManager(GamePanel gp){
        this.gp = gp;
    }

    public void setup(){
        lighting = new Lighting(gp,600);
    }

    public  void draw(SpriteBatch batch){
//        lighting.draw(batch);
    }
}
