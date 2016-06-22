package org.jasonxiao.demo.web.controller;

import org.jasonxiao.demo.model.Asset;
import org.jasonxiao.demo.service.AssetService;
import org.jasonxiao.demo.task.RegisterAssetTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;

/**
 * Created by Jason on 2/1/16.
 */

@RestController
public class AssetController {

    private static final Logger logger = LoggerFactory.getLogger(AssetController.class);

    @Autowired
    private AssetService assetService;

    private volatile int i;

    @RequestMapping(value = "/asset/{assetId}/copy", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String copyAsset(@PathVariable String assetId) {

        assetService.copy(String.valueOf(i));
        i++;

        return "OK";
    }

    @RequestMapping(value = "/asset/{assetId}/deploy", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String deployAsset(@PathVariable String assetId) {

        assetService.deploy(String.valueOf(i));
        i++;

        return "OK";
    }

    @RequestMapping(value = "/asset/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public DeferredResult<Asset> registerAsset(@RequestBody Asset asset) {
        DeferredResult<Asset> deferredResult = new DeferredResult<>();

        RegisterAssetTask task = new RegisterAssetTask(UUID.randomUUID().toString(), deferredResult, asset);
        assetService.register(task);

        logger.info(String.valueOf(deferredResult.hasResult()));
        deferredResult.onCompletion(() -> logger.info("complete"));



        return deferredResult;
    }

}
