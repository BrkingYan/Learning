package ThinkingInJava.Enum.UserInterfaceToOrganizeEnum;

interface Food {
    enum Dessert implements Food{
        ICE_CREAM,SUGAR
    }

    enum Beverage implements Food{
        COLA,COFFEE
    }

    enum MainFood implements Food{
        RICE,WHEAT
    }
}
