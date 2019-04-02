package Design_Patterns2.consistency.DecoratorPattern;

abstract class Border extends Display{
    Display display;
    Border(Display display){
        this.display = display;
    }
}
