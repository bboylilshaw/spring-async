package org.jasonxiao.demo.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * Created by Jason on 2/4/16.
 */

public class AssetServiceImplTest {

    @InjectMocks
    AssetServiceImpl assetService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSum() throws Exception {
        int a = 1;
        int b = 1;
        int expected = 2;

        int result = assetService.sum(a, b);

        Assert.assertEquals(expected, result);
    }


    @Test
    public void testCopy() throws Exception {

    }

    @Test
    public void testDeploy() throws Exception {

    }

    @Test
    public void testUndeploy() throws Exception {

    }
}
