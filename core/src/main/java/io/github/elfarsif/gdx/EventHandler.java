package io.github.elfarsif.gdx;

public class EventHandler {
    GamePanel gp;
    EventRect[][][] eventRect;

    int previousEventX, previousEventY;
    boolean canTouchEvent = true;
    int tempMap, tempCol, tempRow;


    public EventHandler(GamePanel gp){
        this.gp = gp;

        eventRect = new EventRect[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];

        int map =0;


        int col = 0;
        int row = 0;
        while(map<gp.maxMap && col<gp.maxWorldCol && row<gp.maxWorldRow){
            eventRect[map][col][row] = new EventRect();
            eventRect[map][col][row].x = gp.tileSize/2;
            eventRect[map][col][row].y = gp.tileSize/2;
            eventRect[map][col][row].width = 2;
            eventRect[map][col][row].height = 2;
            eventRect[map][col][row].eventReactDefaultX = eventRect[map][col][row].x;
            eventRect[map][col][row].eventReactDefaultY = eventRect[map][col][row].y;

            col++;
            if(col == gp.maxWorldCol){
                col = 0;
                row++;
                if(row == gp.maxWorldRow){
                    row = 0;
                    map++;
                }
            }

        }
    }

    public void checkEvent(){

        //check if player is more than 1 tile away from previous event
        int xDistance = Math.abs(gp.player.worldX + previousEventX);
        int yDistance = Math.abs(gp.player.worldY + previousEventY);
        int distance = Math.max(xDistance, yDistance);

        if(distance > gp.tileSize){
            canTouchEvent = true;
        }
        if(canTouchEvent){
            if(hit(0,29,6,"up")){
                findTresure(0,29,6);
            }
            else if(hit(0,32,38,"up")){
                switchToMap(1,31,38);
            }
            else if(hit(1,32,38,"up")){
                switchToMap(0,31,35);
            }
            else if(hit(0,32,37,"up")){
//                this.oscaelMeetingCutscene();
            }

        }

    }

    public void oscaelMeetingCutscene(){
        gp.gameState = gp.cutsceneState;
        gp.cutsceneManager.sceneNum = gp.cutsceneManager.oscaelIntro;
    }

    private void switchToMap(int map, int col, int row) {
        System.out.println("handle event");
        gp.gameState = gp.transitionMapState;
        tempMap = map;
        tempCol = col;
        tempRow = row;


        canTouchEvent = false;
    }

    private void findTresure(int map, int col, int row) {
        System.out.println("handle event");
        gp.gameState = 3;
        gp.ui.currentDialogue = "You found a treasure chest!";
        gp.ui.draw(gp.spriteBatch);
        eventRect[map][col][row].eventDone = false;
        gp.player.currentLife --;
    }

    public boolean hit(int map, int col, int row, String reqDirection){
        boolean hit = false;


        if (map== gp.currentMap){
            gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
            gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
            eventRect[map][col][row].x = col * gp.tileSize + eventRect[map][col][row].x;
            eventRect[map][col][row].y = row * gp.tileSize + eventRect[map][col][row].y;

            if(gp.player.solidArea.intersects(eventRect[map][col][row]) && !eventRect[map][col][row].eventDone){
                if(gp.player.direction.equals(reqDirection) || reqDirection.equals("any")) {
                    hit = true;
                    previousEventX = gp.player.worldX;
                    previousEventY = gp.player.worldY;


                }
            }

            gp.player.solidArea.x = gp.player.solidAreaDefaultX;
            gp.player.solidArea.y = gp.player.solidAreaDefaultY;
            eventRect[map][col][row].x = eventRect[map][col][row].eventReactDefaultX;
            eventRect[map][col][row].y = eventRect[map][col][row].eventReactDefaultY;
        }

        return hit;
    }

    private void removeGrass(int map, int col, int row) {
        gp.ui.addMessage("You removed the grass");
    }




}
