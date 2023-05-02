public class FileTypeIndicateDecorator extends FileDecorator{
    // properties
    private FileComponent fileComponent;

    // constructor
    public FileTypeIndicateDecorator(FileComponent fileComponent) 
    {
        super(fileComponent);
        this.fileComponent = fileComponent;
    }
    
    // methods
    @Override
    public String getInfo()
    {
        String[] stringList = fileComponent.getInfo().split("\n");
        String returned = "";
        for(int i = 0; i < stringList.length; i++)
        {
            if(stringList[i].contains("- DIRECTORY"))
            {
                stringList[i] = "(!) " + stringList[i];
                returned = returned + stringList[i];
                returned = returned + "\n";
            }
            else if(stringList[i].contains("File Size: "))
            {
                stringList[i] = "(f) " + stringList[i];
                returned = returned + stringList[i];
                returned = returned + "\n";
            }
            else
            {
                stringList[i] = "(d) " + stringList[i];
                returned = returned + stringList[i];
                returned = returned + "\n";
            }
        }
        return returned;
    }
}
