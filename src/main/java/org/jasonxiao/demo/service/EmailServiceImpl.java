package org.jasonxiao.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author Jason Xiao
 */
@Service
public class EmailServiceImpl implements EmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Override
    public Boolean send(Object obj) {
        LOGGER.info("send email...");

        // Simulate method execution time
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            // do nothing
        }

        LOGGER.info("done sending email!");
        return Boolean.TRUE;
    }

    @Async
    @Override
    public void sendAsync(Object obj) {
        LOGGER.info("send email asynchronously...");

        // Simulate method execution time
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            // do nothing
        }

        LOGGER.info("done sending email!");
    }

    @Async
    @Override
    public Future<Boolean> sendAsyncWithResult(Object obj) {
        LOGGER.info("send email asynchronously with result");

        // Simulate method execution time
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            // do nothing
        }

        LOGGER.info("done sending email!");

        return new AsyncResult<>(Boolean.TRUE);
    }
}
