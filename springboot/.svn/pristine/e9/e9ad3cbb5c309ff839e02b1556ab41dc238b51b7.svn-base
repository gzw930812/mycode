package com.cptech.common.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class DateConverConfig {
    @Bean
    public Converter<String, Date> stringDateConvert() {
        return new Converter<String, Date>() {
            @Override
            public Date convert(String source) {
            	if(StringUtils.isBlank(source)) return null;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = null;
                try {
                    date = sdf.parse((String) source);
                } catch (Exception e) {
                    SimpleDateFormat sdfday = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        date = sdfday.parse((String) source);
                    } catch (ParseException e1) {
                    	 SimpleDateFormat sdfMonth = new SimpleDateFormat("yyyy-MM");
                         try {
                             date = sdfMonth.parse((String) source);
                         } catch (ParseException e2) {
                             System.out.println("日期转换失败。。。。");
                         }
                    }
                }
                return date;
            }
        };
    }

}
