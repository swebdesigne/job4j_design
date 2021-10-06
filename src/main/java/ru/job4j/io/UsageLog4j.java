package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        char tChar = 'A';
        boolean tBoolean = true;
        byte tByte = 127;
        short tShort = 32767;
        int tInt = 2147483647;
        long tLong = 2L;
        float tFloat = 45.6F;
        double tDouble = 7D;
        LOG.debug("Data type - char : {}, boolean : {}, byte : {}, short : {},"
                        + " int : {}, long : {}, float : {}, double : {}",
                tChar, tBoolean, tByte, tShort, tInt, tLong, tFloat, tDouble);
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
    }
}
