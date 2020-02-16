package com.minisrm.admin.common.page;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.util.StringUtils;

import java.util.HashMap;

public class QueryMap<T> extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public static final String PAGE = "page";

    public static final String ENTITY = "entity";

    public static final String TYPE = "@type";

    public QueryMap<T> setPage(PageModel page) {
        return setObject(PAGE, page);
    }

    public QueryMap<T> setEntity(T t) {
        return setObject(ENTITY, t);
    }

    private QueryMap<T> setObject(String key, Object value) {
        if (value != null) {
            put(key, value);
        }
        return this;
    }

    public PageModel getPage() {
        return (PageModel) getObject(PAGE, PageModel.class);
    }

    @SuppressWarnings("unchecked")
    public T getEntity() {
        Object obj = get(ENTITY);

        if (!containsKey(TYPE)) {
            return (T) obj;
        }

        String type = null;
        try {
            if (obj != null) {
                type = (String) ((HashMap<?, ?>) obj).get(TYPE);
                if (StringUtils.isEmpty(type)) {
                    throw new Exception("type is null");
                }
                Class<?> clazz = Class.forName(type);
                return getObject(ENTITY, clazz);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public T getModel() {
        return (T) get(ENTITY);
    }

    @SuppressWarnings("unchecked")
    private T getObject(String key, Class<?> clazz) {
        if (!containsKey(key)) {
            return null;
        }
        Object pageObject = get(key);
        String jsonStr = JSON.toJSONStringWithDateFormat(pageObject, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteClassName);
        return (T) JSON.parseObject(jsonStr, clazz, Feature.DisableSpecialKeyDetect);
    }

}
