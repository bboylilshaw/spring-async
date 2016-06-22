package org.jasonxiao.demo.task;

import org.jasonxiao.demo.model.Asset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;
import java.util.UUID;

public class RegisterAssetTask extends TimerTask {

    private static final Logger logger = LoggerFactory.getLogger(RegisterAssetTask.class);

    private String taskId;
    private DeferredResult<Asset> deferredResult;
    private Asset asset;

    public RegisterAssetTask() {
    }

    public RegisterAssetTask(String taskId, DeferredResult<Asset> deferredResult, Asset asset) {
        this.taskId = taskId;
        this.deferredResult = deferredResult;
        this.asset = asset;
    }

    @Override
    public void run() {
        logger.info("start task {}", taskId);
        if (deferredResult.isSetOrExpired()) {
            logger.warn("deferred result is set or expired");
        } else {
            logger.info("registering asset {}", asset.getId());

            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            logger.info("set deferred result");
            deferredResult.setResult(asset);

//            Map<String, String> result = new HashMap<>();
//            result.put("code", "1");
//            result.put("result", "ERROR");
//            deferredResult.setErrorResult(result);
        }
    }
}
