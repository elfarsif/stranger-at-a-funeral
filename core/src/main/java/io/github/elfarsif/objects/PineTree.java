package io.github.elfarsif.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import io.github.elfarsif.entity.Entity;
import io.github.elfarsif.gdx.GamePanel;

public class PineTree extends Entity {

    public PineTree(GamePanel gp){
        super(gp);
        name = "pine-tree";
        down1 = setup("objects/pine-tree.png");
    }
}
