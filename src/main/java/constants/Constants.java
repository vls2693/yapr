package constants;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    Map<Integer, String> answers = new HashMap<>();
    Map<Integer, String> genders = new HashMap<>();
    Map<Integer, String> sources = new HashMap<>();
    Map<Integer, String> purposes = new HashMap<>();

    public Constants() {
        answers.put(0, "Кредит одобрен. Годовой платёж составляет ");
        answers.put(1, "Ошибка: возраст не может быть меньше 0 или больше 100");
        answers.put(2, "Ошибка: пол может быть только M или F");
        answers.put(3, "Ошибка: источник дохода может быть только: пассивный доход, наёмный работник, наемный работник, " +
                "собственный бизнес, безработный");
        answers.put(4, "Ошибка: доход за последний год не может быть меньше 0 или больше 100");
        answers.put(5, "Ошибка: кредитный рейтинг не может быть меньше -2 или больше 2");
        answers.put(6, "Ошибка: запрошенная сумма не может быть меньше 0.1 или больше 10");
        answers.put(7, "Ошибка: срок погашения не может быть меньше 1 или больше 20");
        answers.put(8, "Ошибка: цель может быть только: ипотека, развитие бизнеса, автокредит, потребительский");
        answers.put(9, "Отказ: возраст выдачи кредита начинается с 14");
        answers.put(10, "Отказ: выдача кредита недоступна гражданам пенсионного возраста");
        answers.put(11, "Отказ: возраст заёмщика на момент выплаты кредита будет пенсионный");
        answers.put(12, "Отказ: выдача кредита недоступна безработным");
        answers.put(13, "Отказ: выдача кредита недоступна c низким кредитным рейтингом");
        answers.put(14, "Отказ: слишком высокая кредитная нагрузка");
        answers.put(15, "Отказ: запрошенная сумма превышает максимально допустимую к выдаче");
        genders.put(1, "m");
        genders.put(2, "f");
        sources.put(1, "пассивный доход");
        sources.put(2, "наёмный работник");
        sources.put(3, "наемный работник");
        sources.put(4, "собственный бизнес");
        sources.put(5, "безработный");
        purposes.put(1, "ипотека");
        purposes.put(2, "развитие бизнеса");
        purposes.put(3, "автокредит");
        purposes.put(4, "потребительский");
    }

    public Map<Integer, String> getAnswers() {
        return answers;
    }

    public Map<Integer, String> getGenders() {
        return genders;
    }

    public Map<Integer, String> getSources() {
        return sources;
    }

    public Map<Integer, String> getPurposes() {
        return purposes;
    }
}
