package com.myz.analysis.managementanalysis.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Auther: mayanze
 * @Date: 2018/10/18 23:58
 * @Description:
 */
public class DateUtil {

    public static Date subMonth(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = sdf.parse(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date dt1 = calendar.getTime();
        return dt1;
    }

    public static void main(String[] args) {
        try {
            Date subMonth = subMonth("2019-08-01");
            System.out.println(subMonth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}


