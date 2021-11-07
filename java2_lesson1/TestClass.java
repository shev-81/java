package java2_lesson1;

/**
 *  Домашняя работа Шевеленко Андрея Александровича по Java Core 2  к первой лекции.
 */
public class TestClass {

    static Obstacle [] obstaclesArray = new Obstacle[8];
    static Participant [] participantsArray = new Participant[9];

    public static void main(String[] args) {
        // перпятствия на соревнованиях
        // масисв с препятствиями
        obstaclesArray[0] = new Wall(3);
        obstaclesArray[1] = new Treadmill(30);
        obstaclesArray[2] = new Wall(7);
        obstaclesArray[3] = new Treadmill(90);
        obstaclesArray[4] = new Wall(9);
        obstaclesArray[5] = new Wall(5);
        obstaclesArray[6] = new Treadmill(60);
        obstaclesArray[7] = new Treadmill(80);

        //массив игроков
        participantsArray[0] = new Cat(70,8, "Тишка");
        participantsArray[1] = new Cat(20,2, "Арбузик");
        participantsArray[2] = new Cat(30,3, "Мурзик");
        participantsArray[3] = new Human(40,4, "Вася");
        participantsArray[4] = new Human(50,5, "Жора");
        participantsArray[5] = new Human(100,9, "Серега");
        participantsArray[6] = new Robot(70,7, "OD-1");
        participantsArray[7] = new Robot(80,8, "Мегатрон");
        participantsArray[8] = new Robot(90,9, "Максимус");

        for (int i=0; i< participantsArray.length; i ++){
            System.out.println(participantsArray[i].getName()+": дистанция - "+participantsArray[i].getMaxrun()+" высота прыжка - "+participantsArray[i].getMaxjump());
            for (int j=0; j<obstaclesArray.length; j++){
                if (obstaclesArray[j].canDoit(participantsArray[i])) {
                        System.out.println("  преодолел перпятствие"+obstaclesArray[j]);
                    } else {
                        System.out.println(participantsArray[i].getName() + " выбыл из марафона, потому что не преодолел "+obstaclesArray[j]+"\n");
                        break;
                    }
                if (j+1==obstaclesArray.length) System.out.println(participantsArray[i].getName()+" преодолел все препятствия и завершил марафон!!! \n");
            }

        }

    }
}

