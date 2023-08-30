package com.speaking.clock.service.impl;

import com.speaking.clock.service.TimeConvertService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TimeConvertServiceImpl implements TimeConvertService {


    private static final String[] ones = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] tens = {
            "", "", "twenty", "thirty", "forty", "fifty"
    };

    @Override
    public String convertTime(String time) throws Exception {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date date = sdf.parse(time);

            int hours = date.getHours();
            int minutes = date.getMinutes();

            if (hours <= 12 && minutes == 0) {
                return "It's Midday";
            } else if (hours == 0 && minutes == 0) {
                return "It's Midnight";
            } else {
                return "Regular time";
            }
        } catch (Exception e) {
            return "Invalid time format";
        }
    }

    @Override
    public String convertCurrentTimeToWord() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            String currentTime = sdf.format(new Date());
            Date date = sdf.parse(currentTime);

            int hours = date.getHours();
            int minutes = date.getMinutes();

            String timeInWords = "It's ";

            if (hours < 20) {
                timeInWords += ones[hours] + " ";
            } else {
                timeInWords += tens[hours / 10] + " " + ones[hours % 10] + " ";
            }

            if (minutes == 0) {
                timeInWords += "o'clock";
            } else if (minutes < 20) {
                timeInWords += ones[minutes] + " ";
            } else {
                timeInWords += tens[minutes / 10] + " " + ones[minutes % 10] + " ";
            }

            timeInWords += (minutes == 1) ? "minute" : "minutes";

            return timeInWords;
        } catch (Exception e) {
            return "Invalid time format";
        }
    }
}
