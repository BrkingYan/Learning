package tempTestBed;

public class Cupboard {
    static int i = 0;

    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);
    Cupboard(){
        System.out.println("Cupboard()");
        bowl4.f1(2);
    }
    static Bowl bowl5 = new Bowl(5);

     void show(){
        System.out.println("show run");
    }
}
//  静态成员只会初始化一次(两种情况)：1、在首次new出该类对象，2、或者首次通过类名访问它的静态成员的时候