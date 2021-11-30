public class Main {
    public static void main(String[] args) {

        CreditCalculator calc = new CreditCalculator(16, "M", "собственный бизнес",
                10, 1, 6, 10, "ипотека");
        System.out.println(calc.makeDecision());
    }
}
