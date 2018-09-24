package com.doordash.discovery.doordashdiscovery.java;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.doordash.discovery.doordashdiscovery.R;
import com.doordash.discovery.doordashdiscovery.model.Restaurant;
import com.google.gson.Gson;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link Restaurant} object's model
 */
public class RestaurantModelTest {

    /**
     * Test method for valid response
     */
    @Test
    public void testValidResponse() {
        Context context = InstrumentationRegistry.getTargetContext();

        Gson gson = new Gson();
        JSONObject jsonObject = TestUtils.processJSON(R.raw.restaurant_response_valid, context);
        Restaurant result = gson.fromJson(jsonObject.toString(), Restaurant.class);
        Assert.assertNotNull(result);
        Assert.assertEquals("77", result.getId());
        Assert.assertEquals("Tsing Tao", result.getName());
        Assert.assertEquals("Chinese, Soup", result.getDescription());
        Assert.assertEquals("Closed", result.getStatus());
        Assert.assertEquals("500", result.getDeliveryFee());
    }
}
