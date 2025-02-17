package io.github.elfarsif.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class PineTree extends SuperObject{
    public PineTree(){
        name = "mushroom";
        try{
            image = new Texture(Gdx.files.internal("objects/pine-tree.png"));

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
