package io.github.elfarsif.entity;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.elfarsif.gdx.GamePanel;
import com.badlogic.gdx.graphics.Color;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
/**
 * Represents a general entity in the game, including the player, NPCs, and monsters, objects, tools.
 * Handles common attributes and behaviors such as movement, collision, drawing on the screen, and interactions with other entities.
 */
public abstract class Entity {
    public GamePanel gp;
    public Sprite down1, down2,down3,down4,down5,down6,down7,down8,
            up1, up2, up3, up4, up5, up6,up7, up8,
            left1, left2, left3, left4, left5, left6,left7, left8,
            right1, right2, right3, right4, right5, right6, right7, right8;
    public Sprite attackUp1, attackUp2, attackUp3, attackUp4,
        attackDown1, attackDown2, attackDown3, attackDown4,
        attackLeft1, attackLeft2, attackLeft3, attackLeft4,
        attackRight1, attackRight2, attackRight3, attackRight4;
    public Rectangle attackArea = new Rectangle(0,0,0,0);
    public Rectangle solidArea ;
    public int solidAreaDefaultX, solidAreaDefaultY;
    String[] dialogs = new String[10];
    public boolean collision = false;
    public String description="";

    //STATE
    public int worldX, worldY;
    public String direction = "down";
    public boolean invincible = false;
    public boolean attacking = false;
    int spriteNumber =1;
    int dialogIndex=0;
    public boolean alive = true;
    public boolean dying = false;
    boolean hpBarOn = false;
    public Boolean collisionOn = false;

    //COUNTERS
    int spriteCounter = 0;
    public int invincibleCounter = 0;
    public int actionLookCounter = 0;
    int dyingCounter = 0;
    int hpBarCounter = 0;

    //CHARACTER ATTRIBUTES
    public String name;
    public int maxLife;
    public int currentLife;
    public int speed;
    public int maxMana;
    public int currentMana;
    public int strength;
    public int level;
    public int attack;
    public int defense;
    public int exp;
    public int nextLevelExp;
    public int coin;
    public Entity currentWeapon;
    public Entity currentShield;
    public Projectile projectile;

    //TYPE
    public int type;//0 player, 1 npc, 2 monster
    public final int type_monster = 2;
    public final int type_sword=3;
    public final int type_sword_copper=4;
    public final int type_shield=5;
    public final int type_consumable=6;

    //ITEM ATTRIBUTES
    public int value;
    public int attackValue;
    public int defenseValue;
    public int projectileUseCost;

    public Entity(GamePanel gp){
        this.gp = gp;
        setDefaultSolidArea();

    }
    /**
     * Configures the default solid area for collision detection.
     */
    private void setDefaultSolidArea() {
        solidArea = new Rectangle();
        solidArea.x = 12*3;
        solidArea.y = 24*3;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 8*3;
        solidArea.height = 8*3;

    }

    public void setAction(){}

    public void update() {
        setAction();
        collisionOn = false;
        gp.collisionChecker.checkTile(this);
        gp.collisionChecker.checkObject(this, false);
        gp.collisionChecker.checkEntity(this,gp.npc);
        gp.collisionChecker.checkEntity(this,gp.monsters);
        boolean contactPlayer = gp.collisionChecker.checkPlayer(this);

        if (this.type == type_monster && contactPlayer) {
           damagePlayer(attack);
        }

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
        if(spriteCounter > 12){
            if(spriteNumber == 1){
                spriteNumber = 2;
            }else if(spriteNumber == 2){
                spriteNumber = 1;
            }
            spriteCounter = 0;
        }

        if (invincible) {
            invincibleCounter++;
            //60FPS ie 1 second
            if (invincibleCounter > 40) {
                invincible = false;
                invincibleCounter = 0;
            }
        }
    }

    public void damagePlayer(int attack){
        if (!gp.player.invincible) {
            int damage = attack - gp.player.defense;
            if(damage < 0){
                damage = 0;
            }
            gp.player.currentLife -= damage;
            gp.player.invincible = true;
        }
    }

    public void applyConsumable(Entity entity){}

