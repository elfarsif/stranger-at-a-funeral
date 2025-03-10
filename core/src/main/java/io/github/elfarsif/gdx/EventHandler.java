package io.github.elfarsif.gdx;

public class EventHandler {
    GamePanel gp;
    EventRect[][] eventRect;


    public EventHandler(GamePanel gp){
        this.gp = gp;

        eventRect = new EventRect[gp.maxWorldCol][gp.maxWorldRow];


        int col = 0;
        int row = 0;
        while(col<gp.maxWorldCol && row<gp.maxWorldRow){
            eventRect[col][row] = new EventRect();
            eventRect[col][row].x = gp.tileSize/2;
            eventRect[col][row].y = gp.tileSize/2;
            eventRect[col][row].width = 2;
            eventRect[col][row].height = 2;
            eventRect[col][row].eventReactDefaultX = eventRect[col][row].x;
            eventRect[col][row].eventReactDefaultY = eventRect[col][row].y;

            col++;
            if(col == gp.maxWorldCol){
                col = 0;
                row++;
            }

        }
    }

    public void checkEvent(){
        if(hit(9,6,"up")){
            findTreasure(9,6);
        }

    }

    private void findTreasure(int col, int row) {
        System.out.println("handle event");
        gp.gameState = 3;
        gp.ui.currentDialog = "You found a treasure chest!";
        gp.ui.draw(gp.spriteBatch);
        eventRect[col][row].eventDone = false;
        gp.player.currentLife --;
    }

    public boolean hit(int col, int row, String reqDirection){
        boolean hit = false;

        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
//        gp.spriteBatch.drawRect(eventRect.x, eventRect.y, eventRect.width, eventRect.height);

        eventRect[col][row].x = col * gp.tileSize + eventRect[col][row].x;
        eventRect[col][row].y = row * gp.tileSize + eventRect[col][row].y;

        if(gp.player.solidArea.intersects(eventRect[col][row])&& !eventRect[col][row].eventDone){
            if(gp.player.direction.equals(reqDirection) || reqDirection.equals("any")) {
                hit = true;
            }
        }

        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect[col][row].x = eventRect[col][row].eventReactDefaultX;
        eventRect[col][row].y = eventRect[col][row].eventReactDefaultY;

        return hit;
    }






}
