package br.com.sample.solutionbto.model;

/**
 * Represent file used in GridFS
 */
public class FileGridFS extends GenericEntity{

    private String fileName;
    private Long size;
    private String contentType;

    public FileGridFS(){
        super();
    }

    public FileGridFS(String fileName, String contentType, Long size){
        this.fileName = fileName;
        this.contentType = contentType;
        this.size = size;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
