package com.aaa.springboothomestay.util;

import java.util.Map;

/**
 * 图像识别接口
 */
public interface BaseOCR {

    String APP_ID = "22132779";

    String API_KEY = "E14CqjpEiCiwqqu74RGpaO5l";

    String SECRET_KEY = "PgqkgcErhOAvN6kBViYVP8dwaHawewOv";

    Map<String, Object> discern(String imgUrl);
}
