package com.slam.dunk.day04.createobj;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


/**
 * @Author: zerongliu
 * @Date: 4/1/20 15:53
 * @Description:
 */
public class FastPerson {
    private final Date birthDate;

    public FastPerson(Date birthDate) {
        this.birthDate = new Date(birthDate.getTime());
    }

    private static final Date Begin;
    //private static final Date End;

    static {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        cal.set(1990, Calendar.JANUARY, 1, 0, 0, 0);
        Begin = cal.getTime();
        //.....
    }


    public boolean is90s() {
        //compare begin and end
        //.....
        return false;
    }

}
