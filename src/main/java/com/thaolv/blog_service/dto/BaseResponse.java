package com.thaolv.blog_service.dto;

import com.thaolv.blog_service.common.Constants;
import lombok.Data;

@Data
public class BaseResponse<T> {
    private String code;
    private String message;
    private T data;

    public BaseResponse() {
        setStatus(Constants.ERROR_CODE);
    }

    public void setStatus(String code) {
        this.code = code;
        switch (code) {
            case Constants.SUCCESS_CODE:
                this.message = "Success!";
                break;
            case Constants.ERROR_AUTHENTICATION:
                this.message = "Authentication fail!";
                break;
            default :
                this.message = "Server error!";
        }
    }

}
