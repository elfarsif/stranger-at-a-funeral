package io.github.elfarsif.gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import io.github.elfarsif.entity.Entity;
import io.github.elfarsif.objects.HealthBar;

import java.awt.*;
import java.util.ArrayList;

public class UI {
    private GamePanel gp;
    private BitmapFont font;
    private Texture mushroomTexture;
    private boolean messageOn = false;
    public boolean gameFinished = false;
    SpriteBatch spriteBatch;
    public String currentDialog;
    private ShapeRenderer shapeRenderer;
    private Texture titleScreenImage;
    private Texture inventoryStrip;
    public int commandNum = 0;
    Sprite health1, health2, health3;
    public int slotCol = 0;
    public int slotRow = 0;
    ArrayList<String> messages = new ArrayList<>();
    ArrayList<Integer> messageCounter = new ArrayList<>();

    public UI(GamePanel gp) {
        this.gp = gp;
        this.font = new BitmapFont();
        this.font.getData().setScale(2f);
        this.shapeRenderer = new ShapeRenderer();
        loadBackgroundImage();
        loadUIImages();

        //CREATE HEALTH OBJECTS
        Entity healthBar = new HealthBar(gp);
        health1 = healthBar.down1;
        health2 = healthBar.down2;
        health3 = healthBar.down3;
    }

    private void loadUIImages(){
        try{
            inventoryStrip = new Texture(Gdx.files.internal("ui/inventory-strip.png"));
        }catch (Exception e){
            throw new RuntimeException("Error loading image inventory strip:"+e);
        }
    }

    public void addMessage(String text){
        messages.add(text);
        messageCounter.add(0);
    }

    private void loadBackgroundImage() {
        try{
            titleScreenImage = new Texture(Gdx.files.internal("player/standing/character.png"));
        }catch (Exception e){
            throw new RuntimeException("Error loading image title screen image:"+e);
        }
    }

    private void drawMessage() {
        int messageX = gp.tileSize;
        int messageY = gp.tileSize*5;


        for(int i = 0; i < messages.size(); i++){
            if(messages.get(i) != null){
                font.setColor(Color.WHITE);
                font.draw(spriteBatch, messages.get(i), messageX, messageY);

                int counter = messageCounter.get(i)+i;
                messageCounter.set(i,counter);
                messageY +=50;

                if(counter > 120){
                    messages.remove(i);
                    messageCounter.remove(i);
                }
            }
        }

    }

    public void draw(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;

        font.setColor(Color.WHITE);
        //Play State
        if (gp.gameState == gp.playState){
            //play state studd
            drawMessage();
            drawHealthBar();
            drawInventory();
        }

        //Pause State
        if (gp.gameState == gp.pauseState){
            drawPauseScreen();
        }
        //Dialog State
        if (gp.gameState == gp.dialogueState){
            drawDialogScreen();
            drawHealthBar();
        }
        //TITLE STATE
        if(gp.gameState == gp.titleState){
            drawTitleScreen();
        }
    }

    private void drawInventory() {

        int frameX = gp.screenWidth/2-gp.tileSize*6;
        int frameY = gp.tileSize/2;

        spriteBatch.draw(inventoryStrip,frameX,frameY,gp.tileSize*13,gp.tileSize*2);

        //SLOT
        final int slotXStart = frameX + gp.tileSize/2;
        final int slotYStart = frameY + gp.tileSize/2;
        int slotX = slotXStart;
        int slotY = slotYStart;

        //DRAW PLAYER INVENTORY
        for(int i = 0; i < gp.player.inventory.size(); i++){
            spriteBatch.draw(gp.player.inventory.get(i).down1,slotX,slotY,gp.tileSize,gp.tileSize);
            slotX += gp.tileSize + gp.tileSize/2-8;

        }

        //CURSOR
        int cursorX = slotXStart + slotCol*(gp.tileSize+gp.tileSize/2-8);
        int cursorY = slotYStart + slotRow*gp.tileSize;
        int cursorWidth = gp.tileSize;
        int cursorHeight = gp.tileSize;

        //DRAW CURSOR
     /*   g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawRoundRect(cursorX,cursorY,cursorWidth,cursorHeight,10,10);*/


        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(cursorX, cursorY, cursorWidth, cursorHeight);
        shapeRenderer.end();


    }

    private void drawHealthBar() {
        int x = gp.tileSize/2;
        int y = gp.tileSize;

        if(gp.player.currentLife == 3){
            spriteBatch.draw(health3, x, y, gp.tileSize, gp.tileSize*4);
        }

        if(gp.player.currentLife == 2){
            spriteBatch.draw(health2, x, y, gp.tileSize, gp.tileSize*4);
        }

        if(gp.player.currentLife == 1){
            spriteBatch.draw(health1, x, y, gp.tileSize, gp.tileSize*4);
        }

        if(gp.player.currentLife <= 0){
            spriteBatch.draw(health1, x, y, gp.tileSize, gp.tileSize*4);
        }
    }

