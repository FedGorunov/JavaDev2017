package yeld;



/**
 * Created by Fedor on 24.09.2017.
 */
public class Player extends Thread {


        String name;

        public Player (String name){
            this.name = name;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Игрок ходит:" + name );
        }

}
