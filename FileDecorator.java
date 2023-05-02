public class FileDecorator implements FileComponent {
    // properties
    private FileComponent fileComponent;


    // constructor
    public FileDecorator(FileComponent fileComponent)
    {
        this.fileComponent = fileComponent;
    }

    // methods
    public String getInfo()
    {
        return fileComponent.getInfo();
    }
    
}
