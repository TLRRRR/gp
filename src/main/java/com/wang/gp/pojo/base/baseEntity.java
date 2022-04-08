package com.wang.gp.pojo.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class baseEntity<T> implements Serializable {

    private T data;
    private boolean success;
    private int code;
    private String error;

    /**
     *
     * @param t
     * @return
     */
    public static <T> baseEntity<T> success(T t) {
        baseEntity<T> base = new baseEntity<>();
        base.setData(t);
        base.setCode(200);
        base.setSuccess(true);
        return base;
    }

    public static <T> baseEntity<T> success1(T t) {
        baseEntity<T> base = new baseEntity<>();
        base.setData(t);
//        base.setCode(200);
//        base.setSuccess(true);
        return base;
    }


    public static <T> baseEntity<T> failed(String error) {
        return failed(66,error);
    }

    public static <T> baseEntity<T> failed(int code,String error) {
        baseEntity<T> base = new baseEntity<>();
        base.setCode(200);
        base.setData(null);
        base.setSuccess(false);
        base.setError(error);
        return base;
    }
}
