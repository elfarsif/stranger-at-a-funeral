package io.github.elfarsif.gdx;


import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

import java.awt.event.KeyEvent;

public class KeyHandler extends InputAdapter {
    public GamePanel gp;
    public boolean upPressed;
    public boolean downPressed;
    public boolean leftPressed;
    public boolean rightPressed;
    public boolean ePressed;
    public boolean tPressed;

    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }

    @Override
    public boolean keyDown(int code) {
        //DEBUG TIME
        if(code == Input.Keys.T){
            tPressed = !tPressed;
        }
        //PLAY STATE
        if(gp.gameState == gp.playState){
            if (code == Input.Keys.W) {
                upPressed = true;
            }
            if (code == Input.Keys.A) {
                leftPressed = true;
            }
            if (code == Input.Keys.S) {
                downPressed = true;
            }
            if (code == Input.Keys.D) {
                rightPressed = true;
            }
            if(code == Input.Keys.E){
                ePressed = true;
            }

            if(code == Input.Keys.P){
                if(gp.gameState == gp.playState){
                    gp.gameState = gp.pauseState;
                }else if(gp.gameState == gp.pauseState){
                    gp.gameState = gp.playState;
                }
            }
        }else if(gp.gameState == gp.dialogueState){
            if(code == Input.Keys.SPACE){
                gp.gameState = gp.playState;
            }
        }else if(gp.gameState == gp.pauseState){
            if(code == Input.Keys.P){
                gp.gameState = gp.playState;
            }
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.W) {
            upPressed = false;
        }
        if (keycode == Input.Keys.A) {
            leftPressed = false;
        }
        if (keycode == Input.Keys.S) {
            downPressed = false;
        }
        if (keycode == Input.Keys.D) {
            rightPressed = false;
        }
        return true;
    }
}
