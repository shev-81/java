package algoritms_lesson_1;

import java.util.Random;

/** Класс создания экземпляра ноутбука
 *  Lenuvo > Asos > MacNote > Eser > Xamiou
 */
public class MyNbook {
        private static final Random random = new Random();
        int cost;
        int memory;
        int numBook;
        String nameBook;

        MyNbook(){
            cost = random.nextInt(40)*50;
            memory = random.nextInt(6)*4;
            numBook = random.nextInt(5);
            if (memory==0) memory=4;
            if (cost<500) cost=cost+500;
            switch (numBook) {
                case 0: nameBook="Xamiou";
                    break;
                case 1: nameBook="Eser";
                    break;
                case 2: nameBook="MacNote";
                    break;
                case 3: nameBook="Asos";
                    break;
                case 4: nameBook="Lenuvo";
                    break;
                default: nameBook = "Xamiou";
            }
        }
    }

