package com.github.vlsidlyarevich.pepeserver.config.annotations.support;

import lombok.experimental.UtilityClass;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * AnnotationReflectionRuntimeSupport
 *
 * @author Vladislav Sidlyarevich <vlsidlyarevich@gmail.com>
 * Created on 2/6/21.
 */
@UtilityClass
public class AnnotationReflectionRuntimeSupport {

    public static void updateAnnotationValue(Class<? extends Annotation> annotationClass,
                                             Annotation replacement,
                                             Object annotatedObject) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        String const1 = "annotationData";
        String const2 = "annotations";


        Method annotationDataMethod = annotatedObject.getClass().getMethod(const1, null);
        annotationDataMethod.setAccessible(true);
        Object nestedAnnotationData = annotationDataMethod.invoke(annotatedObject);

        Field annotationsField = nestedAnnotationData.getClass().getField(const2);
        annotationsField.setAccessible(true);

        final Map<Class<? extends Annotation>, Annotation> annotationsMap = (Map<Class<? extends Annotation>, Annotation>) annotationsField.get(nestedAnnotationData);
        annotationsMap.put(annotationClass, replacement);
    }
}
