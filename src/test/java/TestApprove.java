import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class TestApprove {
    private int age;
    private String gender;
    private String incomeSource;
    private int lastYearIncome;
    private int creditRating;
    private double requestedAmount;
    private int paymentPeriod;
    private String purpose;
    private String result;

    public TestApprove(int age, String gender, String incomeSource, int lastYearIncome, int creditRating,
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
            {14, "F", "пассивный доход", 1, 2, 0.1, 1, "потребительский",
                "Кредит одобрен. Годовой платёж составляет 0.11"},
            {45, "M", "пассивный доход", 3, 0, 0.1, 1, "развитие бизнеса",
                "Кредит одобрен. Годовой платёж составляет 0.11"},
            {33, "F", "наёмный работник", 10, 1, 0.1, 2, "автокредит",
                "Кредит одобрен. Годовой платёж составляет 0.06"},
            {20, "M", "безработный", 5, 0, 1, 5, "автокредит", "Отказ: выдача кредита недоступна безработным"},
            {24, "M", "собственный бизнес", 1, -1, 0.8, 20, "потребительский",
                "Кредит одобрен. Годовой платёж составляет 0.14"},
            {17, "M", "пассивный доход", 1, 1, 0.1, 1, "развитие бизнеса",
                "Кредит одобрен. Годовой платёж составляет 0.11"},
            {40, "M", "наёмный работник", 100, 2, 5, 20, "автокредит",
                "Кредит одобрен. Годовой платёж составляет 0.67"},
            {14, "F", "пассивный доход", 100, 0, 0.4, 3, "ипотека",
                "Кредит одобрен. Годовой платёж составляет 0.17"},
            {14, "F", "наёмный работник", 3, -1, 0.1, 1, "автокредит",
                "Кредит одобрен. Годовой платёж составляет 0.11"},
            {14, "M", "собственный бизнес", 100, 0, 4.5, 1, "потребительский",
                "Кредит одобрен. Годовой платёж составляет 4.98"},
            {14, "F", "наёмный работник", 1, 2, 0.1, 20, "развитие бизнеса",
                "Кредит одобрен. Годовой платёж составляет 0.01"},
            {14, "M", "собственный бизнес", 4, -1, 0.1, 1, "автокредит",
                "Кредит одобрен. Годовой платёж составляет 0.11"},
            {22, "M", "наёмный работник", 100, 1, 0.1, 1, "ипотека",
                "Кредит одобрен. Годовой платёж составляет 0.11"},
            {31, "F", "собственный бизнес", 1, 2, 0.1, 4, "развитие бизнеса",
                "Кредит одобрен. Годовой платёж составляет 0.03"},
            {26, "M", "пассивный доход", 1, -1, 0.9, 20, "автокредит",
                "Кредит одобрен. Годовой платёж составляет 0.15"},
            {32, "F", "собственный бизнес", 100, 1, 0.1, 1, "ипотека",
                "Кредит одобрен. Годовой платёж составляет 0.11"},
            {44, "M", "пассивный доход", 1, -1, 0.7, 13, "развитие бизнеса",
                "Кредит одобрен. Годовой платёж составляет 0.14"},
            {63, "M", "пассивный доход", 100, 2, 1, 1, "ипотека",
                "Кредит одобрен. Годовой платёж составляет 1.08"},
            {14, "M", "собственный бизнес", 34, 2, 10, 8, "ипотека",
                "Кредит одобрен. Годовой платёж составляет 1.85"},
            {14, "M", "пассивный доход", 100, -1, 0.1, 20, "развитие бизнеса",
                "Кредит одобрен. Годовой платёж составляет 0.02"},
            {14, "F", "пассивный доход", 1, 0, 0.3, 1, "автокредит",
                "Кредит одобрен. Годовой платёж составляет 0.33"},
            {14, "F", "собственный бизнес", 2, -1, 0.1, 20, "ипотека",
                "Кредит одобрен. Годовой платёж составляет 0.02"},
            {14, "M", "пассивный доход", 100, 0, 0.1, 1, "развитие бизнеса",
                "Кредит одобрен. Годовой платёж составляет 0.11"},
            {14, "F", "наёмный работник", 1, 1, 0.2, 1, "автокредит",
                "Кредит одобрен. Годовой платёж составляет 0.22"}
        });
    }

    @Test
    public void errorCase1() {
        CreditCalculator creditCalculator = new CreditCalculator(age, gender, incomeSource,
                lastYearIncome, creditRating, requestedAmount, paymentPeriod, purpose);
        assertEquals(creditCalculator.makeDecision(), result);
    }
}
