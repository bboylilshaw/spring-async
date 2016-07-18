package org.jasonxiao.demo.task;

import org.jasonxiao.demo.model.Asset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;
import java.util.concurrent.Callable;

public class RegisterAssetTask implements Callable<Asset> {

    private static final Logger logger = LoggerFactory.getLogger(RegisterAssetTask.class);

    private Asset asset;

    public RegisterAssetTask(Asset asset) {
        this.asset = asset;
    }

    @Override
    public Asset call() {
        logger.info("Start to run register asset task");
        // pretending doing the work
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Finished register asset task");

        asset.setId(UUID.randomUUID().toString());
        return asset;
    }
}