    private void drawTitleScreen() {
        font.getData().setScale(2f);
        String text = "Spiritstead";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight - gp.tileSize*2;

        //SHADOW
        font.setColor(Color.GRAY);
        font.draw(spriteBatch, text, x + 3, y - 3);
        font.setColor(Color.WHITE);
        font.draw(spriteBatch, text, x, y);

        //Image
        x = gp.screenWidth / 2 - gp.tileSize;
        y -= gp.tileSize*3;
        spriteBatch.draw(titleScreenImage, x, y, gp.tileSize*2, gp.tileSize*2);

        //MENU
        font.getData().setScale(1.5f);
        text = "New Game";
        x = getXforCenteredText(text);
        y -= gp.tileSize;
        font.draw(spriteBatch, text, x, y);
        if(commandNum == 0){
            font.draw(spriteBatch, ">", x - gp.tileSize, y);
        }

        text = "Load Game";
        x = getXforCenteredText(text);
        y -= gp.tileSize;
        font.draw(spriteBatch, text, x, y);
        if(commandNum == 1){
            font.draw(spriteBatch, ">", x - gp.tileSize, y);
        }

        text = "Quit";
        x = getXforCenteredText(text);
        y -= gp.tileSize;
        font.draw(spriteBatch, text, x, y);
        if(commandNum == 2){
            font.draw(spriteBatch, ">", x - gp.tileSize, y);
        }
    }

    private void drawDialogScreen() {
        //Window
        int x = gp.tileSize*2;
        int y = gp.tileSize/2;
        int width = gp.screenWidth - gp.tileSize*4;
        int height = gp.tileSize*5;

        drawSubWindow(x,y,width,height);
        font = new BitmapFont();
        font.getData().setScale(1.5f); // Adjust font size as needed
        font.setColor(Color.WHITE);
        font.draw(spriteBatch, currentDialog, x + gp.tileSize, y + height - gp.tileSize);
    }

    public void drawSubWindow(int x, int y, int width, int height){
        Texture rectangleTexture;
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);

        // Draw filled rectangle (semi-transparent black)
        pixmap.setColor(new Color(0, 0, 0, 0.8f));
        pixmap.fillRectangle(0, 0, width, height);

        // Draw border (white)
        pixmap.setColor(Color.WHITE);
        pixmap.drawRectangle(3, 3, width - 6, height - 6);

        // Convert Pixmap to Texture
        rectangleTexture = new Texture(pixmap);
        pixmap.dispose();
        gp.spriteBatch.draw(rectangleTexture, x, y);
    }

    private void drawPauseScreen() {
        //Frame
        final int frameX = gp.tileSize*2;
        final int frameY = gp.tileSize*2;
        final int frameWidth = gp.tileSize*10;
        final int frameHeight = gp.tileSize*5;
        drawSubWindow(frameX,frameY,frameWidth,frameHeight);

        //Text
        font.setColor(Color.WHITE);
//        g2d.setFont(g2d.getFont().deriveFont(Font.PLAIN, 22));

        int textX = frameX + gp.tileSize/2;
        int textY = frameY + gp.tileSize/2;
        final int lineHeight = gp.tileSize;//font height

        //Names
        font.draw(spriteBatch, "Level", textX, textY);
        textY += lineHeight;
        font.draw(spriteBatch, "Attack", textX, textY);
        textY += lineHeight;
        font.draw(spriteBatch, "XP", textX, textY);
        textY += lineHeight;
        font.draw(spriteBatch, "Weapon", textX, textY);
        textY += lineHeight;
        font.draw(spriteBatch, "Defense", textX, textY);

        //VALUES
        int tailX = frameX + frameWidth - 30;
        textY = frameY + gp.tileSize/2;
        String value;

        value = String.valueOf(gp.player.level);
        textX = getXforAlignToRightText(font,value,tailX);
        font.draw(spriteBatch, value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.attack);
        textX = getXforAlignToRightText(font,value,tailX);
        font.draw(spriteBatch, value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.exp);
        textX = getXforAlignToRightText(font,value,tailX);
        font.draw(spriteBatch, value, textX, textY);
        textY += lineHeight;

        value = gp.player.currentWeapon.name;
        textX = getXforAlignToRightText(font,value,tailX);
        font.draw(spriteBatch, value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.defense);
        textX = getXforAlignToRightText(font,value,tailX);
        font.draw(spriteBatch, value, textX, textY);
        textY += lineHeight;

    }

    public int getXforCenteredText(String text){
        GlyphLayout layout = new GlyphLayout(font, text);
        return (int) (gp.screenWidth / 2 - layout.width / 2);
    }

    public int getXforAlignToRightText(BitmapFont font, String text, int tailX) {
        GlyphLayout layout = new GlyphLayout();
        layout.setText(font, text);
        int length = (int) layout.width;
        return tailX - length;
    }

}
