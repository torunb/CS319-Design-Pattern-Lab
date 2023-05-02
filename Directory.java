import java.util.*;

public class Directory implements FileComponent
{
    // properties
    private String directoryName;
    private ArrayList<FileComponent> list;
    private FileStrategy fileStrategy;
    private int selection;
    Scanner scan = new Scanner(System.in);

    // constructor
    public Directory(String directoryName)
    {
        this.directoryName = directoryName;
        list = new ArrayList<FileComponent>();
    }

    // methods
    public void addComponent(FileComponent component)
    {
        list.add(component);
    }

    public void removeComponent(FileComponent component)
    {
        if(!list.contains(component))
        {
            System.out.println("This file does not exist in this directory");
        }
        list.remove(component);
    }

    public String getInfo()
    {
        if(list.isEmpty())
        {
            return  "- " + directoryName + "\n" + "- DIRECTORY END | " + directoryName + "\n";
        }
        String returned = "";
        returned = "- " + directoryName + "\n" ;
        for(int i = 0; i < list.size(); i++)
        {
            returned =  returned + list.get(i).getInfo();
        }
        returned = returned +  "- DIRECTORY END | " + directoryName + "\n";
        return returned;
    }
    
    public void adjustMemoryRepresentation()
    {
        System.out.println("Please select one of the memory representation you want");
        System.out.println("Enter 1 for Size Based memory representation, enter 2 for Memory Based memory representation: ");
        selection = scan.nextInt();
    }

    public void applyMemoryRepresentation()
    {
        if(selection == 1)
        {
            fileStrategy = new SizeBasedStrategy();
            System.out.println(fileStrategy.logDirectory(this.getInfo()));
        }
        else if(selection == 2)
        {
            fileStrategy = new MemoryBasedStrategy();
            System.out.println(fileStrategy.logDirectory(this.getInfo()));
        }
        else
        {
            System.out.println( "Please enter 1 or 2!");
        }
    }
}
