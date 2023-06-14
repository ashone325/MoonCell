package com.example.util;

import java.io.Serializable;
import java.util.List;

/**
 * 返回结果集
 */
public class Result<T> implements Serializable {
    private int code;
    private String msg;
    private long count;
    private List<T> data;
    private T tdata;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public T getTdata() {
        return tdata;
    }

    public void setTdata(T tdata) {
        this.tdata = tdata;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

}
