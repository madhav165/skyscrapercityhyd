import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class RWTextFile {

    String filename;
    int lastpagenum;

    public RWTextFile(String filename) {
        this.filename = filename;
    }

    public int getLastPageNum () throws IOException {
        int lastpagenum = 0;
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader textReader = new BufferedReader(fr);
            lastpagenum = Integer.parseInt(textReader.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return lastpagenum;
    }

    public void setLastPageNum(int lastpagenum) {
        this.lastpagenum = lastpagenum;
        try{
            FileWriter fw = new FileWriter(filename);
            PrintWriter pw = new PrintWriter(fw);
            pw.printf(Integer.toString(lastpagenum));
            pw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
