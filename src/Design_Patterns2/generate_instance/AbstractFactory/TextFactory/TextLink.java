package Design_Patterns2.generate_instance.AbstractFactory.TextFactory;

import Design_Patterns2.generate_instance.AbstractFactory.AbstractFactory.*;

public class TextLink extends Link {

    public TextLink(String description, String url) {
        super(description, url);
    }

    @Override
    public String transToHtml() {
        return "  <li><a href=\"" + url + "\">" + description + "</a></li>\n";
    }
}
