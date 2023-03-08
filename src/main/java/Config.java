import java.io.*;


public class Config {

    private String filename = null;

    public Config() {

    }

    public void save(int filen, String variable, Object wert) {

        filename = selectFile(filen);
        if (filename == null || variable == null || wert == null) {
            System.err.println("filename,variable, wert kann nicht null sein ");
            return;
        }

        File file = new File(filename);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            if (!file.isFile() || !file.canWrite()) {
                System.err.println("File kann nicht bearbeitet werden");
                return;
            }

            boolean keyFound = false;
            String tempFilename = filename + ".tmp";
            File tempFile = new File(tempFilename);

            try (BufferedReader reader = new BufferedReader(new FileReader(file));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(" = ");
                    if (parts.length == 2 && parts[0].equals(variable)) {
                        writer.write(variable + "=" + wert.toString());
                        writer.newLine();
                        keyFound = true;
                    } else {
                        writer.write(line);
                        writer.newLine();
                    }
                }

                if (!keyFound) {
                    writer.write(variable + " = " + wert.toString());
                    writer.newLine();
                }
            }

            file.delete();
            tempFile.renameTo(file);

        } catch (IOException e) {
            System.err.println("failed to save config: " + e.getMessage());
        }
    }

    public Integer load(int filen, String variable) {
        filename = selectFile(filen);
        if (filename == null || variable == null) {
            System.err.println("filename,variable, wert kann nicht null sein ");
            return 0;
        }

        File file = new File(filename);

        try {
            if (!file.exists() || !file.isFile() || !file.canRead()) {
                System.err.println("File kann nicht bearbeitet werden");
                return null;
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(" = ");
                    if (parts.length == 2 && parts[0].equals(variable)) {
                        return Integer.valueOf(parts[1]);
                    }
                }
            } catch (IOException e) {
                System.err.println("failed to read file: " + e.getMessage());
            }
        } catch (SecurityException e) {
            System.err.println("permission denied: " + e.getMessage());
        }

        System.err.println("Variablen " + "\033[0;34m" + variable + "\033[0m" + " nicht gelesen werden und wurde auf 0 gestellt");
        return 0;
    }

    public String selectFile(int file) {
        switch (file) {
            case 0:
                return "src/main/resources/save/default.config";
            case 1:
                return "src/main/resources/save/saveGame1.config";
            case 2:
                return "src/main/resources/save/saveGame2.config";
            case 3:
                return "src/main/resources/save/saveGame3.config";
            case 4:
                return "src/main/resources/save/saveGame4.config";
        }
        return null;
    }

    public void copyFile(int i, int x){
        try {
            String file1 = selectFile(i);
            String file2 = selectFile(x);

            if (file1 == null || file2 == null) {
                System.err.println("copy File are not found");
                return;
            }
            File sourceFile = new File(file1);
            File destinationFile = new File(file2);
            BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile));

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            reader.close();
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException("Fehler beim Kopieren der Textdatei", e);
        }
    }
}