package com.speaking.clock.controller;

import com.speaking.clock.service.TimeConvertService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Time Conversion API")
@RequestMapping("/api/v1")
public class TimeConvertController {

    private static  final Logger logger= LoggerFactory.getLogger(TimeConvertService.class);
  
    @Autowired
    private TimeConvertService timeConvertService;

    @GetMapping("/convertWord")
    @ApiOperation(value = "Convert current time to words", notes = "Converts current time into words")
    public String convertCurrentTimeToWord()
    {
        return timeConvertService.convertCurrentTimeToWord();
    }

    @GetMapping("/convertTime")
    @ApiOperation(value = "Convert time to words", notes = "Converts time to 'It's Midday' or 'It's Midnight' based on input.")
    public String convertTimeToWords(@RequestParam String time) {
        String response;
        try {
            response = timeConvertService.convertTime(time);
        } catch (Exception ex) {
            logger.error("[TimeConvertController] [convertTimeToWords] Exception: {}",ex);
            return "Some error occurred while processing your request";
        }
        return response;
    }
}