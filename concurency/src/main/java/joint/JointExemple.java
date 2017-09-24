package joint;

/**
 * Created by Fedor on 24.09.2017.
 */
public class JointExemple {


        static String message;

        private static class CorrectorThread
                extends Thread {

            public void run() {
                message = "Помиловать";
            }
        }

        public static void main(String args[]) throws InterruptedException {

            for (int i=0; i<1000; i++) {
                CorrectorThread correctorThread = new CorrectorThread();

                message = "Казнить";
                correctorThread.start();
               Thread.sleep(10);
               //50 mSec не достаточно
                //correctorThread.join(50);

                // 0,5 секунды ожидания достаточно чтобы корректор успевал
                correctorThread.join(500);

                if (message.equalsIgnoreCase("Казнить"))
                    System.out.println(message);
            }
        }

}
