import java.io.*;

class MyThreadReader extends Thread {

    private int count;
    private int random;

    MyThreadReader(){
        int max = 100;
        System.out.println("MyThread reader created");
    }






    private volatile boolean keepRunningReader = true;


    public void run() {
        String name = getName();

        System.out.println("Start");

        String fileName = "x.txt";

        try (BufferedReader br =
                     new BufferedReader(
                             new InputStreamReader(
                                     new FileInputStream(new File(fileName))))) {

            String line;
            while (keepRunningReader) {
                System.out.println(br.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


            System.out.println("End");


    }

    void scheduleStop() {
        keepRunningReader = false;
    }
}