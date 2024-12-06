import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2Part2Code {
    public static void main(String[] args) {
        int count=0;
        ArrayList<String> fileData = getFileData("src/Day2Input");
        System.out.println(fileData);
        for(int i=0;i<fileData.size();i++){
            String[] split=fileData.get(i).split(" ");
            ArrayList<Integer> level=new ArrayList<Integer>();
            boolean increasing;
            boolean safe=true;
            boolean dampened=false;
            for(int j=0;j<split.length;j++){
                level.add(Integer.parseInt(split[j]));
            }
            if(level.get(0)<level.get(1)){
                increasing=true;
            } else {
                increasing=false;
            }
            int levelSize=level.size();
            for(int j=1;j<levelSize-1;j++){
                if(!increasing && level.get(j)<level.get(j+1) || increasing && level.get(j)>level.get(j+1)){
                    if(!dampened){
                        level.remove(j);
                        if(j>0){j-=1;}
                        levelSize-=1;
                        dampened=true;
                        if(!increasing && level.get(j)<level.get(j+1) || increasing && level.get(j)>level.get(j+1)) {
                            safe=false;
                        }

                        }else{
                        safe=false;
                    }

                }
            }
            for(int j=0;j<levelSize-1;j++){
                if(Math.abs(level.get(j)-level.get(j+1)) < 1 || Math.abs(level.get(j)-level.get(j+1)) > 3){
                    if(!dampened){
                        level.remove(j);
                        if(j>0){j-=1;}
                        levelSize-=1;
                        dampened=true;
                        if(Math.abs(level.get(j)-level.get(j+1)) < 1 || Math.abs(level.get(j)-level.get(j+1)) > 3){
                            safe=false;
                        }

                    }else{
                        safe=false;
                    }

                }
            }
            for(int j=0;j<levelSize;j++){
                System.out.print(level.get(j) + " ");
            }
            System.out.println();
            if(safe){
                count++;
            }
        }
        System.out.println(count);

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
