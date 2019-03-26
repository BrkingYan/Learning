package Design_Patterns2.generate_instance.AbstractFactoryPattern;


import Design_Patterns2.generate_instance.AbstractFactoryPattern.AbstractFactory.*;


/*
*  Main类只用到了AbstractFactory中的几个类，因此，编译Main的同时只会编译AbstractFactory中的几个类
*  textFactory中的类需要单独编译，并以命令行参数传给Main执行
* */
public class Main {
    public static void main(String[] args) {
        if (args.length != 1){
            System.out.println("Usage : java Main class.name.of.textFactory");
            System.out.println("Example1 : java Main textFactory.TextFactory");
            System.out.println("Example2 : java Main tableFactory.TableFactory");
            System.exit(0);
        }
        //TextFactory提前编译好了
        //通过反射的方式获取TextFactory的实例对象
        Factory factory = Factory.getFactory(args[0]);//创建具体类的实例对象

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
