package com.baidu.mapp.bcd.common.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 个人关键信息脱敏
 */
public class MaskUtils {

    public static final String ANONYMITY_PREFIX = "雷锋";

    public static final char MASK = '*';

    /**
     * 捐赠人名称脱敏
     */
    public static String maskDonorName(String name) {
        if (StringUtils.isEmpty(name)) {
            return name;
        }

        if (name.startsWith(ANONYMITY_PREFIX)) {
            return name;
        } else {
            return maskFromStart(name, 1);
        }
    }

    /**
     * 身份证号脱敏
     */
    public static String maskIdCard(String idCard) {
        if (StringUtils.isEmpty(idCard)) {
            return StringUtils.EMPTY;
        }
        return maskFromStart(idCard, idCard.length() - 4);
    }

    /**
     * 手机号脱敏
     */
    public static String maskCellPhone(String phone) {
        if (StringUtils.isEmpty(phone)) {
            return StringUtils.EMPTY;
        }
        return maskFromTo(phone, 3, 6);
    }


    private static String maskFromTo(String string, int start, int end) {
        if (start < 0 || start > string.length() - 1
                || end < 0 || end > string.length() - 1
                || start > end) {
            return string;
        }

        char[] charArray = string.toCharArray();
        for (int i = start; i <= end; i ++) {
            charArray[i] = MASK;
        }
        return new String(charArray);
    }

    private static String maskFromStart(String string, int start) {
        if (start < 0 || start > string.length() - 1) {
            return string;
        }

        char[] charArray = string.toCharArray();
        for (int i = start; i < string.length(); i ++) {
            charArray[i] = MASK;
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        String name = "雷锋0928";
        System.out.println(maskDonorName(name));
        name = "张张";
        System.out.println(maskDonorName(name));

        String idCard = "142729187789561426";
        System.out.println(idCard);
        System.out.println(maskFromStart(idCard, idCard.length() - 4));

        String phone = "15902182446";
        System.out.println(phone);
        System.out.println(maskFromTo(phone, 3, 6));
    }

}
