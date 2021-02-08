package com.github.vlsidlyarevich.pepeserver.config.annotations;

import com.github.vlsidlyarevich.pepeserver.config.annotations.support.AnnotationReflectionRuntimeSupport;
import com.github.vlsidlyarevich.pepeserver.web.rest.annotations.ApiVersion;
import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;
import java.util.regex.Pattern;

/**
 * {@link ApiVersion} annotation {@link BeanPostProcessor}.
 * This BPP is only can be applied to {@link RestController} annotated classes, otherwise {@link BeanInstantiationException}
 * occurs.
 *
 * @author Vladislav Sidlyarevich <vlsidlyarevich@gmail.com>
 * Created on 2/2/21.
 */
@Component
public class ApiVersionAnnotationBeanPostProcessor implements BeanPostProcessor {

    private static final String VERSION_REGEXP = "\\/v\\d+\\/";

    private static final String VERSION_PATTERN = "/v%d/";

    @Override
    public Object postProcessBeforeInitialization(final Object bean, final String beanName) throws BeansException {
        if (!bean.getClass().isAnnotationPresent(ApiVersion.class)) return bean;
        if (!bean.getClass().isAnnotationPresent(RestController.class)) {
            throw new BeanInstantiationException(bean.getClass(),
                    "@ApiVersion annotation is only applicable to @Controller beans");
        }

        return processAnnotation(bean.getClass().getAnnotation(ApiVersion.class), bean);
    }

    private Object processAnnotation(ApiVersion apiVersion, Object bean) {
        String actualPath = bean.getClass().getAnnotation(RestController.class).value();
        if (isVersionedPath(actualPath)) return bean;

        String pathWithVersion = generatePath(actualPath, apiVersion.version());

        AnnotationReflectionRuntimeSupport.updateAnnotationValue(RestController.class, new Controller() {

            @Override
            public Class<? extends Annotation> annotationType() {
                return RestController.class;
            }

            @Override
            public String value() {
                return pathWithVersion;
            }
        }, bean);

        return bean;
    }

    private boolean isVersionedPath(String actual) {
        return (Pattern.compile(VERSION_REGEXP).matcher(actual).find());
    }

    private String generatePath(String actual, Integer version) {
        return String.format(VERSION_PATTERN, version).concat(actual).replace("//", "/");
    }
}
