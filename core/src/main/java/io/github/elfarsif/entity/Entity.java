package io.github.elfarsif.entity;

import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class Entity {
    public int worldX, worldY;
    public int speed;
    Texture down1, down2,down3,down4,down5,down6,
            up1, up2, up3, up4, up5, up6,
            left1, left2, left3, left4, left5, left6,
            right1, right2, right3, right4, right5, right6;
    public String direction;

    int spriteCounter = 0;
    int spriteNumber =1;

    public Rectangle solidArea;
    public Boolean collisionOn = false;
}
