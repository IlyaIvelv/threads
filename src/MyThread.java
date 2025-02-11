import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

class MyThread extends Thread {

    private int count;
    private int random;

    MyThread(Boolean count){
        int max = 100;
        random = random(max, count);
        System.out.println("MyThread created  count = " + count + " random = " + random);
    }


    public static int random(int max, boolean count) {
        int returnValue;
        if (count) {
            while (true) {
                returnValue = (int) (Math.random() * ++max);
                if (returnValue % 2 == 0) {
                    break;
                }
            }
        }else {
            while (true) {
                returnValue = (int) (Math.random() * ++max);
                if (returnValue % 2 != 0) {
                    break;
                }
            }
        }
        return returnValue;
    }




    private volatile boolean keepRunning = true;

    public void run() {
        String name = getName();
        try {
            System.out.println();
            PrintWriter pw = new PrintWriter(new FileWriter("x.txt"));
            int no = 0;
            for (; keepRunning; no++)
                pw.println(random);
            pw.close();
            System.out.println(name + ": written: " + no);
        } catch (IOException ex) {
            System.err.println("Failed: " + name);
        }
    }

    void scheduleStop() {
        keepRunning = false;
    }
}