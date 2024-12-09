import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4Part1Code {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Day4Input");

        // build a 2D Array based on the length of each string and the size of the list
        // e.g
        // ABCD
        // EFGH
        // IJKL
        // This would be a 3 row, 4 column 2D array
        int rows = fileData.size();
        int columns = fileData.get(0).length();
        int counter = 0;
        String[][] grid = new String[rows][columns];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                grid[r][c] = fileData.get(r).substring(c, c+1);
                System.out.print(grid[r][c]);
            }
            System.out.println();
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length - 3;j++){
                String checkString = "";
                for(int k=j;k<j+4;k++){
                    checkString+=grid[i][k];
                }
                if(checkString.equals("XMAS") || checkString.equals("SAMX")){
                    counter++;
                }
            }
        }
        for(int i=0;i<grid[0].length;i++){
            for(int j=0;j<grid.length - 3;j++){
                String checkString = "";
                for(int k=j;k<j+4;k++){
                    checkString+=grid[k][i];
                }
                if(checkString.equals("XMAS") || checkString.equals("SAMX")){
                    counter++;
                }
            }
        }
        for(int i=0;i<grid.length - 3;i++){
            for(int j=0;j<grid[0].length - 3;j++){
                String checkString = "";
                int inc=0;
                for(int k=j;k<j+4;k++){
                    checkString+=grid[i+inc][k];
                    inc++;
                }
                if(checkString.equals("XMAS") || checkString.equals("SAMX")){
                    counter++;
                }
            }
        }
        System.out.println(counter);

        // "grid" represents a 2D array of Strings built from the input file
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
