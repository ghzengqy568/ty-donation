/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.service;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.baidu.mapp.bcd.common.utils.digest.Digest;

public class CertServiceTest {

    public String placeHolder(String content, Map<String, String> map) {
        if (content == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        char[] a = content.toCharArray();
        int len = a.length;
        int start = 0;
        int end = 0;
        while (start < len) {
            int begin = -1;
            while (start+1 < len && (a[start] != '$' || a[start+1] != '{' )) {
                start ++;
            }
            if (start+1 < len && a[start+1] == '{') {
                begin = start;
                start ++;
            }
            while (start < len && a[start] != '}') {
                start ++;
            }
            if (begin == -1) {
                // 没有找到
                sb.append(a, end, len - end);
                return sb.toString();
            }
            if (start < len) {
                String key = new String(a, begin + 2, start - begin - 2);
                if (key != null) {
                    key = key.trim();
                    if (map.containsKey(key)) {
                        String value = map.get(key);
                        sb.append(a, end, begin - end);
                        sb.append(value);
                    } else {
                        sb.append(a, end, start - end + 1);
                    }
                    end = start + 1;
                }
            } else {
                sb.append(a, end, len - end);
                return sb.toString();
            }

            start ++;
        }

        return sb.toString();
    }

    Pattern p =  Pattern.compile("\\$\\{\\w+\\}");
    public String processTemplate(String template, Map<String, String> params) {
        if (template == null || params == null)
            return null;
        StringBuffer sb = new StringBuffer();
        Matcher m = p.matcher(template);
        while (m.find()) {
            String param = m.group();
            Object value = params.get(param.substring(2, param.length() - 1));
            m.appendReplacement(sb, value == null ? "" : value.toString());
        }
        m.appendTail(sb);
        return sb.toString();
    }


    @Test
    public void testSha1() throws Exception {
        Digest in = Digest.getInstance("donate0192837465");
        String s = in.encryptDes("18756623882");

        System.out.println("encryptDes:" + s);

        String s1 = in.decryptDes(s);
        System.out.println("decryptDes: " + s1);

    }

}

