public class Main {
    public static void main(String[] args) {
        System.out.println(10 - Math.log10(0.1));

        CreditCalculator calc = new CreditCalculator(16, "M", "собственный бизнес",
                10, 0, 3, 5, "ипотека");
        System.out.println(calc.makeDecision());
    }
}
