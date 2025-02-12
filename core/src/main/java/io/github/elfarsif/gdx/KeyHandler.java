package io.github.elfarsif.gdx;


import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class KeyHandler extends InputAdapter {
    public GamePanel gp;
    public boolean upPressed;
    public boolean downPressed;
    public boolean leftPressed;
    public boolean rightPressed;

    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.W) {
            upPressed = true;
        }
        if (keycode == Input.Keys.A) {
            leftPressed = true;
        }
        if (keycode == Input.Keys.S) {
            downPressed = true;
        }
        if (keycode == Input.Keys.D) {
            rightPressed = true;
        }
        if(keycode == Input.Keys.P){
            if(gp.gameState == gp.playState){
                gp.gameState = gp.pauseState;
            }else if(gp.gameState == gp.pauseState){
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
