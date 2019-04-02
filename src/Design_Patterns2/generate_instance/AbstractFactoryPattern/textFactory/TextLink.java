package Design_Patterns2.generate_instance.AbstractFactoryPattern.textFactory;

import Design_Patterns2.generate_instance.AbstractFactoryPattern.AbstractFactory.*;

public class TextLink extends Link {

    TextLink(String description, String url) {
        super(description, url);
    }

    @Override
    public String transToHtml() {
        return "  <li><a href=\"" + url + "\">" + description + "</a></li>\n";
    }
}
