import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public int add(String input) {
        if(input.isEmpty()){
            return 0;
        }
     
    String delimiter = ",|\n";
    String numbersPart = input;

if (input.startsWith("//")) {
    int index = input.indexOf("\n");
    String delimiterPart = input.substring(2, index);
    numbersPart = input.substring(index + 1);

    List<String> delimiters = new ArrayList<>();
    Matcher matcher = Pattern.compile("\\[(.*?)]").matcher(delimiterPart);
    while (matcher.find()) {
        delimiters.add(Pattern.quote(matcher.group(1)));
    }
    if (delimiters.isEmpty()) {
        delimiters.add(Pattern.quote(delimiterPart));
    }
    delimiter = String.join("|", delimiters);
}

    String[] numbers = numbersPart.split(delimiter);


        int result = 0;
        List<String> negatives = new ArrayList<>();
        for (String number : numbers) {
            int n = Integer.parseInt(number);
            if (n < 0) {
                negatives.add(number);
            } else if (n <= 1000) {
                result += n;
            }
        }
        if (negatives.isEmpty()) {
        return result;
    }
    String message = "Negatives: ";
    message += String.join(" ", negatives);
    throw new NegativeNumberException(message);

}
}


