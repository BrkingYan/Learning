package Design_Patterns2.AvoidWaste.ProxyPattern;

class RealImage implements Image {

    private String fileName;

    RealImage(String fileName){
        this.fileName = fileName;
        loadImageFromDisk();//只有当用户浏览到图片时，才去生成图片的实例，而不是提前生成
    }

    @Override
    public void display() {
        System.out.println("displaying image " + fileName);
    }

    private void loadImageFromDisk(){
        System.out.print("loading");
        for (int i = 0;i<3;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println(e);
            }finally {
                System.out.print(" . ");
            }
        }
        System.out.println();
        System.out.println("image load successfully!");
    }
}
