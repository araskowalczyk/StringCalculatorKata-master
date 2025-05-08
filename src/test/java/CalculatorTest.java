import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;


public class CalculatorTest {

    private Calculator calculator;
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void shouldReturnZeroWhenEmptyStringGiven() {
        int result = calculator.add("");
        assertThat(result).isEqualTo(0);    
    }
    @Test
    void shouldReturnNumberWhenGivenNumber() {
        int result = calculator.add("1");
        assertThat(result).isEqualTo(1);
        }

    @Test 
    void shouldAddTwoNumbersSeparatedWithComma() {
        int result = calculator.add("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void shouldAddThreeNumbersSeaparatedWithComma() {
       int result = calculator.add("1,2,3");
       assertThat(result).isEqualTo(6);
    }

    @Test 
    void shouldAddThreeNumbersSeparatedWithCommaAndNewLine() {
        int result = calculator.add("1,2\n4");
        assertThat(result).isEqualTo(7);
    }

    @Test
    void shouldThrowExceptionWhenNegativeNumberProvided() {
        Assertions.assertThrows(NegativeNumberException.class, () ->{
            calculator.add("-1");
        });
    }
    @Test
    void shouldIncludeAllNegativeNumbersInExceptionMessage() {
        NegativeNumberException exception = Assertions.assertThrows(NegativeNumberException.class, () ->{
            calculator.add("-1,-2");
        });
        assertThat(exception.getMessage()).isEqualTo("Negatives: -1 -2");
    }

    @Test
void shouldAllowCustomDelimiter() {
    int result = calculator.add("//;\n1;2");
    assertThat(result).isEqualTo(3);
}

@Test
void shouldIgnoreNumbersGreaterThan1000() {
    int result = calculator.add("2,1001");
    assertThat(result).isEqualTo(2);
}

@Test
void shouldAllowLongCustomDelimiter() {
    int result = calculator.add("//[***]\n1***2***3");
    assertThat(result).isEqualTo(6);
}

@Test
void shouldAllowMultipleCustomDelimiters() {
    int result = calculator.add("//[*][%]\n1*2%3");
    assertThat(result).isEqualTo(6);
}

@Test
void shouldAllowMultipleLongCustomDelimiters() {
    int result = calculator.add("//[***][%%%]\n1***2%%%3");
    assertThat(result).isEqualTo(6);
}


    
        
}

