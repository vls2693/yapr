package constants;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    Map<Integer, String> answers = new HashMap<>();
    Map<String, String> genders = new HashMap<>();
    Map<String, String> sources = new HashMap<>();
    Map<String, String> purposes = new HashMap<>();

    public Constants() {
        answers.put(1, "Ошибка: возраст не может быть меньше 0 или больше 100. Введите корректные данные");
        answers.put(2, "Ошибка: пол может быть только M или F. Введите корректные данные");
        answers.put(3, "Ошибка: источник дохода может быть только: пассивный доход, наёмный работник, наемный работник, " +
                "собственный бизнес, безработный. Введите корректные данные");
        answers.put(4, "Ошибка: доход за последний год не может быть меньше 0 или больше 100. Введите корректные данные");
        answers.put(5, "Ошибка: кредитный рейтинг не может быть меньше -2 или больше 2. Введите корректные данные");
        answers.put(6, "Ошибка: запрошенная сумма не может быть меньше 0.1 или больше 10. Введите корректные данные");
        answers.put(7, "Ошибка: срок погашения не может быть меньше 1 или больше 20. Введите корректные данные");
        answers.put(8, "Ошибка: цель может быть только: ипотека, развитие бизнеса, автокредит, потребительский. " +
                "Введите корректные данные");
        answers.put(9, "Отказ: возраст выдачи кредита начинается с 14");
        answers.put(10, "Отказ: возраст заёмщика на момент выплаты кредита будет пенсионный");
        answers.put(11, "Отказ: выдача кредита недоступна гражданам пенсионного возраста");
        answers.put(12, "Отказ: выдача кредита недоступна безработным");
        answers.put(13, "Отказ: выдача кредита недоступна c низким кредитным рейтингом");
        answers.put(14, "Отказ: слишком высокая кредитная нагрузка");
        genders.put("m", "m");
        genders.put("f", "f");
        sources.put("пассивный доход", "пассивный доход");
        sources.put("наёмный работник", "наёмный работник");
        sources.put("наемный работник", "наемный работник");
        sources.put("собственный бизнес", "собственный бизнес");
        sources.put("безработный", "безработный");
        purposes.put("ипотека", "ипотека");
        purposes.put("развитие бизнеса", "развитие бизнеса");
        purposes.put("автокредит", "автокредит");
        purposes.put("потребительский", "потребительский");
    }

    public Map<Integer, String> getAnswers() {
        return answers;
    }

    public Map<String, String> getGenders() {
        return genders;
    }

    public Map<String, String> getSources() {
        return sources;
    }

    public Map<String, String> getPurposes() {
        return purposes;
    }
}
