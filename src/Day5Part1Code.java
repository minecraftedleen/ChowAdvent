
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5Part1Code {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day5Input");
        ArrayList<Integer> directions = new ArrayList<Integer>();
        ArrayList<int[]> pageLines = new ArrayList<int[]>();
        ArrayList<Integer> correct = new ArrayList<Integer>();
        for(int i=0;i<fileData.size();i++) {
            if (fileData.get(i).length() == 5) {
                String[] splitDir = fileData.get(i).split("\\|");
                directions.add(Integer.parseInt(splitDir[0]));
                directions.add(Integer.parseInt(splitDir[1]));
            } else {
                String[] splitPage = fileData.get(i).split(",");
                int[] pages = new int[splitPage.length];
                for (int j = 0; j < splitPage.length; j++) {
                    pages[j] = Integer.parseInt(splitPage[j]);
                }
                pageLines.add(pages);
            }
        }
        for(int i=0;i<pageLines.size();i++){
            for(int j=0;j<pageLines.get(i).length;j++){
                System.out.print(pageLines.get(i)[j] + " ");
            }

        }

        // you now have an ArrayList of Strings for each number in the file
        // do Advent 2020 day 1!
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