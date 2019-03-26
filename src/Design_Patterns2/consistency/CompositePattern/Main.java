package Design_Patterns2.consistency.CompositePattern;

import Design_Patterns2.consistency.CompositePattern.compositeItems.*;
public class Main {
    public static void main(String[] args) {
        /*
        *   ---root 550
        *        |___bin 150
        *        |     |___vi 100
        *        |     |___latex 50
        *        |
        *        |___tmp 0
        *        |___usr 400
        *             |
        *             |___yuki 150
        *             |      |___diary.html 50
        *             |      |___composite.java 100
        *             |___hanako 50
        *             |      |___memo.tex 50
        *             |___tomura 200
        *                    |___game.doc 100
        *                    |___iunk.mail 100
        * */

        Directory rootDir = new Directory("root");
        Directory binDir = new Directory("bin");
        Directory tmpDir = new Directory("tmp");
        Directory usrDir = new Directory("usr");

        rootDir.add(binDir);
        rootDir.add(tmpDir);
        rootDir.add(usrDir);

        binDir.add(new File("vi",100));
        binDir.add(new File("latex",50));

        Directory yukiDir = new Directory("yuki");
        yukiDir.add(new File("diary.html",50));
        yukiDir.add(new File("composite.java",100));

        Directory hanakoDir = new Directory("hanako");
        hanakoDir.add(new File("memo.tex",50));

        Directory tomuraDir = new Directory("tomura");
        tomuraDir.add(new File("game.doc",100));
        tomuraDir.add(new File("iunk.mail",100));

        usrDir.add(yukiDir);
        usrDir.add(hanakoDir);
        usrDir.add(tomuraDir);

        //rootDir.printList();
        rootDir.printList();

        /*File file = new File("123",11);
        usrDir.add(file);
        file.printList();*/


    }
}
