package AliTest;

public class Test6 {
    public static void main(String[] args) {
        Test6 t = new Test6();
        //System.out.println(t.getMinVersion(new String[]{"7.3.2","7.3.3"}));
        String[] arr = "1.2.3".split(".");
        for (String s : arr){
            System.out.println(s);
        }
    }

    public String getMinVersion(String[] list) {
        if(list.length == 0){
            return "";
        }
        if(list.length == 1){
            return list[0];
        }
        String min = list[0];
        for(int i = 1;i<list.length;i++){
            if(compare(list[i],min)){
                min = list[i];
            }
        }
        return min;
    }


    //return s1 < s2
    private boolean compare(String s1,String s2){
        String[] ss1 = s1.split(".");
        String[] ss2 = s2.split(".");
        int i = 0;
        int j = 0;
        while(i < ss1.length || j < ss2.length){

            /*if (!(i < ss1.length && j < ss2.length)){
                return ss1.length > ss2.length;
            }*/

            if(Integer.parseInt(ss1[i]) > Integer.parseInt(ss2[j])){
                return false;
            }else if(Integer.parseInt(ss1[i]) < Integer.parseInt(ss2[j])){
                return true;
            }else{
                i++;
                j++;
            }
        }
        return true;
    }
}
