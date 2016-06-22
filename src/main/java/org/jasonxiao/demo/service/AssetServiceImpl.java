package org.jasonxiao.demo.service;

import org.jasonxiao.demo.model.Asset;
import org.jasonxiao.demo.task.RegisterAssetTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

/**
 * Created by Jason on 2/1/16.
 */
@Service
public class AssetServiceImpl implements AssetService {

    private static final Logger logger = LoggerFactory.getLogger(AssetServiceImpl.class);

    @Autowired private ThreadPoolTaskExecutor taskExecutor;

    @Override
    public void copy(String assetId) {

        System.out.println("active count is: " + taskExecutor.getActiveCount());
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

    @Override
    @Async
    public void register(RegisterAssetTask task) {
        task.run();
    }

    public int sum(int a, int b) {
        return a+b;
    }
}