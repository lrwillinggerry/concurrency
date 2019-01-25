package com.mmall.concurrency.threadCase.rejectedExecution;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author rongjianrong
 * @date 2019-01-09
 */
public interface RejectedExecutionHandler {
    void rejectedExecution(Runnable r, ThreadPoolExecutor executor);
}
