package org.jasonxiao.demo.service;

import org.jasonxiao.demo.model.Asset;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Jason Xiao
 */
public interface AssetService {

    void copy (String assetId);

    void deploy (String assetId);

    void undeploy (String assetId);

    void register(Asset asset, DeferredResult<Asset> deferredResult) throws ExecutionException, InterruptedException;

}
