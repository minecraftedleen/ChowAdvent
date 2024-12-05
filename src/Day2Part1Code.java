import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2Part1Code {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day2Input");
        System.out.println(fileData);
        for(int i=0;i<fileData.size();i++){
            String[] split=fileData.get(i).split(" ");
            ArrayList<Integer> level=new ArrayList<Integer>();
            for(int j=0;j<split.length;j++){
                level.add(Integer.parseInt(split[i]));
            }

        }

    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}