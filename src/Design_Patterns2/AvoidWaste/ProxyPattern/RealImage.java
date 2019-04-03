package Design_Patterns2.AvoidWaste.ProxyPattern;

class RealImage implements Image {

    private String fileName;

    RealImage(String fileName){
        this.fileName = fileName;
        loadImageFromDisk();//ֻ�е��û������ͼƬʱ����ȥ����ͼƬ��ʵ������������ǰ����
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
