package algoritm_lesson_5;

public class Countdown {
    public static void main(String[] args) {
//        countdown(5); //5 4 3 2 1
        countdownCycle(5);
    }

    /*
    * 5 -> 4
    * 4 -> 3
    * 3 -> 2
    * 2 -> 1
    * 1
    * */

    private static void countdown(int n) {
        if (n < 1) {
            return;
        }
        System.out.println(n);
        countdown(n - 1);
        System.out.println("End n = " + n);
    }

    private static void countdownCycle(int n) {
        while (true) {
            if (n < 1) {
                return;
            }
            System.out.println(n--);
//            countdown(n - 1);
            System.out.println("End n = " + n);
        }
    }
}
