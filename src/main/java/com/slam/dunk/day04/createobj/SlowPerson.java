package com.slam.dunk.day04.createobj;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @Author: zerongliu
 * @Date: 4/1/20 15:53
 * @Description:
 */
public class SlowPerson {
    /**
     * birthday
     */
    private final Date birthDate;

    public SlowPerson(Date birthDate) {
        this.birthDate = new Date(birthDate.getTime());
    }

    public boolean is90s() {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        cal.set(1990, Calendar.JANUARY, 1, 0, 0, 0);
        Date begin = cal.getTime();
        //.....
        return false;
    }

}
