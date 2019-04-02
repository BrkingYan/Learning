package Design_Patterns2.generate_instance.AbstractFactoryPattern.textFactory;

import Design_Patterns2.generate_instance.AbstractFactoryPattern.AbstractFactory.*;

public class TextModule extends Module{

    TextModule(String description){
        super(description);
    }

    @Override
    public String transToHtml() {
        StringBuilder builder = new StringBuilder();
        builder.append("<li>\n");
        builder.append(description).append("\n");
        builder.append("<u1>\n");
        for (Item item : itemList) {
            builder.append(item.transToHtml());
        }
        builder.append("</u1>\n");
        builder.append("</li>\n");
        return builder.toString();
    }
}
