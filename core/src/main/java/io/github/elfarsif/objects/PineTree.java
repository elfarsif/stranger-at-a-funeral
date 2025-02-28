package io.github.elfarsif.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import io.github.elfarsif.gdx.GamePanel;

public class PineTree extends SuperObject{
    GamePanel gp;

    public PineTree(GamePanel gp){
        this.gp = gp;
        name = "mushroom";
        try{
            image = new Sprite( new Texture(Gdx.files.internal("objects/pine-tree.png")));
            image.setSize(gp.tileSize*2,gp.tileSize*2);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
