package org.jasonxiao.demo.service;

import org.jasonxiao.demo.task.RegisterAssetTask;

/**
 * Created by Jason on 2/1/16.
 */
public interface AssetService {

    void copy (String assetId);

    void deploy (String assetId);

    void undeploy (String assetId);

    void register(RegisterAssetTask task);

}
