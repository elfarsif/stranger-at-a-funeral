package io.github.elfarsif.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;


public class Door extends SuperObject{
    public Door(){
        name = "door";
        try{
            image = new Texture(Gdx.files.internal("objects/door.png"));
        }catch (Exception e){
            throw new RuntimeException("Error loading image Door:"+e);
        }
        collision = true;
    }
}
