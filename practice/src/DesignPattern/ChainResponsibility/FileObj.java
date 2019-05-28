package DesignPattern.ChainResponsibility;

public class FileObj {
    private final String fileName;
    private final String fileType;
    private final String filePath;

    public FileObj(String fileName, String fileType, String filePath){
        this.fileName = fileName;
        this.fileType = fileType;
        this.filePath = filePath;
    }
    public String getFileName() {
        return fileName;
    }
    public String getFileType() {
        return fileType;
    }
    public String getFilePath() {
        return filePath;
    }
}
