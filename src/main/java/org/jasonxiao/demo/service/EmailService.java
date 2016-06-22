package org.jasonxiao.demo.service;

import java.util.concurrent.Future;

/**
 * Created by Jason on 1/11/16.
 */
public interface EmailService {

    Boolean send(Object obj);

    void sendAsync(Object obj);

    Future<Boolean> sendAsyncWithResult(Object obj);
}
