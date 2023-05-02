public class File implements FileComponent
{
    // Properties
    private String fileName;
    private String extension;
    private int fileSize;

    // Constructor
    public File(String fileName, String extension, int fileSize)
    {
        this.fileName = fileName;
        this.extension = extension;
        this.fileSize = fileSize;
    }

    // methods
    public String getInfo()
    {
        return fileName + "." + extension + " | File Size: " + fileSize + " kb" + "\n"; 
    }
}