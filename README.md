Задание 1. Подготовка кейсов
Дополнительные условия
В описании не нашёл конкретики по возрасту. Принял следующие условия по возрасту:
Минимальный возраст выдачи кредита - 14 лет
Пенсионный возраст - 65 лет
Максимально возможный возраст - 100 лет
В качестве максимального годового дохода взял 100.
Если запрошенная сумма превышает максимальную сумму к выдаче, то тоже даём отказ
Кейсы
Данные из задания вынес в PAIRWISE. Всего получается 17 280 комбинаций. С помощью pairwise удалось сократить количество кейсов до 38, но этого всё равно много. По крайней мере, для ручного тестирования. Потому решил сократить количество кейсов для случаев, когда заявитель сразу же не проходит по условиям выдачи кредита: если до пенсионного возраста остаётся 1 год на момент подачи заявки, так как минимальный срок по кредиту 1 год, то на момент выплаты кредита заёмщику будет 65, возраст менее 14 лет, статус безработного и кредитный рейтинг -2. Удалось довести количество позитивных кейсов до 23

Количество кейсов на отказы - 10. Не удалось составить кейс, проверяющий условие отказа, когда годовой платёж превышает 50% годового дохода, так как уже до этого момента получаю отказ по условию, что результат деления запрошенной суммы должен быть не более трети годового дохода

Кейсы лежат в файле excel, приложенном к заданию. Каждый тип кейсов расположен на отдельном листе


Задание 2. Про код расчёта заявки
Расчёт заявки реализован так, что возвращает ошибку или отказ сразу, как только не будет выполнено условие. Это означает, что на проверку каждого условия ошибки или отказа понадобится 1 кейс. То есть, если мы передадим в метод безработного с кредитным рейтингом -2, то отказ мы получим только на основании одного условия, второе условие уже не будет проверяться.
Реализация калькулятора лежит в src/main/java/CreditCalculator.java


Задание 3. Тесты
Тесты сделал на Java 8 с использованием JUnit 4.
Каждый тип тестов: на ошибки, отказы и одобрения поместил в разных классах. Тесты параметризованы.
Тесты лежат в src/test/java
