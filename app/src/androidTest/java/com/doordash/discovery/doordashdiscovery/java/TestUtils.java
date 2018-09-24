package com.doordash.discovery.doordashdiscovery.java;

import android.content.Context;
import android.content.res.Resources;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Utils class for test classes
 */
public class TestUtils {

    public static JSONObject processJSON(int resource, Context context) throws IllegalStateException {
        InputStreamReader reader = null;
        JSONObject value = null;
        try {
            reader = getJSONStreamReader(resource, context);
            JsonElement elem = new JsonParser().parse(reader);
            String data = elem.getAsJsonObject().toString();
            value = new JSONObject(data);
        } catch (IOException | JSONException e) {
            throw new IllegalStateException("Unable to parse and attain activity item objects from local mock data");
        } finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }

    private static InputStreamReader getJSONStreamReader(int resource, Context context) throws IOException {
        InputStream in;
        try {
            in = context.getResources().openRawResource(resource);
        } catch (Resources.NotFoundException e) {
            throw new IOException("Unable to find resource json file");
        }
        return new InputStreamReader(in);
    }
}
