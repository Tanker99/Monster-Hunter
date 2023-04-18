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
        tile = new Tile[50];
        mapTileNum = new int [gp.maxWelttilescol][gp.maxWelttilesrow];
        getTileImage();
        loadMap("/Welt/worldmap.txt");
    }
    public void getTileImage(){
        try{
            tile[0] =new Tile();
            tile[0].image = ImageIO.read(UI.class.getResource("/world/grass1.png"));

            tile[1] =new Tile();
            tile[1].image = ImageIO.read(UI.class.getResource("/world/tiles/grassflowers2.png"));

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
            tile[15].collision = true;

            tile[16] =new Tile();
            tile[16].image = ImageIO.read(UI.class.getResource("/world/tiles/wayhorizontal.png"));

            tile[17] =new Tile();
            tile[17].image = ImageIO.read(UI.class.getResource("/world/tiles/wayvertikal.png"));

            tile[18] =new Tile();
            tile[18].image = ImageIO.read(UI.class.getResource("/world/tiles/wayleftupcorner.png"));

            tile[19] =new Tile();
            tile[19].image = ImageIO.read(UI.class.getResource("/world/tiles/wayrightupcorner.png"));

            tile[20] =new Tile();
            tile[20].image = ImageIO.read(UI.class.getResource("/world/tiles/wayleftdowncorner.png"));

            tile[21] =new Tile();
            tile[21].image = ImageIO.read(UI.class.getResource("/world/tiles/waymiddlup.png"));

            tile[22] =new Tile();
            tile[22].image = ImageIO.read(UI.class.getResource("/world/tiles/wayrightupfull.png"));

            tile[23] =new Tile();
            tile[23].image = ImageIO.read(UI.class.getResource("/world/tiles/waymiddluprightfull.png"));

            tile[24] =new Tile();
            tile[24].image = ImageIO.read(UI.class.getResource("/world/tiles/castledoorleft.png"));
            tile[24].collision = true;

            tile[25] =new Tile();
            tile[25].image = ImageIO.read(UI.class.getResource("/world/tiles/castledoorright.png"));
            tile[25].collision = true;

            tile[26] =new Tile();
            tile[26].image = ImageIO.read(UI.class.getResource("/world/tiles/shopdoor.png"));
            tile[26].collision = true;

            tile[27] =new Tile();
            tile[27].image = ImageIO.read(UI.class.getResource("/world/tiles/grasswayhorizontal.png"));

            tile[28] =new Tile();
            tile[28].image = ImageIO.read(UI.class.getResource("/world/tiles/grasswayvertical.png"));

            tile[29] =new Tile();
            tile[29].image = ImageIO.read(UI.class.getResource("/world/tiles/grasswayupfromright.png"));

            tile[30] =new Tile();
            tile[30].image = ImageIO.read(UI.class.getResource("/world/tiles/grasswayupfromleft.png"));

            tile[31] =new Tile();
            tile[31].image = ImageIO.read(UI.class.getResource("/world/tiles/grasswaydownfromright.png"));

            tile[32] =new Tile();
            tile[32].image = ImageIO.read(UI.class.getResource("/world/tiles/grasswaydownfromleft.png"));

            tile[33] =new Tile();
            tile[33].image = ImageIO.read(UI.class.getResource("/world/tiles/housewoodright.png"));
            tile[33].collision = true;

            tile[34] =new Tile();
            tile[34].image = ImageIO.read(UI.class.getResource("/world/tiles/housewoodleft.png"));
            tile[34].collision = true;

            tile[35] =new Tile();
            tile[35].image = ImageIO.read(UI.class.getResource("/world/caveentrence.png"));

            tile[36] =new Tile();
            tile[36].image = ImageIO.read(UI.class.getResource("/world/grasshole.png"));

            tile[37] =new Tile();
            tile[37].image = ImageIO.read(UI.class.getResource("/world/dirt.png"));

            tile[38] =new Tile();
            tile[38].image = ImageIO.read(UI.class.getResource("/world/tiles/water.png"));
            tile[38].collision = true;

            tile[39] =new Tile();
            tile[39].image = ImageIO.read(UI.class.getResource("/world/tiles/beach.png"));
            tile[39].collision = true;

            tile[40] =new Tile();
            tile[40].image = ImageIO.read(UI.class.getResource("/world/tiles/treeentrence.png"));
            tile[40].collision = true;

            tile[41] =new Tile();
            tile[41].image = ImageIO.read(UI.class.getResource("/world/tiles/beachright.png"));
            tile[41].collision = true;

            tile[42] =new Tile();
            tile[42].image = ImageIO.read(UI.class.getResource("/world/tiles/beachrightdown.png"));
            tile[42].collision = true;

            tile[43] =new Tile();
            tile[43].image = ImageIO.read(UI.class.getResource("/world/tiles/beachrightdownfull.png"));
            tile[43].collision = true;

            tile[44] =new Tile();
            tile[44].image = ImageIO.read(UI.class.getResource("/world/tiles/shinygrass.png"));

            tile[45] =new Tile();
            tile[45].image = ImageIO.read(UI.class.getResource("/world/housewoodshop.png"));
            tile[45].collision = true;

            tile[46] =new Tile();
            tile[46].image = ImageIO.read(UI.class.getResource("/world/tiles/hallo.png"));


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