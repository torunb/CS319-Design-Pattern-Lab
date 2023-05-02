public class SizeBasedStrategy implements FileStrategy
{
    @Override
    public String logDirectory(String directoryInfo) {
        String[] list = directoryInfo.split("\n");
        String returned  = "";
        returned = "{ ";
        for(int i = 0; i < list.length; i++)
        {
            if(list[i].contains("- DIRECTORY"))
            {
                returned = returned + "] ";
            }
            else if(list[i].contains("File Size: "))
            {
                returned = returned + "(";
                for(int j = 0; j < list[i].length(); j++)
                {
                    if(list[i].indexOf("Size:") == j)
                    {
                        int k = j + 2;
                        while(list[i].indexOf("kb") != k)
                            k++;
                        j = j + 6;
                        k--;
                        int fileSize = Integer.parseInt(list[i].substring(j , k));
                        returned = returned + fileSize;
                    }
                }
                returned = returned + ") ";
            }
            else
            {
                returned = returned + "[ ";
            }
        }
        returned = returned + "}";
        return returned;
    }
}
