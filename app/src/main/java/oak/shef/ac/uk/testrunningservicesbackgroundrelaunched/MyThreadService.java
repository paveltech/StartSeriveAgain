package oak.shef.ac.uk.testrunningservicesbackgroundrelaunched;

import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class MyThreadService extends Thread {

    public int counter=0;
    private Timer timer;
    private TimerTask timerTask;
    long oldTime=0;

    @Override
    public void run() {
        super.run();
    }


    public void startTimer() {
        //set a new Timer
        timer = new Timer();

        //initialize the TimerTask's job
        initializeTimerTask();

        //schedule the timer, to wake up every 1 second
        timer.schedule(timerTask, 1000, 1000); //
    }


    public void initializeTimerTask() {
        timerTask = new TimerTask() {
            public void run() {
                Log.i("in timer", "in timer ++++  "+ (counter++));
            }
        };
    }

    /**
     * not needed
     */
    public void stoptimertask() {
        //stop the timer, if it's not already null
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }
}
