import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3Part1Code {
    public static void main(String[] args) {
        ArrayList<String> allMatches = new ArrayList<String>();
        String searchString = getFileData("src/Day3Input");
        String regex = "mul\\([0-9]*,[0-9]*\\)";
        int sum = 0;

        Matcher m = Pattern.compile(regex).matcher(searchString);
        while (m.find()) {
            allMatches.add(m.group());
        }
        System.out.println(allMatches);
        for(int i = 0;i< allMatches.size();i++) {
            String withoutMul = allMatches.get(i).substring(4, allMatches.get(i).length() - 1);
            String[] split = withoutMul.split(",");
            sum += Integer.parseInt(split[0]) * Integer.parseInt(split[1]);
        }
        System.out.println(sum);
    }

    public static String getFileData(String fileName) {
        String fileData = "";
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData+=line;
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}

