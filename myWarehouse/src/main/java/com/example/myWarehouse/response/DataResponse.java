package com.example.myWarehouse.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataResponse<T> extends BaseResponse{
    private T data;

    public DataResponse(boolean success, String message, T data){
        super(success, message);
        this.data = data;
    }
}
