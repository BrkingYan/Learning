package Design_Patterns2.generate_instance.BuilderPattern;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class HtmlBuilder extends Builder{
    private String fileName;
    private PrintWriter writer;


    HtmlBuilder(String fileName){
        this.fileName = fileName + ".html";
    }

    @Override
    void makeTitle(String title) {
        try {
            writer = new PrintWriter(new FileWriter(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.println("<html><head><title>" + title + "</title></head><body>");
        writer.println("<h1>" + title + "</h1>");
    }

    @Override
    void makeString(String content) {
        writer.println("<p>" + content + "</p>");
    }

    @Override
    void makeItems(String[] items) {
        writer.println("<u1>");
        for (String item : items){
            writer.println("<li>" + item + "</li>");
        }
        writer.println("</u1>");
    }

    @Override
    void builderDone() {
        writer.println("</body></html>");
        writer.close();
    }

    //返回文件名
    public String getResult(){
        return fileName;
    }
}
