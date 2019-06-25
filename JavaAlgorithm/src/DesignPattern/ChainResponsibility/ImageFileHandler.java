package DesignPattern.ChainResponsibility;

public class ImageFileHandler implements Handler {
    private Handler handler;
    private String handlerName;
    public ImageFileHandler(String handlerName){
        this.handlerName = handlerName;
    }
    @Override
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void process(FileObj file) {
        if (file.getFileType().equals("img")) {
            System.out.println("Process and saving Image file... by " + handlerName);
        } else if (handler != null) {
            System.out.println(handlerName + " fowards request to " + handler.getHandlerName());
            handler.process(file);
        } else {
            System.out.println("FileObj not supported");
        }
    }

    @Override
    public String getHandlerName() {
        return handlerName;
    }
}
