public class FileIndentationDecorator extends FileDecorator{
    // properties
    private FileComponent fileComponent;


    // constructor
    public FileIndentationDecorator(FileComponent fileComponent) 
    {
        super(fileComponent);
        this.fileComponent = fileComponent;
    }

    // methods
    @Override
    public String getInfo()
    {
        int noOfIndentation = 0;
        String[] stringList;
        stringList = fileComponent.getInfo().split("\n");
        String returned = "";
        int i = 0;
        while (i < stringList.length) 
        {
            if(stringList[i].contains("- DIRECTORY END") || stringList[i].contains("(!)"))
            {
                noOfIndentation--;
                int j = 0;
                while (j < noOfIndentation) 
                {
                    returned = returned + "\t";
                    j++;
                }
                returned = returned + stringList[i];
                returned = returned + "\n";
            }
            else if(stringList[i].contains("-")|| stringList[i].contains("(d)"))
            {
                int j = 0;
                while (j < noOfIndentation) 
                {
                    returned = returned + "\t";
                    j++;
                }
                returned = returned + stringList[i];
                returned = returned + "\n";
                noOfIndentation++;
            }
            else
            {
                int j = 0;
                while (j < noOfIndentation) 
                {
                    returned = returned + "\t";
                    j++;
                }
                returned = returned + stringList[i];
                returned = returned + "\n";
            }
            i++;
        }
        return returned;   
    }

    
}
