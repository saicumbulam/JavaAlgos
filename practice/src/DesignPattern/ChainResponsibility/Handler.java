package DesignPattern.ChainResponsibility;

public interface Handler {
    public void setHandler(Handler handler);
    public void process(FileObj file);
    public String getHandlerName();
}
