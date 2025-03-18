package io.github.elfarsif.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import io.github.elfarsif.entity.Projectile;
import io.github.elfarsif.gdx.GamePanel;

public class Fireball extends Projectile {

    GamePanel gp;

    public Fireball(GamePanel gp) {
        super(gp);
        this.gp = gp;
        name = "fireball";
        speed = 4;
        maxLife = 80;
        currentLife = maxLife;
        attack = 2;
        projectileUseCost = 1;
        alive = false;
        getImage();
    }

    private void getImage() {
        up1 = setup("objects/mushroom.png");
        up2 = setup("objects/mushroom.png");
        down1 = setup("objects/mushroom.png");
        down2 = setup("objects/mushroom.png");
        left1 = setup("objects/mushroom.png");
        left2 = setup("objects/mushroom.png");
        right1 = setup("objects/mushroom.png");
        right2 = setup("objects/mushroom.png");
    }

    @Override
    public Sprite setup(String filePath) {
        Sprite image = null;
        try {
            image = new Sprite(new Texture(filePath));
            image.setSize(gp.tileSize * 2, gp.tileSize * 2);
        } catch (Exception e) {
            throw new RuntimeException("Error reading image for mushroom:" + e);
        }
        return image;
    }

}
