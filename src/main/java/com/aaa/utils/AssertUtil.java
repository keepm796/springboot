package com.aaa.utils;


import com.aaa.exceptions.ParamsException;

import java.util.Date;

/**
 * @program: springboot
 * @description
 * @author: lc
 * @create: 2020-11-26 00:00
 **/
public class AssertUtil {
    /**
     * 判断结果是否为true 如果结果为true，抛出异常 断言
     * @param flag
     * @param msg
     */
    public static void isTrue(boolean flag,String msg){
        if (flag){
            throw new ParamsException(msg);
        }
    }
}
