package horstmann_lessons.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTesting {
    private int id;
    private String name;
    private static Lock lock = new ReentrantLock();

    public ThreadTesting(){}

    public ThreadTesting(int id, String name){
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        ThreadTesting test1 = new ThreadTesting(1, "test1");
        ThreadTesting test2 = new ThreadTesting(1, "test2");

        Thread t1 = new Thread(() -> {
            while(test1.id < 100){
                test1.id++;
                System.out.println(test1.id + " " + Thread.currentThread());
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
            }

        });

        Thread t2 = new Thread(() -> {
            while(test1.id < 100){
                test1.id++;
                System.out.println(test1.id + " " + Thread.currentThread());
                try{
                    Thread.sleep(2000);
                } catch (InterruptedException e) {

                }
            }
        });

        t1.start();
        t2.start();

    }
}
