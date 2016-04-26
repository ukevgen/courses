package useSwing.sortThread;

/**
 * Created by Администратор on 26.04.2016.
 */
public class Lock {
    private boolean wait;

    public Lock() {
        this.wait = false;
    }

    public boolean isWait() {
        return wait;
    }

    public void setWait(boolean wait) {
        this.wait = wait;
    }
}

