import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String [] args) throws Exception {
        MyThread myThread1 = new MyThread(true);
        MyThread myThread2 = new MyThread(false);
        MyThreadReader myThreadReader = new MyThreadReader();



        myThread1.start();
        myThread2.start();
        //Thread.sleep(10 * 10);




        myThreadReader.start();
        Thread.sleep(10 * 100);

        myThread1.scheduleStop();
        myThread2.scheduleStop();

        myThreadReader.scheduleStop();


    }

}