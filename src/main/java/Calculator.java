import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public int add(String input) {
        if(input.isEmpty()){
            return 0;
        }
     
        String[] numbers = input.split(",|\n");

        int result = 0;
        List<String> negatives = new ArrayList<>();
        for (String number:numbers) {
        if (Integer.parseInt(number) < 0) {
            negatives.add(number);
            }
       
            result += Integer.parseInt(number);
        }
        if (negatives.isEmpty()) {
        return result;
    }
    String message = "Negatives: ";
    message += String.join(" ", negatives);
    throw new NegativeNumberException(message);

}
}




// zakonczono na 39:00 filmiku https://www.youtube.com/watch?v=CODh4Q-xcv4