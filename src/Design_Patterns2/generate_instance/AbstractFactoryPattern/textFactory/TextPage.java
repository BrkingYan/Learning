package Design_Patterns2.generate_instance.AbstractFactoryPattern.textFactory;

import Design_Patterns2.generate_instance.AbstractFactoryPattern.AbstractFactory.*;

import java.util.Iterator;

public class TextPage extends Page {


    TextPage(String title, String author) {
        super(title, author);
    }

    @Override
    public String transToHtml() {
        StringBuilder builder = new StringBuilder();
        builder.append("<html><head><title>" + title + "</title></head>\n");
        builder.append("<body>\n");
        builder.append("<h1>" + title + "</h1>\n");
        builder.append("<u1>\n");
        Iterator<Item> it = content.iterator();
        for (Item item : content){
            builder.append(item.transToHtml());
        }
        builder.append("</u1>\n");
        builder.append("<hr><address>" + author + "</address>");
        builder.append("</body></html>\n");
        return builder.toString();
    }
}
