package Design_Patterns2.AvoidWaste.ProxyPattern;

class ProxyImage implements Image {

    private Image realImage;
    private String fileName;

    ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        //System.out.println("image is dis");
        if (realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
