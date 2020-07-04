package com.whw.response;

import lombok.Data;

@Data
public final class ResponseData {

    private boolean error;
    private String message;
    private Object data;

    public static ResponseData success() {
        ResponseData responseData = new ResponseData();
        return responseData;
    }

    public static ResponseData success(String message, Object data) {
        ResponseData responseData = new ResponseData();
        responseData.setMessage(message);
        responseData.setData(data);
        return responseData;
    }

    public static ResponseData success(String message) {
        return success(message, null);
    }

    public static ResponseData success(Object data) {
        return success(null, data);
    }


    public static ResponseData error(String message, Object data) {
        ResponseData responseData = new ResponseData();
        responseData.setError(true);
        responseData.setMessage(message);
        responseData.setData(data);
        return responseData;
    }

    public static ResponseData error(String message) {
        return error(message, null);
    }

    public static ResponseData error(Object data) {
        return error(null, data);
    }
}
