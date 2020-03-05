import java.io.*;
import java.util.List;

public class Logger {

    final private File file;

    public Logger(String fileName) {
        this.file = new File(fileName);
    }

    public void log(String text, Level level) {
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            StringBuilder newString = new StringBuilder("[" + level + "] ");
            int len = newString.length();
            newString.append(" ".repeat(Math.max(0, 10 - len)));
            newString.append(text).append("\n");
            bw.write(newString.toString());
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void log(String text) {
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("          " + text + "\n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void filterLog(String fileName, List<Level> tags) {
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);

            String line;
            while((line = br.readLine()) != null) {
                if (!line.contains("]")) continue;
                String[] splitRes = line.split("]", 2);
                String level = splitRes[0].substring(1);
                if (tags.contains(Level.valueOf(level))) {
                    bw.write(line + "\n");
                }
            }

            br.close();
            bw.close();
            fr.close();
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteLog() {
        try {
            FileWriter fw = new FileWriter(file);
            fw.write("");
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}