package Design_Patterns2.consistency.DecoratorPattern;

/*
*  ±»×°ÊÎÕß
* */
class StringDisplay extends Display {
    private String string;

    StringDisplay(String string){
        this.string = string;
    }

    @Override
    int getColumns() {
        return string.length();
    }

    @Override
    int getRows() {
        return 1;
    }

    @Override
    String getRowText(int rowNum) {
        if (rowNum == 0){
            return string;
        }else {
            return null;
        }
    }
}