    public Sprite setup(String path){
        Sprite image = null;
        try {
            image = new Sprite(new Texture(path));
            image.setSize(gp.tileSize*2, gp.tileSize*2);
        } catch (Exception e) {
            throw new RuntimeException("Error reading image :"+e);
        }
        return image;
    }

    public void speak(){
        if(dialogs[dialogIndex] == null){
            dialogIndex = 0;
            gp.gameState = gp.playState;
        }
        gp.ui.currentDialog = dialogs[dialogIndex];
        dialogIndex++;
    }

    public void checkDrop(){

    }

    public void dropItem(Entity droppedItem){
        for (int i = 0 ; i<gp.objects.length;i++){
            if (gp.objects[i] == null){
                gp.objects[i] = droppedItem;
                gp.objects[i].worldX = worldX;
                gp.objects[i].worldY = worldY;
                break;
            }
        }
    }

    public void draw(SpriteBatch batch) {
        Sprite image = null;

        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        //check if tiles is in the screen + 1 tile
        if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
            worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
            worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
            worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){

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

            //MONSTER HEALTH BAR
            if (type == 2 && hpBarOn) {



                Texture whiteTexture;
                Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
                pixmap.setColor(com.badlogic.gdx.graphics.Color.WHITE);
                pixmap.fill();
                whiteTexture = new Texture(pixmap);
                pixmap.dispose();

                double oneScale = (double) gp.tileSize / (double) maxLife;
                double hpBarValue = oneScale * currentLife;

                // Outline
                batch.setColor(Color.DARK_GRAY);
                batch.draw(whiteTexture, screenX - 1, screenY - 11, gp.tileSize + 2, 7);

                // Health bar
                batch.setColor(new Color(1, 0, 0.12f, 1)); // Red color normalized
                batch.draw(whiteTexture, (float) screenX, (float) (screenY - 10), (float) hpBarValue, 5);

                // Reset color to avoid affecting other draws
                batch.setColor(Color.WHITE);

                hpBarCounter++;

                if (hpBarCounter>600){
                    hpBarCounter = 0;
                    hpBarOn = false;
                }
            }


            if (invincible){
                hpBarOn = true;
                hpBarCounter = 0;
                changeAlphaForDyingAnimationa(batch,0.5f);
            }

            if (dying){
                dyingAnimation(batch);
            }

//            float width = image.getWidth();
//            float height = image.getHeight();
            batch.draw(image, screenX, screenY, gp.tileSize*2, gp.tileSize*2);

            batch.setColor(1,1,1,1);
        }

    }

    private void dyingAnimation(SpriteBatch batch) {
        dyingCounter++;

        int dyingFrames = 5;

        if (dyingCounter<=dyingFrames){
            changeAlphaForDyingAnimationa(batch,0f);
        }
        if (dyingCounter>dyingFrames && dyingCounter<=dyingFrames*2){
            changeAlphaForDyingAnimationa(batch,1f);
        }
        if (dyingCounter>dyingFrames*2 && dyingCounter<=dyingFrames*3){
            changeAlphaForDyingAnimationa(batch,0f);
        }
        if (dyingCounter>dyingFrames*3 && dyingCounter<=dyingFrames*4){
            changeAlphaForDyingAnimationa(batch,1f);
        }
        if (dyingCounter>dyingFrames*4 && dyingCounter<=dyingFrames*5){
            changeAlphaForDyingAnimationa(batch,0f);
        }
        if (dyingCounter>dyingFrames*5 && dyingCounter<=dyingFrames*6){
            changeAlphaForDyingAnimationa(batch,1f);
        }
        if (dyingCounter>dyingFrames*6 && dyingCounter<=dyingFrames*7){
            changeAlphaForDyingAnimationa(batch,0f);
        }
        if (dyingCounter>dyingFrames*7){
            alive = false;
        }


    }


    private void changeAlphaForDyingAnimationa(SpriteBatch batch,float alpha){
        batch.setColor(1,1,1,alpha);
    }

    public void damageReaction() {

    }
}
