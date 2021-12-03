import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class TestReject {
    private int age;
    private String gender;
    private String incomeSource;
    private int lastYearIncome;
    private int creditRating;
    private double requestedAmount;
    private int paymentPeriod;
    private String purpose;
    private String result;

    public TestReject(int age, String gender, String incomeSource, int lastYearIncome, int creditRating,
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
            {12, "M", "пассивный доход", 5, 0, 1, 5, "автокредит", "Отказ: возраст выдачи кредита начинается с 14"},
            {65, "M", "пассивный доход", 5, 0, 1, 5, "автокредит",
                "Отказ: выдача кредита недоступна гражданам пенсионного возраста"},
            {50, "M", "пассивный доход", 5, 0, 1, 17, "автокредит",
                "Отказ: возраст заёмщика на момент выплаты кредита будет пенсионный"},
            {20, "M", "безработный", 5, 0, 1, 5, "автокредит", "Отказ: выдача кредита недоступна безработным"},
            {20, "M", "пассивный доход", 5, -2, 1, 5, "автокредит",
                "Отказ: выдача кредита недоступна c низким кредитным рейтингом"},
            {20, "F", "пассивный доход", 10, 0, 8, 2, "автокредит", "Отказ: слишком высокая кредитная нагрузка"},
            {20, "F", "пассивный доход", 5, 2, 4, 5, "автокредит",
                "Отказ: запрошенная сумма превышает максимально допустимую к выдаче"},
            {20, "F", "наёмный работник", 5, 2, 6, 5, "автокредит",
                "Отказ: запрошенная сумма превышает максимально допустимую к выдаче"},
            {20, "F", "собственный бизнес", 5, -1, 2, 5, "автокредит",
                "Отказ: запрошенная сумма превышает максимально допустимую к выдаче"},
            {20, "F", "собственный бизнес", 5, 0, 6, 5, "автокредит",
                "Отказ: запрошенная сумма превышает максимально допустимую к выдаче"}
        });
    }

    @Test
    public void errorCase1() {
        CreditCalculator creditCalculator = new CreditCalculator(age, gender, incomeSource,
                lastYearIncome, creditRating, requestedAmount, paymentPeriod, purpose);
        assertEquals(creditCalculator.makeDecision(), result);
    }
}
