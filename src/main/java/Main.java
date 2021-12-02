public class Main {
    public static void main(String[] args) {

        CreditCalculator calc = new CreditCalculator(40, "M", "собственный бизнес",
                1, 2, 0.1, 4, "развитие бизнеса");
        System.out.println(calc.makeDecision());
    }
}
