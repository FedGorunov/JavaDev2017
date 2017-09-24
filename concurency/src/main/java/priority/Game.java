package priority;

/**
 * Created by Fedor on 24.09.2017.
 */
public class Game {
    public   static int count;

    public static void main(String[] args) {


        for (int i = 0; i < 10; i++) {

            Player player1 = new Player("Player1");
            Player player2 = new Player("Player2");
            Player player3 = new Player("Player3");
            Player player4 = new Player("Player4");

            player1.setPriority(Thread.MIN_PRIORITY);
            player2.setPriority(Thread.NORM_PRIORITY);
            player3.setPriority(Thread.MAX_PRIORITY);
            player4.setPriority(3);

            player1.start();
           //player2.start();
            player3.start();
           // player4.start();

        }
    }
}
