import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
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
    public Map<Integer, String> map;

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
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Ошибка: возраст не может быть меньше 0 или больше 100. Введите корректные данные");
        map.put(2, "Ошибка: пол может быть только M или F. Введите корректные данные");
        map.put(3, "Ошибка: источник дохода может быть только: пассивный доход, наёмный работник, наемный работник, " +
                "собственный бизнес, безработный . Введите корректные данные");
        map.put(4, "Ошибка: доход за последний год не может быть меньше 0 или больше 100. Введите корректные данные");
        map.put(5, "Ошибка: кредитный рейтинг не может быть меньше -2 или больше 2. Введите корректные данные");
        map.put(6, "Ошибка: запрошенная сумма не может быть меньше 0.1 или больше 10. Введите корректные данные");
        map.put(7, "Ошибка: срок погашения не может быть меньше 1 или больше 20. Введите корректные данные");
        map.put(8, "Ошибка: цель может быть только: ипотека, развитие бизнеса, автокредит, потребительский. " +
                "Введите корректные данные");
        map.put(9, "Отказ: возраст выдачи кредита начинается с 14");
        map.put(10, "Отказ: возраст заёмщика на момент выплаты кредита будет пенсионный");
        map.put(11, "Отказ: выдача кредита недоступна гражданам пенсионного возраста");
        map.put(12, "Отказ: выдача кредита недоступна безработным");
        map.put(13, "Отказ: выдача кредита недоступна c низким кредитным рейтингом");
        map.put(14, "Отказ: слишком высокая кредитная нагрузка");
        this.map = map;
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

    public void inputValidation() {
        if (getAge() < 0 || getAge() > 100) {
            setDecisionCheckbox(false);
            setMessage(1);
            return;
        }
        if (!Objects.equals(getGender(), "m") || !Objects.equals(getGender(), "f")) {
            setDecisionCheckbox(false);
            setMessage(2);
            return;
        }
        if (!Objects.equals(getIncomeSource(), "пассивный доход") ||
                !Objects.equals(getIncomeSource(), "наёмный работник")
                || !Objects.equals(getIncomeSource(), "наемный работник")
                || !Objects.equals(getIncomeSource(), "собственный бизнес")
                || !Objects.equals(getIncomeSource(), "безработный")) {
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
        if (!Objects.equals(getPurpose(), "ипотека") ||
                !Objects.equals(getIncomeSource(), "развитие бизнеса")
                || !Objects.equals(getIncomeSource(), "автокредит")
                || !Objects.equals(getIncomeSource(), "потребительский")) {
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
        if (getAge() + getPaymentPeriod() > 64) {
            setDecisionCheckbox(false);
            setMessage(10);
            return;
        }
        if (getAge() > 64) {
            setDecisionCheckbox(false);
            setMessage(11);
            return;
        }
        if (Objects.equals(getIncomeSource(), "безработный")) {
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
        if (getIncomeSource().equals("пассивный доход") || getCreditRating() == -1) {
            return 1;
        }
        if (getIncomeSource().equals("наёмный работник") || getIncomeSource().equals("наемный работник")
                || getCreditRating() == 0) {
            return 5;
        }
        return 10;
    }

//    проверка условия что запрошенная сумма не превышает максимальный лимит на выдачу
    public void limitCalculation(int maxAllowedAmount) {
        if (getRequestedAmount() > maxAllowedAmount) {
            setDecisionCheckbox(false);
            setMessage(14);
        }
    }

//    расчёт годовой ставки
    public double getRate() {
        double rate = 10.0;
        if(getPurpose().equals("ипотека")) {
            rate -= 2;
        }
        if(getPurpose().equals("развитие бизнеса")) {
            rate -= 0.5;
        }
        if(getPurpose().equals("потребительский") || getPurpose().equals("автокредит")) {
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
        if (getIncomeSource().equals("пассивный доход")) {
            rate += 0.5;
        }
        if (getIncomeSource().equals("наёмный работник") || getIncomeSource().equals("наемный работник")
                || getIncomeSource().equals("собственный бизнес")) {
            rate -= 0.25;
        }
        return rate;
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
            System.out.println("ГОДОВОЙ ПЛАТЁЖ " + yearPayment);
        }
    }

    public String makeDecision() {
        inputValidation();
        if (!isDecisionCheckbox()) {
            return map.get(message);
        }
        rejectCheck();
        if (!isDecisionCheckbox()) {
            return map.get(message);
        }
        limitCalculation(getMaxAllowedAmount());
        if (!isDecisionCheckbox()) {
            return map.get(message);
        }
        double yearPayment = getYearPayment(getRate());
        rejectCheckWithYearPayment(yearPayment);
        if (!isDecisionCheckbox()) {
            return map.get(message);
        }
        return String.format("Кредит одобрен. Годовой платёж составляет {0}", yearPayment);
    }
}
