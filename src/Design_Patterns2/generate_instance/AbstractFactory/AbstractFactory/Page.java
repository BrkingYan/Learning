package Design_Patterns2.generate_instance.AbstractFactory.AbstractFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

// Ò³Ãæ
public abstract  class Page implements HTMLable{
    protected String title;
    protected String author;
    protected ArrayList<Item> content = new ArrayList<>();

    public Page(String title,String author){
        this.title = title;
        this.author = author;
    }

    public void add(Item item){
        content.add(item);
    }

    public void show(){
        Writer writer = null;
        try {
            String fileName = title + ".html";
            writer = new FileWriter(fileName);
            writer.write(this.transToHtml());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public abstract String transToHtml();

}
