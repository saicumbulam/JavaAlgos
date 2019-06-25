package DesignPattern.ChainResponsibility;

public class TestChainResp {
    public static void main(String[] args) {
        FileObj file = null;
        Handler textHandler = new TextFileHandler("Text Handler");
        Handler docHandler = new DocFileHandler("Doc Handler");
        Handler audioHandler = new AudioFileHandler("Audio Handler");
        Handler imageHandler = new ImageFileHandler("Image Handler");
        textHandler.setHandler(docHandler);
        docHandler.setHandler(audioHandler);
        audioHandler.setHandler(imageHandler);
        file = new FileObj("Abc.mp3", "audio", "C:");
        textHandler.process(file);
        file = new FileObj("Abc.jpg", "video", "C:");
        textHandler.process(file);
        file = new FileObj("Abc.doc", "doc", "C:");
        textHandler.process(file);
        file = new FileObj("Abc.bat", "bat", "C:");
        textHandler.process(file);
    }
}
