package io.github.elfarsif.gdx;


import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class KeyHandler extends InputAdapter {
    public boolean upPressed;
    public boolean downPressed;
    public boolean leftPressed;
    public boolean rightPressed;

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
