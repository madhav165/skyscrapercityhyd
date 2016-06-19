import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.lang.NullPointerException;

public class SkyscrapercityRead {

    public static void main(String []args) {
        int lastpagenum;
        int currentlastpage;
        try {
            RWTextFile rwtf = new RWTextFile("/home/madhav/skyscrapercity/finalpage.txt");
            lastpagenum = rwtf.getLastPageNum() + 1;            
            Document doc = Jsoup.connect("http://www.skyscrapercity.com/showthread.php?t=459134&page="+lastpagenum).get();
            String title = doc.title();
            currentlastpage = Integer.parseInt(title.split("\\s")[7]);
            rwtf.setLastPageNum(currentlastpage);
            Elements authors = doc.getElementsByClass("bigusername");
            Elements posts = doc.getElementsByAttributeValueStarting("id", "post_message");
            System.out.println("\n===== "+title+" ======\n");
            for (int i = 0; i < authors.size(); i++) {
                System.out.println("==="+authors.eq(i).text()+"===\n");
                System.out.println(posts.eq(i).text()+"\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
} 
