package org.jasonxiao.demo.service;

import org.jasonxiao.demo.model.Asset;
import org.jasonxiao.demo.task.RegisterAssetTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by Jason on 2/1/16.
 */
@Service
public class AssetServiceImpl implements AssetService {

    private static final Logger logger = LoggerFactory.getLogger(AssetServiceImpl.class);

    private final ThreadPoolTaskExecutor taskExecutor;

    @Autowired
    public AssetServiceImpl(ThreadPoolTaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    @Override
    public void copy(String assetId) {

        logger.info("active count is: " + taskExecutor.getActiveCount());
        taskExecutor.submit(() -> {
            logger.info("start copying asset {}...", assetId);
            Thread.sleep(10000);
            return null;
        });

    }

    @Async
    @Override
    public void deploy(String assetId) {
        System.out.println("active count is: " + taskExecutor.getActiveCount());
        logger.info("start deploying asset {}...", assetId);
        //Thread.sleep(10000);
    }

    @Override
    public void undeploy(String assetId) {

    }

//    @Async
    @Override
    public void register(Asset asset, DeferredResult<Asset> deferredResult) throws ExecutionException, InterruptedException {
        RegisterAssetTask registerAssetTask = new RegisterAssetTask(asset);
        Future<Asset> future = taskExecutor.submit(registerAssetTask);
        logger.info("Set deferred result");
        deferredResult.setResult(future.get());
    }

    public int sum(int a, int b) {
        return a+b;
    }
}
