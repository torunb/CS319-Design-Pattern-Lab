/**
 * @author boran
 * @version 09.12.2022
 */

public class Main {
    public static void main(String[] args)
    {
        /*
         * PART 1
         */
        // Example 1
        System.out.println("-------PART 1-------");
        System.out.println("Example 1");
        File video = new File("video", "mp4", 200);
        System.out.println(video.getInfo());

        System.out.println();

        // Example 2
        System.out.println("Example 2");
        Directory myDocuments = new Directory("MyDocuments");
        System.out.println(myDocuments.getInfo());

        System.out.println();

        // Example 3
        System.out.println("Example 3");
        Directory favMusic = new Directory("FavoriteMusic");
        favMusic.addComponent(new File("MetallicaTheUnforgiven", "mp3", 100));
        System.out.println(favMusic.getInfo());

        System.out.println();

        // Example 4
        System.out.println("Example 4");
        Directory bilkentStuff = new Directory("BilkentStuff");
        bilkentStuff.addComponent(new File("InternshipReport", "pdf", 10));
        bilkentStuff.addComponent(new File("setup", "exe", 5));
        bilkentStuff.addComponent(new File("ToDoList", "docx", 15));
        bilkentStuff.addComponent(favMusic);
        System.out.println(bilkentStuff.getInfo());

        System.out.println();

        // Example 5
        System.out.println("Example 5");
        Directory myPc = new Directory("MyPC");
        myPc.addComponent(myDocuments);
        myPc.addComponent(bilkentStuff);
        System.out.println(myPc.getInfo());
        
        System.out.println();

        /*
         * PART 2
         */
        // Example 6
        System.out.println("-------PART 2-------");
        System.out.println("Example 6");
        FileDecorator fileDecorator = new FileIndentationDecorator(myPc);
        System.out.println(fileDecorator.getInfo());
        
        System.out.println();

        // Example 7
        System.out.println("Example 7");
        FileDecorator fileDecorator2 = new FileTypeIndicateDecorator(myPc);
        System.out.println(fileDecorator2.getInfo());

        System.out.println();

        // Example 8
        System.out.println("Example 8");
        FileDecorator fileDecorator3 = new FileIndentationDecorator(new FileTypeIndicateDecorator(myPc));
        FileDecorator fileDecorator4 = new FileTypeIndicateDecorator(new FileIndentationDecorator(myPc));
        System.out.println("-First indent then put the file type-");
        System.out.println(fileDecorator3.getInfo());
        System.out.println("-First type indicate then indent-");
        System.out.println(fileDecorator4.getInfo());

        System.out.println();

        /*
         * PART 3
         */
        // Example 9
        System.out.println("-------PART 3-------");
        System.out.println("Example 9");
        myPc.adjustMemoryRepresentation(); // enter 1 for size based represantation and enter 2 for memory based represantation
        myPc.applyMemoryRepresentation();

        System.out.println();

        // Example 10
        System.out.println("Example 10");
        myPc.adjustMemoryRepresentation(); // enter 1 for size based represantation and enter 2 for memory based represantation
        myPc.applyMemoryRepresentation();
    }
}
