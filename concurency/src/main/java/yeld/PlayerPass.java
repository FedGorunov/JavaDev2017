package yeld;

/**
 * Created by Fedor on 24.09.2017.
 */
public class PlayerPass extends Thread {
    String name;

    public PlayerPass (String name){
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread.yield();
        System.out.println("Игрок пасует:" + name );
    }
}
