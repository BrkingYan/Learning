package Design_Patterns.NO4_Factory_Mode;

public class HamburgerStore_BJ extends HamburgerStore {

    double disCount;

     HamburgerStore_BJ(){
         this.brand = " (made in BeiJing Hamburger Store)";
     }

    @Override
    public Hamburger createHamburger(String type) {
        Hamburger hamburger = null;
        if(type == "cheese"){
            hamburger = new Hamburger_cheese();
            setBrand(hamburger);
        }
        else if(type == "clam"){
            hamburger = new Hamburger_clam();
            setBrand(hamburger);
        }

        processHamburger(hamburger);
        return hamburger;
    }

    @Override
    public Hamburger createHamburger(String type,double disCount) {
        Hamburger hamburger = null;
        this.disCount = disCount;
        if(type == "cheese"){
            hamburger = new Hamburger_cheese();
            setBrand(hamburger);
        }
        else if(type == "clam"){
            hamburger = new Hamburger_clam();
            setBrand(hamburger);
        }

        processHamburger(hamburger);
        hamburger.disCount = disCount;
        hamburger.changePrice();
        return hamburger;
    }

    @Override
    public void processHamburger(Hamburger hamburger) {
        hamburger.fire();
        hamburger.hot();
        hamburger.ice();
        hamburger.setType();
    }

    public void setBrand(Hamburger hamburger){
        hamburger.state = brand;
    }

//    public void makeBrand(String newBrand){
//        this.brand = newBrand;
//    }
}
