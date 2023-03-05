import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class Config {
    public Config() {
        saveConfig("go","e");
        saveConfig("g7","2");
        System.out.println(loadConfig("go"));

    }
    public void saveConfig(String variableName, String wert) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/save.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/save.txt"));

            String zeile = null;
            while ((zeile = reader.readLine()) != null) {
                writer.newLine();
            }
            writer.write(variableName + " = " + wert + "\n");
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            System.out.println("Save Config Exception!");
        }
    }

    public String loadConfig(String variableName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/save.txt"));
            String zeile = null;
            while ((zeile = reader.readLine()) != null) {
                String[] teile = zeile.split(" = ");
                if (teile.length == 2 && teile[0].equals(variableName)) {
                    reader.close();
                    return teile[1];
                }
            }
            reader.close();
            return null;
        } catch (Exception e) {
            System.out.println("Load Config Exception!");
        }
    return null;
    }
}
