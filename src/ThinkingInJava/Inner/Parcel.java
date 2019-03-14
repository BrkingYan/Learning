package ThinkingInJava.Inner;

public class Parcel {
    public Destination destination(String dest){
        return new Destination() {
            private String label = dest;
            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args){
        Parcel p = new Parcel();
        Destination d = p.destination("Wu Han");
        System.out.println(d.getClass().getName());
        String s = d.readLabel();
        System.out.println(s);
    }
}
