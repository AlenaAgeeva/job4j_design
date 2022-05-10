package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        boolean boo = true;
        char ch = 'a';
        byte b = 10;
        short s = 200;
        int i = 10000;
        float f = 1.5f;
        double d = 2.8;
        long l = 50L;
        LOG.debug("Boolean data type : {}, character data type : {}, "
                + "byte data type : {}, short data type : {}, "
                + "integer data type : {}, float data type : {}, "
                + "double data type : {}, long data type : {}", boo, ch, b, s, i, f, d, l);
    }
}
