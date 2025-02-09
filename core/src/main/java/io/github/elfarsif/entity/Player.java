package io.github.elfarsif.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Gdx;
import io.github.elfarsif.gdx.GamePanel;
import io.github.elfarsif.gdx.KeyHandler;

public class Player extends Entity {
    private Texture playerTexture;
    private KeyHandler keyHandler;
    GamePanel gp;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gp = gamePanel;
        this.keyHandler = keyHandler;
        setDefaultValues();
        getPlayerImage();
    }

    private void getPlayerImage() {
        down1 = new Texture("player/walking/down1.png");
        down2 = new Texture("player/walking/down2.png");
        down3 = new Texture("player/walking/down3.png");
        down4 = new Texture("player/walking/down4.png");
        down5 = new Texture("player/walking/down5.png");
        down6 = new Texture("player/walking/down6.png");
        up1 = new Texture("player/walking/up1.png");
        up2 = new Texture("player/walking/up2.png");
        up3 = new Texture("player/walking/up3.png");
        up4 = new Texture("player/walking/up4.png");
        up5 = new Texture("player/walking/up5.png");
        up6 = new Texture("player/walking/up6.png");
        left1 = new Texture("player/walking/left1.png");
        left2 = new Texture("player/walking/left2.png");
        left3 = new Texture("player/walking/left3.png");
        left4 = new Texture("player/walking/left4.png");
        left5 = new Texture("player/walking/left5.png");
        left6 = new Texture("player/walking/left6.png");
        right1 = new Texture("player/walking/right1.png");
        right2 = new Texture("player/walking/right2.png");
        right3 = new Texture("player/walking/right3.png");
        right4 = new Texture("player/walking/right4.png");
        right5 = new Texture("player/walking/right5.png");
        right6 = new Texture("player/walking/right6.png");
    }

    public void setDefaultValues() {
        x = 10;
        y = 10;
        speed = 3;
        direction = "down";
    }

    public void update(){
        boolean isMoving = false;
        if(keyHandler.upPressed || keyHandler.downPressed || keyHandler.leftPressed || keyHandler.rightPressed){
            isMoving = true;
        }

        if(isMoving){
            if(keyHandler.upPressed){
                direction = "up";
                y += speed;
            }
            if(keyHandler.downPressed){
                direction = "down";
                y -= speed;
            }
            if(keyHandler.leftPressed){
                direction = "left";
                x -= speed;
            }
            if(keyHandler.rightPressed){
                direction = "right";
                x += speed;
            }

            spriteCounter++;
            if(spriteCounter > 12){
                if(spriteNumber == 1){
                    spriteNumber = 2;
                }else if(spriteNumber == 2){
                    spriteNumber = 1;
                }
                spriteCounter = 0;
            }
        }

    }

    public void draw(SpriteBatch batch) {
        Texture image = null;

        switch (direction){
            case "down":
                if(spriteNumber == 1){
                    image = down1;
                }
                if(spriteNumber == 2){
                    image = down2;
                }
                break;
            case "up":
                if(spriteNumber == 1){
                    image = up1;
                }
                if(spriteNumber == 2){
                    image = up2;
                }
                break;
            case "left":
                if(spriteNumber == 1){
                    image = left1;
                }
                if(spriteNumber == 2){
                    image = left2;
                }
                break;
            case "right":
                if(spriteNumber == 1){
                    image = right1;
                }
                if(spriteNumber == 2 ){
                    image = right2;
                }
                break;
        }
        batch.draw(image, x, y, gp.tileSize, gp.tileSize);
    }

    /**
     * Disposes of the player texture when the game is closed. Not sure how to use yet
     */
    public void dispose() {
        playerTexture.dispose();
    }
}

