package io.github.elfarsif.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import javax.imageio.ImageIO;

public class Mushroom extends SuperObject{
    public Mushroom(){
        name = "mushroom";
        try{
            image = new Texture(Gdx.files.internal("objects/mushroom.png"));

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
