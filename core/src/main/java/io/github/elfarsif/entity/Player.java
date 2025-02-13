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
    public final int screenX;
    public final int screenY;
    public int hasMushroom = 0;

    public Player(GamePanel gp, KeyHandler keyHandler) {
        super(gp);
        this.gp = gp;
        this.keyHandler = keyHandler;
        screenX = gp.screenWidth / 2 - gp.tileSize / 2;
        screenY = gp.screenHeight / 2 - gp.tileSize / 2;

        solidArea = new Rectangle();
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = gp.tileSize;
        solidArea.height = gp.tileSize;

        setDefaultValues();
        getPlayerImage();
    }

    private void getPlayerImage() {
        down1 = setup("player/walking/down1.png");
        down2 = setup("player/walking/down2.png");
        up1 = setup("player/walking/up1.png");
        up2 = setup("player/walking/up2.png");
        left1 = setup("player/walking/left1.png");
        left2 = setup("player/walking/left2.png");
        right1 = setup("player/walking/right1.png");
        right2 = setup("player/walking/right2.png");

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

            if (keyHandler.upPressed && keyHandler.rightPressed) {
                direction = "up-right";
            }
            if (keyHandler.upPressed && keyHandler.leftPressed) {
                direction = "up-left";
            }
            if (keyHandler.downPressed && keyHandler.rightPressed) {
                direction = "down-right";
            }
            if (keyHandler.downPressed && keyHandler.leftPressed) {
                direction = "down-left";
            }

            //check tile collision
            collisionOn = false;
            gp.collisionChecker.checkTile(this);

            //check object collision
            int objectIndex = gp.collisionChecker.checkObject(this, true);
            pickUpObject(objectIndex);

            //check npc collision
            int npcIndex = gp.collisionChecker.checkEntity(this, gp.npc);
            interactNPC(npcIndex);

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
                    case "up-right":
                        worldY += speed;
                        worldX += speed;
                        break;
                    case "up-left":
                        worldY += speed;
                        worldX -= speed;
                        break;
                    case "down-right":
                        worldY -= speed;
                        worldX += speed;
                        break;
                    case "down-left":
                        worldY -= speed;
                        worldX -= speed;
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

    private void interactNPC(int i) {
        if (i != 999) {
            if (gp.keyHandler.ePressed) {
                gp.gameState = gp.dialogueState;
                gp.npc[i].speak();
            }
        }
        gp.keyHandler.ePressed = false;
    }

    private void pickUpObject(int objectIndex) {
        if (objectIndex != 999) {

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
            case "up-left":
                if (spriteNumber == 1) {
                    image = left1;
                }
                if (spriteNumber == 2) {
                    image = left2;
                }
                break;
            case "down-left":
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
            case "up-right":
                if (spriteNumber == 1) {
                    image = right1;
                }
                if (spriteNumber == 2) {
                    image = right2;
                }
                break;
            case "down-right":
                if (spriteNumber == 1) {
                    image = right1;
                }
                if (spriteNumber == 2) {
                    image = right2;
                }
                break;
        }
        batch.draw(image, screenX, screenY, gp.tileSize * 2, gp.tileSize * 2);
    }

    /**
     * Disposes of the player texture when the game is closed. Not sure how to use yet
     */
    public void dispose() {
        playerTexture.dispose();
    }
}

