package com.minisrm.admin.config;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@Configuration
public class FastjsonConfig {
    
    @Bean
    public HttpMessageConverter<?> fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteClassName,
                SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteDateUseDateFormat
        );
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
		fastJsonConfig.getSerializeConfig().put(Double.class, new ObjectSerializer() {
			
			@Override
			public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features)
			        throws IOException {
				SerializeWriter out = serializer.out;
	            if (object == null) {
	                out.writeNull(SerializerFeature.WriteNullNumberAsZero);
	                return;
	            }
	            if(object instanceof Double) {
	            	double doubleValue = ((Double) object).doubleValue();

		            if (Double.isNaN(doubleValue) //
		                || Double.isInfinite(doubleValue)) {
		                out.writeNull();
		            } else {
		                out.writeDouble(doubleValue, false);
		            }
	            }else if(object instanceof Long) {
	            	long value = ((Long) object).longValue();
                    out.writeLong(value);
	            }
			}
		});
		converter.setFastJsonConfig(fastJsonConfig);
        
        return converter;
    }
    

}
 