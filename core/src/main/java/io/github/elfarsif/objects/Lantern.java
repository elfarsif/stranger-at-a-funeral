package io.github.elfarsif.objects;

import io.github.elfarsif.entity.Entity;
import io.github.elfarsif.gdx.GamePanel;

public class Lantern extends Entity {
    public Lantern(GamePanel gp) {
        super(gp);

        type = type_light;
        name = "lantern";
        down1 = setup("objects/lantern.png");
        description = "A lantern that lights up the surroundings.";
        lightRadius = 250;
    }

}
