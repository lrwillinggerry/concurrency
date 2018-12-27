package com.mmall.concurrency.threadCase;

/**
 * @author rongjianrong
 * @date 2018-12-15
 */
public enum State {
    NEW,
    RUNNABLE,
    BLOCKED,
    WAITING,
    TIMED_WAITING,
    TERMINATED
}
