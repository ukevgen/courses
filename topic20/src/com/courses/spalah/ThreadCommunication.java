package com.courses.spalah;

/**
 * @author Ievgen Tararaka
 */
public class ThreadCommunication {
    public static void main(String[] args) {

    }
}

class Signal {
    private boolean workDone;

    public synchronized boolean isWorkDone() {
        return workDone;
    }

    public synchronized void setWorkDone(boolean workDone) {
        this.workDone = workDone;
    }
}

class SignalWorker implements Runnable {
    private Signal signal; // сигнал для общения между потоками

    @Override
    public void run() {
        while (!signal.isWorkDone()) {
            // ничего не делаем, но расходуем процессорное время =(
        }
    }
}