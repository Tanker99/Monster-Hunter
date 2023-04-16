/*public class Collision {
    GamePanel gp;
    public Collision(GamePanel gp){
        this.gp = gp;
    }
    public void checker(Entity entity){
    int playerleftx = entity.worldx + entity.hitbox.x;
    int playerrightx = entity.worldx + entity.hitbox.x + entity.hitbox.width;
    int playertopy = entity.worldy + entity.hitbox.y;
    int playerbottomy = entity.worldy + entity.hitbox.y + entity.hitbox.height;

    int playerleftcol = playerleftx/gp.tileSize;
    int playerrightcol = playerrightx/gp.tileSize;
    int playertoprow = playerbottomy/gp.tileSize;
    int playerbottomrow = playerbottomy/gp.tileSize;

    int tileNum1, tileNum2;

    switch (entity.ImageDirection){
        case "up":
            playertoprow = (playertopy - entity.speed)/gp.tileSize;
            tileNum1 = gp.tileT.mapTileNum[playerleftcol][playertoprow];
            tileNum2 = gp.tileT.mapTileNum[playerrightcol][playertoprow];
            if(gp.tileT.tile[tileNum1].collision == true || gp.tileT.tile[tileNum2].collision == true){
                entity.collitionan = true;
            }
        break;
    }
    }



} */
