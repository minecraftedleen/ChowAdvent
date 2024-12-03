import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;

public class Regex {
    public static void main(String[] args) {
        ArrayList<String> allMatches = new ArrayList<String>();
        String searchString = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";
        String regex = "mul\\([1-9]*[1-9]*[1-9],[1-9]*[1-9]*[1-9]\\)";

        Matcher m = Pattern.compile(regex).matcher(searchString);
        while (m.find()) {
            allMatches.add(m.group());
        }
        System.out.println(allMatches);
    }
}