package Design_Patterns2.consistency.DecoratorPattern;

/*
* ×°ÊÎÕß
* */
class SideBorderDisplay extends Border {
    private char borderChar;

    SideBorderDisplay(Display display, char borderChar){
        super(display);
        this.borderChar = borderChar;
    }

    @Override
    int getColumns() {
        return display.getColumns() + 2;
    }

    @Override
    int getRows() {
        return display.getRows();
    }

    @Override
    String getRowText(int rowNum) {
        StringBuilder sb = new StringBuilder();
        sb.append(borderChar);
        sb.append(display.getRowText(rowNum));
        while (sb.length() < getColumns()-1){
            sb.append(" ");
        }
        sb.append(borderChar);
        return sb.toString();
    }
}
