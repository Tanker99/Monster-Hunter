import java.awt.*;

public class Text {

    GamePanel gp;


    public Text(GamePanel gp) {
        this.gp = gp;
    }

    public void drawTextBetweenBox(Graphics2D g2,String text, int x, int y, int width) {
        // prüft ob Text zu breit
        Font font = new Font("Arial", Font.PLAIN, 25);
        g2.setFont(font);
        FontMetrics metrics = g2.getFontMetrics();
        int textWidth = metrics.stringWidth(text);
        if (textWidth > width) {
            // Umrechnung von text
            String[] lines = text.split("\\s+");
            StringBuilder sb = new StringBuilder();
            for (String word : lines) {
                if (metrics.stringWidth(sb.toString() + " " + word) > width) {
                    g2.drawString(sb.toString(), x, y);
                    y += metrics.getHeight();
                    sb.setLength(0);
                }
                sb.append(word).append(" ");
            }
            g2.drawString(sb.toString(), x, y);
        } else {
            // zeichnet wenn doch passst
            g2.drawString(text, x, y);
        }
    }
    public void drawTextInBox(Graphics2D g2,String text, int x, int y, int width, int height) {
        FontMetrics fm = g2.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getHeight();
        int xOffset = (width - textWidth) / 2;
        int yOffset = (height - textHeight) / 2 + fm.getAscent();
        g2.drawString(text, x + xOffset, y + yOffset);
    }
    public void draw3StringsInBox(Graphics2D g2,String text1, String text2, String text3, int x, int y, int width, int height) {
        Font font = new Font("Arial", Font.PLAIN, 12);
        g2.setFont(font);

        FontMetrics metrics = g2.getFontMetrics();
        int string1Width = metrics.stringWidth(text1);
        int string2Width = metrics.stringWidth(text2);
        int string3Width = metrics.stringWidth(text3);

        int string1X = x + (width - string1Width) / 2;
        int string2X = x + (width - string2Width) / 2;
        int string3X = x + (width - string3Width) / 2;

        int stringY = y + (height - metrics.getHeight() * 3) / 2;

        g2.drawString(text1, string1X, stringY);
        g2.drawString(text2, string2X, stringY + metrics.getHeight());
        g2.drawString(text3, string3X, stringY + metrics.getHeight() * 2);
    }
}
