package yeld;

/**
 * Created by Fedor on 24.09.2017.
 */
public class YeldMain {


    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

            Player player1 = new Player("Player1");
            PlayerPass player2 = new PlayerPass("Player2");
            Player player3 = new Player("Player3");
            Player player4 = new Player("Player4");

            player1.start();
            player2.start();
            player3.start();
            player4.start();

        }
    }



}
