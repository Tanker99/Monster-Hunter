package Game;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Tilemanager {
    GamePanel gp;
    public Tile [] tile;
    public int mapTileNum[][];

    public Tilemanager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[30];
        mapTileNum = new int [gp.maxWelttilescol][gp.maxWelttilesrow];
        getTileImage();
        loadMap("/Welt/worldmap.txt");
    }
    public void getTileImage(){
        try{
            tile[0] =new Tile();
            tile[0].image = ImageIO.read(UI.class.getResource("/world/grass1.png"));

            tile[1] =new Tile();
            tile[1].image = ImageIO.read(UI.class.getResource("/world/grassflowers1.png"));

            tile[2] =new Tile();
            tile[2].image = ImageIO.read(UI.class.getResource("/world/treewood1.png"));
            tile[2].collision = true;

            tile[3] =new Tile();
            tile[3].image = ImageIO.read(UI.class.getResource("/world/treeleaf1.png"));
            tile[3].collision = true;

            tile[4] =new Tile();
            tile[4].image = ImageIO.read(UI.class.getResource("/world/stone1.png"));
            tile[4].collision = true;

            tile[5] =new Tile();
            tile[5].image = ImageIO.read(UI.class.getResource("/world/housewood1.png"));
            tile[5].collision = true;

            tile[6] =new Tile();
            tile[6].image = ImageIO.read(UI.class.getResource("/world/housedoor.png"));
            tile[6].collision = true;

            tile[7] =new Tile();
            tile[7].image = ImageIO.read(UI.class.getResource("/world/roofright.png"));
            tile[7].collision = true;

            tile[8] =new Tile();
            tile[8].image = ImageIO.read(UI.class.getResource("/world/roofmiddle.png"));
            tile[8].collision = true;

            tile[9] =new Tile();
            tile[9].image = ImageIO.read(UI.class.getResource("/world/roofleft.png"));
            tile[9].collision = true;

            tile[10] =new Tile();
            tile[10].image = ImageIO.read(UI.class.getResource("/world/castlebrick1.png"));
            tile[10].collision = true;

            tile[11] =new Tile();
            tile[11].image = ImageIO.read(UI.class.getResource("/world/castlebrick2.png"));
            tile[11].collision = true;

            tile[12] =new Tile();
            tile[12].image = ImageIO.read(UI.class.getResource("/world/castleroofleft.png"));
            tile[12].collision = true;

            tile[13] =new Tile();
            tile[13].image = ImageIO.read(UI.class.getResource("/world/castleroofright.png"));
            tile[13].collision = true;

            tile[14] =new Tile();
            tile[14].image = ImageIO.read(UI.class.getResource("/world/castlewindow.png"));
            tile[14].collision = true;

            tile[15] =new Tile();
            tile[15].image = ImageIO.read(UI.class.getResource("/world/castlewindowtorch.png"));
            tile[14].collision = true;

            tile[16] =new Tile();
            tile[16].image = ImageIO.read(UI.class.getResource("/world/tiles/Weg.png"));

            tile[17] =new Tile();
            tile[17].image = ImageIO.read(UI.class.getResource("/world/tiles/Gras.png"));
            //tile[17].collision = true;

            tile[18] =new Tile();
            tile[18].image = ImageIO.read(UI.class.getResource("/world/tiles/Stein.png"));
            //tile[18].collision = true;


        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void loadMap(String map){
        try{
            InputStream is = getClass().getResourceAsStream(map);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            while (col < gp.maxWelttilescol && row < gp.maxWelttilesrow){
                String line = br.readLine();

                while (col< gp.maxWelttilescol){
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] =num;
                    col++;
                }
                if(col == gp.maxWelttilescol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }catch(Exception e){

        }
    }
    public void draw(Graphics2D g2){
        int weltcol = 0;
        int weltrow = 0;


        while (weltcol < gp.maxWelttilescol && weltrow < gp.maxWelttilesrow) {
            int tileNum = mapTileNum[weltcol][weltrow];
            int weltx = weltcol * gp.tileSize;
            int welty = weltrow * gp.tileSize;
            int screenx = weltx - gp.player.worldx + gp.player.screenx;
            int screeny = welty - gp.player.worldy + gp.player.screeny;

            if(weltx + gp.tileSize > gp.player.worldx - gp.player.screenx &&
                    weltx - gp.tileSize < gp.player.worldx + gp.player.screenx &&
                    welty + gp.tileSize > gp.player.worldy - gp.player.screeny &&
                    welty - gp.tileSize < gp.player.worldy + gp.player.screeny) {

                g2.drawImage(tile[tileNum].image, screenx, screeny, gp.tileSize, gp.tileSize, null);
            }
            weltcol++;


            if(weltcol == gp.maxWelttilescol){
                weltcol = 0;
                weltrow ++;

            }
        }
    }
}