package ru.roller.sbundo.BlockingQueue;

import java.util.Random;

public class Main {
      private static BlockingQueue<String> queue = new BlockingQueue<>(5);
      private static ProduceAndConsume pc = new ProduceAndConsume(queue);



      private static String[] strings = {
            "Привет",
            "Hello",
            "Java",
            "Программирование",
            "String",
            "Массив",
            "Коллекции",
            "Потоки",
            "Spring",
            "Hibernate",
            "Метод",
            "Класс",
            "Объект",
            "Интерфейс",
            "Наследование",
            "Полиморфизм",
            "Инкапсуляция",
            "Исключения",
            "Компиляция",
            "Выполнение"};


    public static void main(String[] args) {

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                            pc.produce(getRandomString());
                            Thread.sleep(500);

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
;            @Override
             public void run() {
              while (true) {
                  try {
                          pc.consume();
                      Thread.sleep(500);

                  } catch (InterruptedException e) {
                         throw new RuntimeException(e);
                  }
               }
            }
        });

        producer.start();
        consumer.start();

    }

    public static String getRandomString() {
        Random random = new Random();

        return strings[random.nextInt(strings.length)];
    }
}
