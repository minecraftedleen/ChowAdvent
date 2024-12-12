
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day6Part1Code{
    public static ArrayList<String> fileData = getFileData("src/Day6Input");
    public static int counter;
    public static int rows = fileData.size();
    public static int columns = fileData.get(0).length();
    public static String[][] grid = new String[rows][columns];
    public static void main(String[] args) {



        // build a 2D Array based on the length of each string and the size of the list
        // e.g
        // ABCD
        // EFGH
        // IJKL
        // This would be a 3 row, 4 column 2D array

        int startRow = 0;
        int startCol = 0;


        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                grid[r][c] = fileData.get(r).substring(c, c+1);
                if(grid[r][c].equals("^")){
                    startRow=r;
                    startCol=c;
                }
            }
        }
        System.out.println(startRow);
        System.out.println(startCol);
        moveUp(startRow,startCol);
        for(String[] test : grid){
            for(String testa : test){
                System.out.print(testa);
                if(testa.equals("X")){
                    counter++;
                }
            }
            System.out.println();
        }
        System.out.println(counter + 1);

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

    public static void moveUp(int row, int col){
        if(row-1>=0){
            if(grid[row-1][col].equals("#")){
                moveRight(row,col);
            } else {
                moveUp(row-1,col);
            }
            grid[row][col] = "X";

        }
    }

    public static void moveRight(int row, int col){
        if(col+1<grid[row].length){
            if(grid[row][col+1].equals("#")){
                moveDown(row,col);
            } else {
                moveRight(row,col+1);
            }
            grid[row][col] = "X";

        }
    }

    public static void moveDown(int row, int col){
        if(row+1<grid.length){
            if(grid[row+1][col].equals("#")){
                moveLeft(row,col);
            } else {
                moveDown(row+1,col);
            }
            grid[row][col] = "X";

        }
    }

    public static void moveLeft(int row, int col){
        if(col-1>=0){
            if(grid[row][col-1].equals("#")){
                moveUp(row,col);
            } else {
                moveLeft(row,col-1);
            }
            grid[row][col] = "X";

        }
    }
}
