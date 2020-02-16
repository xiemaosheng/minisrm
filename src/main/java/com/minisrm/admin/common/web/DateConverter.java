package com.minisrm.admin.common.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String,Date> {
	
	private static final Logger LOG = LoggerFactory.getLogger(DateConverter.class);

	@Override
	public Date convert(String source) {
		Date date = null;
		try {
			SimpleDateFormat sdf = DateType.getFormat(source);
			date = sdf.parse(source);
		} catch (Exception e) {
			LOG.error("日期转换失败", e.fillInStackTrace());
		}
		
		return date;
	}
	
	enum DateType{
		
		yyyy_MM_dd_HH_mm(Pattern.compile("^\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}$"), "yyyy-MM-dd HH:mm")
		;
		
		Pattern regex;
		
		String pattern;
		
		private DateType(Pattern regex, String pattern) {
			this.regex = regex;
			this.pattern = pattern;
		}

		public Pattern getRegex() {
			return regex;
		}

		public String getPattern() {
			return pattern;
		}

		public static SimpleDateFormat getFormat(String source) {
			for(DateType dateType : DateType.values()) {
				Matcher m = dateType.getRegex().matcher(source);
				if(m.find()) {
					return new SimpleDateFormat(dateType.getPattern());
				}
			}
			throw new RuntimeException("format is not supported");
		}
		
	}


}
