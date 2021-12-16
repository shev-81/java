package java3_lesson4;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecServTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future <String> future1 = executorService.submit(() -> {
            System.out.println("запустился 1 поток");
            try {
                System.out.println("1 поток заснул на 5 сек");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("результат потока 1 ");
            return "результат потока 1";
        });

        Future <String>  future2 = executorService.submit(() -> {
            System.out.println("запустился 2 поток");
            try {
                System.out.println("2 поток заснул на 2 сек");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("результат потока 2 ");
            return "результат потока 2 "+future1.get(); //блокирующий метод get() ждем в нем пока не отработает поток 1 и не вернет через этот метод результат
        });
        System.out.println("Резульатт выполнения 2 ух потоков - "+future2.get()); // null если задача завершилась
        executorService.shutdown();
    }
}
