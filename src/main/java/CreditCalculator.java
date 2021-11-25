public class CreditCalculator {
    private int age;
    private String gender;
    private String incomeSource;
    private int lastYearIncome;
    private int creditRating;
    private double requestedAmount;
    private int paymentYears;
    private String purpose;
    private boolean ageChecker;

    public CreditCalculator(int age, String gender, String incomeSource, int lastYearIncome, int creditRating,
                            double requestedAmount, int paymentYears, String purpose) {
        this.age = age;
        this.gender = gender;
        this.incomeSource = incomeSource;
        this.lastYearIncome = lastYearIncome;
        this.creditRating = creditRating;
        this.requestedAmount = requestedAmount;
        this.paymentYears = paymentYears;
        this.purpose = purpose;
        this.ageChecker = true;
    }

    public int getAge() {
        return age;
    }

    public String getIncomeSource() {
        return incomeSource;
    }

    public int getLastYearIncome() {
        return lastYearIncome;
    }

    public int getCreditRating() {
        return creditRating;
    }

    public double getRequestedAmount() {
        return requestedAmount;
    }

    public int getPaymentYears() {
        return paymentYears;
    }

    public String getPurpose() {
        return purpose;
    }

    public boolean isAgeChecker() {
        return ageChecker;
    }

    public void setAgeChecker(boolean ageChecker) {
        this.ageChecker = ageChecker;
    }

    public String ageCheck() {
        if (getAge() < 0) {
            setAgeChecker(false);
            return "Возраст не может быть меньше 0. Введите корректные данные";
        }
        if (getAge() < 14) {
            setAgeChecker(false);
            return "Отказ: возраст выдачи кредита начинается с 14";
        }
        if (getAge() == 64) {
            setAgeChecker(false);
            return "Отказ: возраст заёмщика на момент выплаты кредита будет пенсионный";
        }
        if (getAge() > 100) {
            setAgeChecker(false);
            return "Возраст не может быть меньше 100. Введите корректные данные";
        }
        if (getAge() > 64) {
            setAgeChecker(false);
            return "Отказ: выдача кредита недоступна гражданам пенсионного возраста";
        }
        return "Проверки на возраст пройдены";
    }
}
