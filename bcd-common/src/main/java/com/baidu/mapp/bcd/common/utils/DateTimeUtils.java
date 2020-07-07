/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.common.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeUtils {

    /**
     * 今天
     *
     * @return yyyy-MM-dd
     */
    public static Date today() {
        LocalDate today = LocalDate.now();
        return Date.from(today.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 昨天
     *
     * @return yyyy-MM-dd
     */
    public static Date yesterday() {
        LocalDate yesterday = LocalDate.now().plusDays(-1);
        return Date.from(yesterday.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 明天
     *
     * @return yyyy-MM-dd
     */
    public static Date tomorrow() {
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        return Date.from(tomorrow.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 转换日期
     */
    public static String toDateString(Date date, String... pattern) {
        if (date == null) {
            return "";
        }
        String p = pattern == null || pattern.length == 0 ? "yyyy-MM-dd" : pattern[0];
        LocalDate localDate = LocalDateTime.ofInstant(date.toInstant(), ZoneOffset.systemDefault()).toLocalDate();
        return localDate.format(DateTimeFormatter.ofPattern(p));
    }

    /**
     * 转换日期
     */
    public static String toDateTimeString(Date date, String... pattern) {
        if (date == null) {
            return "";
        }
        String p = pattern == null || pattern.length == 0 ? "yyyy-MM-dd HH:mm:ss" : pattern[0];
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneOffset.systemDefault());
        return localDateTime.format(DateTimeFormatter.ofPattern(p));
    }

    /**
     * 判断是否过期, 包括当天
     */
    public static boolean expireDate(Date date) {
        if (date == null) {
            return true;
        }
        LocalDate localDate = LocalDateTime.ofInstant(date.toInstant(), ZoneOffset.systemDefault()).toLocalDate();
        return localDate.isBefore(LocalDate.now());
    }


    public static void main(String[] args){
        System.out.println(expireDate(Date.from(LocalDate.now().plusDays(-1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())));
    }
}
