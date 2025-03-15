package io.github.elfarsif.objects;

import io.github.elfarsif.entity.Entity;
import io.github.elfarsif.gdx.GamePanel;

public class Shield extends Entity {
    public Shield(GamePanel gp) {
        super(gp);
        name = "normal shield";
        defenseValue = 0;
    }
}
