package io.github.elfarsif.gdx;


import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;


public class KeyHandler extends InputAdapter {
    public GamePanel gp;
    public boolean upPressed;
    public boolean downPressed;
    public boolean leftPressed;
    public boolean rightPressed;
    public boolean spacePressed;
    public boolean showDebug;

    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }

    @Override
    public boolean keyDown(int code) {
        //DEBUG TIME
        if(code == Input.Keys.T){
            showDebug = !showDebug;
        }
        //TITLE STATE
        if(gp.gameState == gp.titleState){
            titleState(code);
        }
        //PLAY STATE
        else if(gp.gameState == gp.playState){
            playState(code);
        //DIALOGUE STATE
        }else if(gp.gameState == gp.dialogueState){
            dialogueState(code);
        //PAUSE STATE
        }else if(gp.gameState == gp.pauseState){
            pauseState(code);
        }
        return true;
    }

    private void pauseState(int code) {
        if(code == Input.Keys.P){
            gp.gameState = gp.playState;
        }
    }

    private void dialogueState(int code) {
        if(code == Input.Keys.SPACE){
            gp.gameState = gp.playState;
        }
    }

    private void playState(int code) {
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
        if(code == Input.Keys.SPACE){
            spacePressed = true;
        }

        if(code == Input.Keys.J){
            if(gp.ui.slotCol!=0){
                gp.ui.slotCol--;
                gp.playSoundEffect(2);
                gp.player.selectItem();
            }

        }
        if (code == Input.Keys.K){
            if(gp.ui.slotCol!=8){
                gp.ui.slotCol++;
                gp.playSoundEffect(2);
                gp.player.selectItem();
            }
        }

        if(code == Input.Keys.ENTER){
            gp.player.selectItem();
        }

        if(code == Input.Keys.P){
            if(gp.gameState == gp.playState){
                gp.gameState = gp.pauseState;
            }else if(gp.gameState == gp.pauseState){
                gp.gameState = gp.playState;
            }
        }
    }

    private void titleState(int code) {
        if (code == Input.Keys.W) {
            gp.ui.commandNum--;
            if(gp.ui.commandNum < 0){
                gp.ui.commandNum = 2;
            }
        }
        if (code == Input.Keys.S) {
            gp.ui.commandNum++;
            if(gp.ui.commandNum > 2){
                gp.ui.commandNum = 0;
            }

        }
        if(code == Input.Keys.ENTER){
            switch (gp.ui.commandNum){
                case 0:
                    System.out.println("New Game not implemented");
                    break;
                case 1:
                    gp.gameState = gp.playState;
                    break;
                case 2:
                    System.exit(0);
                    break;
            }
        }
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
