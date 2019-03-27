package ThinkingInJava.InnerClass;

public class MutiNestClass {

    static class StaticOuter{
        private String StaticOuterName = "outers";
        private int id = 1;
        //这个方法在外围类中，却能被里面的所有嵌套的内部类所共有，相当于被继承了
        int getId(){
            return id;
        }
        class MidS{
            private String MidSName = "mids";
            String getOuterName(){
                return StaticOuterName;
            }
            String getInnerName(){
                //no way
                return null;
            }
            class InnerS{
                private String InnerName = "inners";
                String getOuterName(){
                    return StaticOuterName;
                }
                String getMidName(){
                    return MidSName;
                }
            }
        }
    }

    class Outer{
        private String OuterName = "outer";
        private int id = 1;
        //这个方法在外围类中，却能被里面的所有类访问，但是只是访问而已，并不是内部类的财产
        int getId(){
            return id;
        }
        class Mid{
            private String MidName = "mid";
            String getOuterName(){
                return OuterName;
            }
            String getInnerName(){
                //no way
                return null;
            }
            int getOuterIdInMid(){
                return getId();
            }
            class Inner{
                private String InnerName = "inner";
                String getOuterName(){
                    return OuterName;
                }
                String getMidName(){
                    return MidName;
                }
                int getOuterId(){
                    return getOuterIdInMid();
                }
            }
        }
    }

    static class TestClass{
        public static void main(String[] args) {
            MutiNestClass test = new MutiNestClass();
            Outer outer = test.new Outer();//普通内部类的创建依赖外部类的对象
            Outer.Mid mid = outer.new Mid();
            Outer.Mid.Inner inner = mid.new Inner();

            System.out.println("get Mid from Inner : " + inner.getMidName());
            System.out.println("get Outer from Inner : " + inner.getOuterName());
            System.out.println("get Outer from Mid : " + mid.getOuterName());


            System.out.println("---------------------------------------------------------------------");

            StaticOuter staticOuter = new StaticOuter();//嵌套类的创建不依赖外部类的对象
            StaticOuter.MidS midS = staticOuter.new MidS();//嵌套类里面的普通内部类的创建也是依赖该嵌套类的对象
            StaticOuter.MidS.InnerS innerS = midS.new InnerS();//普通内部类里面的普通内部类的创建也是依赖外围类的对象

            System.out.println("get Mids from Inners : " + innerS.getMidName());
            System.out.println("get StaticOuter from Inners : " + innerS.getOuterName());
            System.out.println("get StaticOuter from Mid : " + midS.getOuterName());
        }
    }
}
