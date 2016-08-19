package org.jasonxiao.demo.service;

import java.util.concurrent.Future;

/**
 * @author Jason Xiao
 */
public interface EmailService {

    Boolean send(Object obj);

    void sendAsync(Object obj);

    Future<Boolean> sendAsyncWithResult(Object obj);
}
