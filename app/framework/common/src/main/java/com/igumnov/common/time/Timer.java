package com.igumnov.common.time;

import com.igumnov.common.time.TimeException;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Timer {

    private long startValue = 0;
    private long accamulator = 0;
    private long repeatCount = 0;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void start() throws TimeException {
        try {
            lock.writeLock().lock();
            if (startValue != 0) {
                resetValues();
                throw new TimeException("stop should be call before");
            }
            startValue = System.nanoTime();
            repeatCount++;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public long stop() throws TimeException {
        try {
            lock.writeLock().lock();

            if (startValue == 0) {
                throw new TimeException("startProcedure should be call before");
            }
            long timerStartValueOld = startValue;
            long timerAccamulatorOld = accamulator;
            resetValues();
            return TimeUnit.MILLISECONDS.convert(System.nanoTime() - timerStartValueOld + timerAccamulatorOld, TimeUnit.NANOSECONDS);
        } finally {
            lock.writeLock().unlock();
        }

    }

    private void resetValues() {
        try {
            lock.writeLock().lock();
            startValue = 0;
            accamulator = 0;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public long pause() throws TimeException {
        try {
            lock.writeLock().lock();
            if (startValue == 0 && accamulator == 0) {
                resetValues();
                throw new TimeException("startProcedure should be call before");
            }
            long timerStartValueOld = startValue;
            startValue = 0;
            accamulator += System.nanoTime() - timerStartValueOld;
            return TimeUnit.MILLISECONDS.convert(accamulator, TimeUnit.NANOSECONDS);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void resume() throws TimeException {
        try {
            lock.writeLock().lock();
            if (startValue == 0 && accamulator == 0) {
                throw new TimeException("startProcedure should be call before");
            }
            if (startValue != 0 && accamulator == 0) {
                throw new TimeException("pause should be call before");
            }
            startValue = System.nanoTime();
            repeatCount++;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public long getRepeatCount() {
        try {
            lock.readLock().lock();
            return repeatCount;
        } finally {
            lock.readLock().unlock();
        }
    }
    public long getTotlaTime() {
        try {
            lock.readLock().lock();
            return TimeUnit.MILLISECONDS.convert(accamulator, TimeUnit.NANOSECONDS);
        } finally {
            lock.readLock().unlock();
        }
    }

    public long getAverageTime() {
        try {
            lock.readLock().lock();
            return TimeUnit.MILLISECONDS.convert(accamulator / repeatCount, TimeUnit.NANOSECONDS);
        } finally {
            lock.readLock().unlock();
        }
    }

}