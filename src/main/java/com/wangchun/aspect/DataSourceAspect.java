package com.wangchun.aspect;

import com.wangchun.config.DataSource;
import com.wangchun.util.DynamicDataSourceHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/8/27.
 */
public class DataSourceAspect {
    public void intercept(JoinPoint point) throws Exception {
        Class<?> target = point.getTarget().getClass();
        MethodSignature signature = (MethodSignature) point.getSignature();

        for (Class<?> clazz : target.getInterfaces()) {
            resolveDataSource(clazz, signature.getMethod());
        }
        resolveDataSource(target, signature.getMethod());
    }

    private void resolveDataSource(Class<?> clazz, Method method) {
        try {
            Class<?>[] types = method.getParameterTypes();
            if(clazz.isAnnotationPresent(DataSource.class)){
                DataSource source = clazz.getAnnotation(DataSource.class);
                DynamicDataSourceHolder.setDataSource(source.value());
            }


            Method m = clazz.getMethod(method.getName(), types);
            if(m!=null&&m.isAnnotationPresent(DataSource.class)){
                DataSource source = m.getAnnotation(DataSource.class);
                DynamicDataSourceHolder.setDataSource(source.value());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
