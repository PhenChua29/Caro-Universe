import Frame.frame;

public class GameThread extends Thread {

    private frame Frame;

    @Override
    public void run() {
        try {
            Frame = new frame();
            for (;;) {
                // create an inf loop for checking state: new game, credit, quit. Then trigger
                // it using frame's method
                GameThread.sleep(500);
                if (frame.isStateChange()) {
                    Frame.switchPanel();
                }
            }
        } catch (Exception e) {
            System.out.println("Yo, something's wrong in GameThread");
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
