package Design_Patterns2.generate_instance.AbstractFactory;

import Design_Patterns2.generate_instance.AbstractFactory.AbstractFactory.*;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1){
            System.out.println("Usage : java Main class.name.of.TextFactory");
            System.out.println("Example1 : java Main listFactory.ListFactory");
            System.out.println("Example2 : java Main tableFactory.TableFactory");
            System.exit(0);
        }
        Factory factory = Factory.getFactory(args[0]);
        Link peoplePaperLink = factory.createLink("人民日报","http://www.people.com.cn/");
        Link gmPaperLink = factory.createLink("光明日报","http://www.gmw.cn");

        Link us_yahoo = factory.createLink("Yahoo!","http;//www.yahoo.com/");
        Link jp_yahoo = factory.createLink("Yahoo!Japan","http;//www.yahoo.co.jp/");
        Link excite = factory.createLink("Excite","http;//www.excite.com/");
        Link google = factory.createLink("Google","http;//www.google.com/");

        Module newsModule = factory.createModule("日报");
        newsModule.add(peoplePaperLink);
        newsModule.add(gmPaperLink);

        Module yahooModule = factory.createModule("Yahoo!");
        yahooModule.add(us_yahoo);
        yahooModule.add(jp_yahoo);

        Module searchModule = factory.createModule("搜索引擎");
        searchModule.add(yahooModule);
        searchModule.add(excite);
        searchModule.add(google);

        Page webPage = factory.createPage("LinkPage","yy");
        webPage.add(newsModule);
        webPage.add(searchModule);
        webPage.show();

    }
}
