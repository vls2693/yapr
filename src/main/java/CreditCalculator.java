import constants.Constants;

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
    private boolean decisionCheckbox;
    private int message;

    public CreditCalculator(int age, String gender, String incomeSource, int lastYearIncome, int creditRating,
                            double requestedAmount, int paymentPeriod, String purpose) {
//        входные параметры
        this.age = age;
        this.gender = gender.toLowerCase();
        this.incomeSource = incomeSource.toLowerCase();
        this.lastYearIncome = lastYearIncome;
        this.creditRating = creditRating;
        this.requestedAmount = requestedAmount;
        this.paymentPeriod = paymentPeriod;
        this.purpose = purpose.toLowerCase();
//        переменная проверок по ошибкам и отказам, если принимает значение false, возвращаем ошибку или отказ
        this.decisionCheckbox = true;
        this.message = 0;
    }

    Constants constants = new Constants();

    public int getAge() {
        return age;
    }

    public String getGender() {
        return this.gender;
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

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public boolean isDecisionCheckbox() {
        return decisionCheckbox;
    }

    public void setDecisionCheckbox(boolean decisionCheckbox) {
        this.decisionCheckbox = decisionCheckbox;
    }

//    проверки на вводимые значения, выходящие за пределы допустимых
    public void inputValidation() {
        if (getAge() < 0 || getAge() > 100) {
            setDecisionCheckbox(false);
            setMessage(1);
            return;
        }
        if (!constants.getGenders().containsValue(getGender())) {
            setDecisionCheckbox(false);
            setMessage(2);
            return;
        }
        if (!constants.getSources().containsValue(getIncomeSource())) {
            setDecisionCheckbox(false);
            setMessage(3);
            return;
        }
        if (getLastYearIncome() < 0 || getLastYearIncome() > 100) {
            setDecisionCheckbox(false);
            setMessage(4);
            return;
        }
        if (getCreditRating() < -2 || getCreditRating() > 2) {
            setDecisionCheckbox(false);
            setMessage(5);
            return;
        }
        if (getRequestedAmount() < 0.1 || getRequestedAmount() > 10) {
            setDecisionCheckbox(false);
            setMessage(6);
            return;
        }
        if (getPaymentPeriod() < 1 || getPaymentPeriod() > 20) {
            setDecisionCheckbox(false);
            setMessage(7);
            return;
        }
        if (!constants.getPurposes().containsValue(getPurpose())) {
            setDecisionCheckbox(false);
            setMessage(8);
        }
    }

//    метод проверки на гарантированные отказы по возрасту, рейтингу, доходу
    public void rejectCheck() {
        if (getAge() < 14) {
            setDecisionCheckbox(false);
            setMessage(9);
            return;
        }
        if (getAge() > 64) {
            setDecisionCheckbox(false);
            setMessage(10);
            return;
        }
        if (getAge() + getPaymentPeriod() > 64) {
            setDecisionCheckbox(false);
            setMessage(11);
            return;
        }
        if (Objects.equals(getIncomeSource(), constants.getSources().get(5))) {
            setDecisionCheckbox(false);
            setMessage(12);
            return;
        }
        if (getCreditRating() == -2) {
            setDecisionCheckbox(false);
            setMessage(13);
            return;
        }
        if (getRequestedAmount() / getPaymentPeriod() > getLastYearIncome() / 3.0) {
            setDecisionCheckbox(false);
            setMessage(14);
        }
    }

//    получение максимально возможной суммы к выдаче
    public int getMaxAllowedAmount() {
        if (getIncomeSource().equals(constants.getSources().get(1)) || getCreditRating() == -1) {
            return 1;
        }
        if (getIncomeSource().equals(constants.getSources().get(2)) || getIncomeSource()
                .equals(constants.getSources().get(3)) || getCreditRating() == 0) {
            return 5;
        }
        return 10;
    }

//    проверка условия что запрошенная сумма не превышает максимальный лимит на выдачу
    public void limitCalculation(int maxAllowedAmount) {
        if (getRequestedAmount() > maxAllowedAmount) {
            setDecisionCheckbox(false);
            setMessage(15);
        }
    }

//    расчёт годовой ставки
    public double getRate() {
        double rate = 10.0;
        if(getPurpose().equals(constants.getPurposes().get(1))) {
            rate -= 2;
        }
        if(getPurpose().equals(constants.getPurposes().get(2))) {
            rate -= 0.5;
        }
        if(getPurpose().equals(constants.getPurposes().get(4))) {
            rate += 1.5;
        }
        if (getCreditRating() == -1) {
            rate += 1.5;
        }
        if (getCreditRating() == 1) {
            rate -= 0.25;
        }
        if (getCreditRating() == 2) {
            rate -= 0.75;
        }
        rate -= Math.round(Math.log10(getRequestedAmount()) * 100.0) / 100.0;
        if (getIncomeSource().equals(constants.getSources().get(1))) {
            rate += 0.5;
        }
        if (getIncomeSource().equals(constants.getSources().get(2)) || getIncomeSource()
                .equals(constants.getSources().get(3)) || getIncomeSource().equals(constants.getSources().get(4))) {
            rate -= 0.25;
        }
        return rate/100;
    }

//    расчёт годового платежа
    public double getYearPayment(double rate) {
        return Math.round((getRequestedAmount() * (1 + getPaymentPeriod() * (rate)))/getPaymentPeriod() * 100.0) / 100.0;
    }

//    проверка условия, что годовой платёж не превышает половины дохода
    public void rejectCheckWithYearPayment(double yearPayment) {
        if (getLastYearIncome() / 2.0 < yearPayment) {
            setDecisionCheckbox(false);
            setMessage(14);
        }
    }

//    метод, вызывающий все проверки и возвращающий решение по заявке
    public String makeDecision() {
        inputValidation();
        if (!isDecisionCheckbox()) {
            return constants.getAnswers().get(message);
        }
        rejectCheck();
        if (!isDecisionCheckbox()) {
            return constants.getAnswers().get(message);
        }
        limitCalculation(getMaxAllowedAmount());
        if (!isDecisionCheckbox()) {
            return constants.getAnswers().get(message);
        }
        double yearPayment = getYearPayment(getRate());
        rejectCheckWithYearPayment(yearPayment);
        if (!isDecisionCheckbox()) {
            return constants.getAnswers().get(message);
        }
        return constants.getAnswers().get(message) + yearPayment;
    }
}