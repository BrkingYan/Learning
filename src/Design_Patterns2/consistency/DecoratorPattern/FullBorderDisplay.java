package Design_Patterns2.consistency.DecoratorPattern;


/*
 * ×°ÊÎÕß
 * */
class FullBorderDisplay extends Border {

    private char borderChar;

    FullBorderDisplay(Display display, char borderChar){
        super(display);
        this.borderChar = borderChar;
    }

    private String makeLine(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<getColumns();i++){
            sb.append(borderChar);
        }
        return sb.toString();
    }

    @Override
    int getColumns() {
        return display.getColumns() + 2;
    }

    @Override
    int getRows() {
        return display.getRows() + 2;
    }

    @Override
    String getRowText(int rowNum) {
        if (rowNum == 0 || rowNum == getRows()-1){
            return makeLine();
        }else {
            return borderChar + display.getRowText(rowNum-1) + borderChar;
        }
    }
}
