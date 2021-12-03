import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
@RunWith(value = Parameterized.class)
public class TestError {
    private int age;
    private String gender;
    private String incomeSource;
    private int lastYearIncome;
    private int creditRating;
    private double requestedAmount;
    private int paymentPeriod;
    private String purpose;
    private String result;

    public TestError(int age, String gender, String incomeSource, int lastYearIncome, int creditRating,
                     double requestedAmount, int paymentPeriod, String purpose, String result) {
        this.age = age;
        this.gender = gender;
        this.incomeSource = incomeSource;
        this.lastYearIncome = lastYearIncome;
        this.creditRating = creditRating;
        this.requestedAmount = requestedAmount;
        this.paymentPeriod = paymentPeriod;
        this.purpose = purpose;
        this.result = result;
    }

    @Parameters()
    public static  Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {-2, "M", "пассивный доход", 5, 0, 1, 5, "автокредит",
                "Ошибка: возраст не может быть меньше 0 или больше 100"},
            {102, "M", "пассивный доход", 5, 0, 1, 5, "автокредит",
                "Ошибка: возраст не может быть меньше 0 или больше 100"},
            {20, "D", "пассивный доход", 5, 0, 1, 5, "автокредит", "Ошибка: пол может быть только M или F"},
            {20, "M", "деньги", 5, 0, 1, 5, "автокредит", "Ошибка: источник дохода может быть только: пассивный доход, " +
                "наёмный работник, наемный работник, собственный бизнес, безработный"},
            {20, "M", "пассивный доход", -5, 0, 1, 5, "автокредит",
                "Ошибка: доход за последний год не может быть меньше 0 или больше 100"},
            {20, "M", "пассивный доход", 125, 0, 1, 5, "автокредит",
                "Ошибка: доход за последний год не может быть меньше 0 или больше 100"},
            {20, "F", "пассивный доход", 5, -4, 1, 5, "автокредит",
                "Ошибка: кредитный рейтинг не может быть меньше -2 или больше 2"},
            {20, "F", "пассивный доход", 5, 6, 1, 5, "автокредит",
                "Ошибка: кредитный рейтинг не может быть меньше -2 или больше 2"},
            {20, "F", "пассивный доход", 5, 0, 0, 5, "автокредит",
                "Ошибка: запрошенная сумма не может быть меньше 0.1 или больше 10"},
            {20, "F", "пассивный доход", 5, 0, 13, 5, "автокредит",
                "Ошибка: запрошенная сумма не может быть меньше 0.1 или больше 10"},
            {20, "F", "пассивный доход", 5, 0, 1, 0, "автокредит",
                "Ошибка: срок погашения не может быть меньше 1 или больше 20"},
            {20, "F", "пассивный доход", 5, 0, 1, 27, "автокредит",
                "Ошибка: срок погашения не может быть меньше 1 или больше 20"},
            {20, "F", "пассивный доход", 5, 0, 1, 5, "шопинг",
                "Ошибка: цель может быть только: ипотека, развитие бизнеса, автокредит, потребительский"}
        });
    }

    @Test
    public void errorCase1() {
        CreditCalculator creditCalculator = new CreditCalculator(age, gender, incomeSource,
                lastYearIncome, creditRating, requestedAmount, paymentPeriod, purpose);
        assertEquals(creditCalculator.makeDecision(), result);
    }
}
