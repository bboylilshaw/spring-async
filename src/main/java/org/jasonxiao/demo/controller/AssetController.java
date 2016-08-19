package org.jasonxiao.demo.controller;

import org.jasonxiao.demo.model.Asset;
import org.jasonxiao.demo.service.AssetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author Jason Xiao
 */
@RestController
@RequestMapping("/api")
public class AssetController {

    private static final Logger logger = LoggerFactory.getLogger(AssetController.class);

    private final AssetService assetService;

    @Autowired
    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @RequestMapping(value = "/asset/{assetId}/copy", method = RequestMethod.POST)
    public ResponseEntity.BodyBuilder copyAsset(@PathVariable("assetId") String assetId) {

        assetService.copy(assetId);

        return ResponseEntity.accepted();
    }

    @RequestMapping(value = "/asset/{assetId}/deploy", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deployAsset(@PathVariable String assetId) {

        assetService.deploy(assetId);

        return "OK";
    }

    @RequestMapping(value = "/asset/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public DeferredResult<Asset> registerAsset(@RequestBody Asset asset) throws Exception {
        DeferredResult<Asset> deferredResult = new DeferredResult<>();
        assetService.register(asset, deferredResult);

        deferredResult.onCompletion(() -> logger.info("deferred result complete"));

        return deferredResult;
    }

}
