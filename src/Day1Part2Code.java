import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class Day1Part2Code {
    public static void main(String[] args) {
        int sumScore = 0;
        ArrayList<String> fileData = getFileData("src/Day1Input");
        ArrayList<Integer> listOne= new ArrayList<Integer>();
        ArrayList<Integer> listTwo= new ArrayList<Integer>();
        System.out.println(fileData);
        for(int i=0;i<fileData.size();i++) {
            String[] split = fileData.get(i).split("   ");
            listOne.add(Integer.parseInt(split[0]));
            listTwo.add(Integer.parseInt(split[1]));
        }
        for(int i=0;i<listOne.size();i++){
            int count=0;
            for(int j=0;j<listTwo.size();j++){
                int x = listTwo.get(j);
                int y = listOne.get(i);
                if(x == y){
                    count++;

                }
            }
            sumScore+=listOne.get(i)*count;
        }
        System.out.println(sumScore);
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
