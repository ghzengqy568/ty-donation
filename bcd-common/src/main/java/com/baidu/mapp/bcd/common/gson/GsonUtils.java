/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.common.gson;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class GsonUtils {

    private static final Gson GSON = GsonFactory.createGson();

    public static JsonElement getJsonObject(JsonElement object, String... path) {

        if (path == null || path.length == 0) {
            return null;
        }

        for (String p : path) {
            if (object == null) {
                return null;
            }
            if (object instanceof JsonPrimitive) {
                return object;
            } else if (object instanceof JsonObject) {
                object = ((JsonObject) object).get(p);
            }
        }
        return object;
    }

    public static JsonArray getJsonArray(JsonObject object, String... path) {
        if (path == null || path.length == 0) {
            return null;
        }

        for (int i = 0; i < path.length - 1; i++) {
            if (object == null) {
                return null;
            }
            JsonElement jsonElement = object.get(path[i]);
            if (jsonElement == null || !jsonElement.isJsonObject()) {
                return null;
            }
            object = jsonElement.getAsJsonObject();
        }

        if (object == null) {
            return null;
        }
        JsonElement jsonElement = object.get(path[path.length - 1]);
        if (jsonElement == null || !jsonElement.isJsonArray()) {
            return null;
        }
        return jsonElement.getAsJsonArray();
    }

    public static JsonObject toJsonObject(String json) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        JsonObject jsonObject = null;
        try {
            jsonObject = GSON.fromJson(json, JsonObject.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static JsonArray toJsonArray(String json) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        JsonArray jsonArray = null;
        try {
            jsonArray = GSON.fromJson(json, JsonArray.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (jsonArray == null) {
            return new JsonArray(0);
        }
        return jsonArray;
    }

    public static <T> T toObject(String json, Class<T> cls) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        T t = null;
        try {
            t = GSON.fromJson(json, cls);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public static <T> T toObject(byte[] json, Class<T> cls) {
        if (json == null || json.length == 0) {
            return null;
        }
        T t = null;
        try {
            t = GSON.fromJson(new String(json), cls);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public static JsonElement toJsonElement(String json) {
        JsonElement element = null;
        if (StringUtils.isBlank(json)) {
            element = JsonNull.INSTANCE;
        } else {
            try {
                element = GSON.fromJson(json, JsonElement.class);
            } catch (Exception ex) {
                element = new JsonPrimitive(json);
            }

            if (element == null) {
                element = new JsonPrimitive(json);
            }
        }
        return element;
    }

    public static <T> T toObject(JsonElement json, Class<T> cls) {
        if (json == null) {
            return null;
        }
        T t = null;
        try {
            t = GSON.fromJson(json, cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public static String getStringOrDefault(JsonElement object, String defaultValue, String... path) {
        JsonElement jsonObject = getJsonObject(object, path);
        if (jsonObject == null || jsonObject.isJsonNull() || !jsonObject.isJsonPrimitive()) {
            return defaultValue;
        }
        return jsonObject.getAsString();
    }

    public static Integer getIntegerOrDefault(JsonElement object, Integer defaultValue, String... path) {
        JsonElement jsonObject = getJsonObject(object, path);
        if (jsonObject == null || jsonObject.isJsonNull() || !jsonObject.isJsonPrimitive()) {
            return defaultValue;
        }
        Integer result = defaultValue;
        try {
            result = jsonObject.getAsInt();
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static Long getLongOrDefault(JsonElement object, Long defaultValue, String... path) {
        JsonElement jsonObject = getJsonObject(object, path);
        if (jsonObject == null || jsonObject.isJsonNull() || !jsonObject.isJsonPrimitive()) {
            return defaultValue;
        }
        Long result = defaultValue;
        try {
            result = jsonObject.getAsLong();
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static Double getDoubleOrDefault(JsonElement object, Double defaultValue, String... path) {
        JsonElement jsonObject = getJsonObject(object, path);
        if (jsonObject == null || jsonObject.isJsonNull() || !jsonObject.isJsonPrimitive()) {
            return defaultValue;
        }
        Double result = defaultValue;
        try {
            result = jsonObject.getAsDouble();
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static JsonElement getJsonElement(JsonObject object, String... path) {
        if (path == null || path.length == 0 || object == null) {
            return null;
        }
        JsonObject tmpJsonObject = object;
        for (int i = 0; i < path.length - 1; i++) {
            if (object == null) {
                return null;
            }
            JsonElement jsonElement = tmpJsonObject.get(path[i]);
            if (jsonElement == null || !jsonElement.isJsonObject()) {
                return null;
            }
            tmpJsonObject = jsonElement.getAsJsonObject();
        }

        if (tmpJsonObject == null) {
            return null;
        }
        return tmpJsonObject.get(path[path.length - 1]);
    }

    public static void removeJsonPropertiesProperties(JsonObject jsonObject, String... property) {
        if (jsonObject == null || property == null || property.length <= 0) {
            return;
        }

        for (String p : property) {
            if (jsonObject.has(p)) {
                jsonObject.remove(p);
            }
        }
    }

    /**
     * 任何对象转string
     *
     * @param object
     *
     * @return
     */
    public static String toJsonString(Object object) {
        return GSON.toJson(object);
    }

    public static byte[] toJsonBytes(Object object) {
        String s = toJsonString(object);
        if (s == null) {
            return null;
        }
        return s.getBytes();
    }
    /**
     * @param json list的序列化字符串
     * @param <T>  T类型
     *
     * @return List<T>
     */
    public static <T> List<T> toList(String json, Class<T> clazz) {
        return GSON.fromJson(json, TypeToken.getParameterized(List.class, clazz).getType());
    }
}
