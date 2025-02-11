package io.github.elfarsif.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.elfarsif.gdx.GamePanel;
import io.github.elfarsif.gdx.KeyHandler;

import java.awt.*;

public class Player extends Entity {
    private Texture playerTexture;
    private KeyHandler keyHandler;
    GamePanel gp;
    public final int screenX;
    public final int screenY;
    int hasMushroom = 0;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gp = gamePanel;
        this.keyHandler = keyHandler;
        screenX = gamePanel.screenWidth / 2 - gamePanel.tileSize / 2;
        screenY = gamePanel.screenHeight / 2 - gamePanel.tileSize / 2;

        solidArea = new Rectangle();
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = gamePanel.tileSize;
        solidArea.height = gamePanel.tileSize;

        setDefaultValues();
        getPlayerImage();
    }

    private void getPlayerImage() {
        try {
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
        } catch (Exception e) {
            throw new RuntimeException("Error reading image :" + e);
        }
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 5;
        worldY = gp.tileSize * 5;
        speed = 6;
        direction = "down";
    }

    public void update() {
        boolean isMoving = false;
        if (keyHandler.upPressed || keyHandler.downPressed || keyHandler.leftPressed || keyHandler.rightPressed) {
            isMoving = true;
        }

        if (isMoving) {
            if (keyHandler.upPressed) {
                direction = "up";
            }
            if (keyHandler.downPressed) {
                direction = "down";
            }
            if (keyHandler.leftPressed) {
                direction = "left";
            }
            if (keyHandler.rightPressed) {
                direction = "right";
            }

            //check tile collision
            collisionOn = false;
            gp.collisionChecker.checkTile(this);

            //check object collision
            int objectIndex = gp.collisionChecker.checkObject(this, true);
            pickUpObject(objectIndex);

            if (!collisionOn) {
                switch (direction) {
                    case "up":
                        worldY += speed;
                        break;
                    case "down":
                        worldY -= speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }

            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNumber == 1) {
                    spriteNumber = 2;
                } else if (spriteNumber == 2) {
                    spriteNumber = 1;
                }
                spriteCounter = 0;
            }
        }

    }

    private void pickUpObject(int objectIndex) {
        if(objectIndex != 999){
            String objectName = gp.objects[objectIndex].name;
            switch (objectName){
                case "mushroom":
                    hasMushroom++;
                    gp.objects[objectIndex] = null;
                    break;
                case "door":
                    if (hasMushroom>0){
                        hasMushroom--;
                        gp.objects[objectIndex] = null;
                    }
                    break;
            }
        }
    }

    public void draw(SpriteBatch batch) {
        Texture image = null;

        switch (direction) {
            case "down":
                if (spriteNumber == 1) {
                    image = down1;
                }
                if (spriteNumber == 2) {
                    image = down2;
                }
                break;
            case "up":
                if (spriteNumber == 1) {
                    image = up1;
                }
                if (spriteNumber == 2) {
                    image = up2;
                }
                break;
            case "left":
                if (spriteNumber == 1) {
                    image = left1;
                }
                if (spriteNumber == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNumber == 1) {
                    image = right1;
                }
                if (spriteNumber == 2) {
                    image = right2;
                }
                break;
        }
        batch.draw(image, screenX, screenY, gp.tileSize, gp.tileSize);
    }

    /**
     * Disposes of the player texture when the game is closed. Not sure how to use yet
     */
    public void dispose() {
        playerTexture.dispose();
    }
}

