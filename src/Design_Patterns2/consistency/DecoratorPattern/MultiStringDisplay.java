package Design_Patterns2.consistency.DecoratorPattern;


import java.util.ArrayList;
import java.util.List;

class MultiStringDisplay extends Display {

    private List<String> stringList;
    private int maxLength = 0;

    MultiStringDisplay(String s){
        stringList = new ArrayList<>();
        maxLength = s.length();
        stringList.add(s);
    }

    void add(String string){
        if (string.length() > maxLength){
            maxLength = string.getBytes().length;
        }
        stringList.add(string);
    }

    @Override
    int getColumns() {
        return maxLength;
    }

    @Override
    int getRows() {
        return stringList.size();
    }

    @Override
    String getRowText(int rowNum) {
        return stringList.get(rowNum);
    }
}
