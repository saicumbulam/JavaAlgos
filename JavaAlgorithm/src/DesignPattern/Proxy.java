package DesignPattern;

/*In proxy pattern, a class represents functionality of another class.
This type of design pattern comes under structural pattern.

In proxy pattern, we create object having original object to interface its functionality to outer world.
*/

public class Proxy {
    interface Image {
        void display();
    }

    static class RealImage implements Image {

        private String fileName;

        public RealImage(String fileName){
            this.fileName = fileName;
            loadFromDisk(fileName);
        }

        @Override
        public void display() {
            System.out.println("Displaying " + fileName);
        }

        private void loadFromDisk(String fileName){
            System.out.println("Loading " + fileName);
        }
    }

    static class ProxyImage implements Image{

        private RealImage realImage;
        private String fileName;

        public ProxyImage(String fileName){
            this.fileName = fileName;
        }

        @Override
        public void display() {
            if(realImage == null){
                realImage = new RealImage(fileName);
            }
            realImage.display();
        }
    }
    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        //image will be loaded from disk
        image.display();
        System.out.println("");

        //image will not be loaded from disk
        image.display();
    }
}
