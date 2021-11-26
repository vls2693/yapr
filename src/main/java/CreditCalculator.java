import java.util.Objects;

public class CreditCalculator {
    private int age;
    private String gender;
    private String incomeSource;
    private int lastYearIncome;
    private int creditRating;
    private double requestedAmount;
    private int paymentPeriod;
    private String purpose;
    private boolean validationChecker;
    private boolean ageChecker;
    private boolean incomeSourceChecker;
    private boolean creditRatingChecker;
    private boolean creditBurden;
    private double baseRate;
    private int maxAllowedCreditBody;
    private double yearPayment;

    public CreditCalculator(int age, String gender, String incomeSource, int lastYearIncome, int creditRating,
                            double requestedAmount, int paymentPeriod, String purpose) {
//        входные параметры
        this.age = age;
        this.gender = gender;
        this.incomeSource = incomeSource;
        this.lastYearIncome = lastYearIncome;
        this.creditRating = creditRating;
        this.requestedAmount = requestedAmount;
        this.paymentPeriod = paymentPeriod;
        this.purpose = purpose;
//        переменные проверок по отказам, если одна из переменных принимает значение false, возвращаем отказ
        this.validationChecker = true;
        this.ageChecker = true;
        this.incomeSourceChecker = true;
        this.creditRatingChecker = true;
        this.creditBurden = true;
        this.baseRate = 10.0;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
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

    public int getPaymentPeriod() {
        return paymentPeriod;
    }

    public String getPurpose() {
        return purpose;
    }

    public int getMaxAllowedCreditBody() {
        return maxAllowedCreditBody;
    }

    public boolean isAgeChecker() {
        return ageChecker;
    }

    public void setValidationChecker(boolean validationChecker) {
        this.validationChecker = validationChecker;
    }

    public void setAgeChecker(boolean ageChecker) {
        this.ageChecker = ageChecker;
    }

    public void setIncomeSourceChecker(boolean incomeSourceChecker) {
        this.incomeSourceChecker = incomeSourceChecker;
    }

    public void setCreditRatingChecker(boolean creditRatingChecker) {
        this.creditRatingChecker = creditRatingChecker;
    }

    public void setCreditBurden(boolean creditBurden) {
        this.creditBurden = creditBurden;
    }

    public void setMaxAllowedCreditBody(int maxAllowedCreditBody) {
        this.maxAllowedCreditBody = maxAllowedCreditBody;
    }

    public String inputValidation() {
        if (getAge() < 0 || getAge() > 100) {
            setValidationChecker(false);
            return "Ошибка: возраст не может быть меньше 0 или больше 100. Введите корректные данные";
        }
        if (!Objects.equals(getGender().toUpperCase(), "M") || !Objects.equals(getGender().toUpperCase(), "F")) {
            setValidationChecker(false);
            return "Ошибка: пол может быть только M или F. Введите корректные данные";
        }
        if (!Objects.equals(getIncomeSource().toLowerCase(), "пассивный доход") ||
                !Objects.equals(getIncomeSource().toLowerCase(), "наёмный работник")
                || !Objects.equals(getIncomeSource().toLowerCase(), "наемный работник")
                || !Objects.equals(getIncomeSource().toLowerCase(), "собственный бизнес")
                || !Objects.equals(getIncomeSource().toLowerCase(), "безработный")) {
            setValidationChecker(false);
            return "Ошибка: источник дохода может быть только: пассивный доход, наёмный работник, наемный работник, " +
                    "собственный бизнес, безработный . Введите корректные данные";
        }
        if (getLastYearIncome() < 0 || getLastYearIncome() > 100) {
            setValidationChecker(false);
            return "Ошибка: доход за последний год не может быть меньше 0 или больше 100. Введите корректные данные";
        }
        if (getCreditRating() < -2 || getCreditRating() > 2) {
            setValidationChecker(false);
            return "Ошибка: кредитный рейтинг не может быть меньше -2 или больше 2. Введите корректные данные";
        }
        if (getRequestedAmount() < 0.1 || getRequestedAmount() > 10) {
            setValidationChecker(false);
            return "Ошибка: запрошенная сумма не может быть меньше 0.1 или больше 10. Введите корректные данные";
        }
        if (getPaymentPeriod() < 1 || getPaymentPeriod() > 20) {
            setValidationChecker(false);
            return "Ошибка: срок погашения не может быть меньше 1 или больше 20. Введите корректные данные";
        }
        if (!Objects.equals(getPurpose().toLowerCase(), "ипотека") ||
                !Objects.equals(getIncomeSource().toLowerCase(), "развитие бизнеса")
                || !Objects.equals(getIncomeSource().toLowerCase(), "автокредит")
                || !Objects.equals(getIncomeSource().toLowerCase(), "потребительский")) {
            setValidationChecker(false);
            return "Ошибка: цель может быть только: ипотека, развитие бизнеса, автокредит, " +
                    "потребительский . Введите корректные данные";
        }
        return "Валидация пройдена";
    }

    public String ageCheck() {
        if (getAge() < 14) {
            setAgeChecker(false);
            return "Отказ: возраст выдачи кредита начинается с 14";
        }
        if (getAge() + getPaymentPeriod() > 64) {
            setAgeChecker(false);
            return "Отказ: возраст заёмщика на момент выплаты кредита будет пенсионный";
        }
        if (getAge() > 64) {
            setAgeChecker(false);
            return "Отказ: выдача кредита недоступна гражданам пенсионного возраста";
        }
        return "Проверки на возраст пройдены";
    }

    public String incomeSourceCheck() {
        if (Objects.equals(getIncomeSource(), "безработный")) {
            setIncomeSourceChecker(false);
            return "Отказ: выдача кредита недоступна безработным";
        }
        return "Проверки на источник дохода пройдены";
    }

    public String creditRatingCheck() {
        if (getCreditRating() == -2) {
            setCreditRatingChecker(false);
            return "Отказ: выдача кредита недоступна c низким кредитным рейтингом";
        }
        return "Проверки на кредитный рейтинг пройдены";
    }

    public String creditBurdenCheck() {
        if (getRequestedAmount() / getPaymentPeriod() > getLastYearIncome() / 3.0) {
            setCreditBurden(false);
            return "Отказ: слишком высокая кредитная нагрузка";
        }
        return "Первая проверка на кредитную нагрузку пройдена";
    }

    public void creditBodyCalculating() {
        if (getIncomeSource().equals("пассивный доход") || getCreditRating() == -1) {
            setMaxAllowedCreditBody(1);
            return;
        }
        if (getIncomeSource().equals("наёмный работник") || getIncomeSource().equals("наемный работник")
                || getCreditRating() == 0) {
            setMaxAllowedCreditBody(5);
            return;
        }
        if (getIncomeSource().equals("собственный бизнес") || getCreditRating() == 1 || getCreditRating() == 2) {
            setMaxAllowedCreditBody(10);
        }
    }

    public String limitCalculation() {
        if (getRequestedAmount() > getMaxAllowedCreditBody()) {
            setCreditBurden(false);
            return "Отказ: слишком высокая кредитная нагрузка";
        }
        return "Проверка на лимит пройдена";
    }

    public void creditRateCalculating() {
        if(getPurpose().equals("ипотека")) {
            this.baseRate = this.baseRate - 2;
        }
        if(getPurpose().equals("развитие бизнеса")) {
            this.baseRate = this.baseRate - 0.5;
        }
        if(getPurpose().equals("потребительский") || getPurpose().equals("автокредит")) {
            this.baseRate = this.baseRate + 1.5;
        }
        if (getCreditRating() == -1) {
            this.baseRate = this.baseRate + 1.5;
        }
        if (getCreditRating() == 1) {
            this.baseRate = this.baseRate - 0.25;
        }
        if (getCreditRating() == 2) {
            this.baseRate = this.baseRate - 0.75;
        }
        this.baseRate = this.baseRate - Math.log10(getRequestedAmount());
        if (getIncomeSource().equals("пассивный доход")) {
            this.baseRate = this.baseRate + 0.5;
        }
        if (getIncomeSource().equals("наёмный работник") || getIncomeSource().equals("наемный работник")
                || getIncomeSource().equals("собственный бизнес")) {
            this.baseRate = this.baseRate - 0.25;
        }
    }

    public void yearPayment() {
        this.yearPayment = (getRequestedAmount() * (1 + getPaymentPeriod() * (this.baseRate)))/getPaymentPeriod();
    }

    public String creditBurdenCheckerWithYearPayment() {
        if (getLastYearIncome() / 2.0 < yearPayment) {
            setValidationChecker(false);
            return "Отказ: слишком высокая кредитная нагрузка";
        }
        return "Вторая проверка на кредитную нагрузку пройдена";
    }
}
