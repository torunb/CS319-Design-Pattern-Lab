public class MemoryBasedStrategy implements FileStrategy{

    @Override
    public String logDirectory(String directoryInfo) {
        String[] list = directoryInfo.split("\n");
        String returned = "";
        int depth = -1;
        returned = "{ ";

        for(int i = 0; i < list.length; i++)
        {
            if(list[i].contains("File Size: "))
            {
                returned = returned + "(F) ";
            }
            else if(list[i].contains("- DIRECTORY END"))
            {
                returned = returned + "EOD";
                returned = returned + Integer.toString(depth) + "] ";
                depth--;
            }
            else
            {
                depth++;
                returned = returned + "[D" + Integer.toString(depth) + " ";
            }
        }
        returned = returned + "}";
        return returned;
    }
}