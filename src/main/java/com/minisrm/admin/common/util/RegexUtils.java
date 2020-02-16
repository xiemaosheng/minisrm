package com.minisrm.admin.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {
    
    public static boolean match(String pattern, String str) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        return m.find();
    }

}
