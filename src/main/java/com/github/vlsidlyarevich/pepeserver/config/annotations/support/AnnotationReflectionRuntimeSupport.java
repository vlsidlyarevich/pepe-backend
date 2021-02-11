package com.github.vlsidlyarevich.pepeserver.config.annotations.support;

import lombok.experimental.UtilityClass;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Support class for runtime manipulating annotations at runtime.
 *
 * @author Vladislav Sidlyarevich <vlsidlyarevich@gmail.com> Created on 2/6/21.
 */
@UtilityClass
public class AnnotationReflectionRuntimeSupport {

    private static final String ANNOTATION_DATA_INTERNAL_METHOD_NAME = "annotationData";
    private static final String ANNOTATIONS_INTERNAL_FIELD_NAME = "annotations";

    /**
     * Replace {@code annotation} of {@code annotationClass} on {@code annotatedObject}.
     * Note that it only works since JDK8 because of changing annotations implementation.
     *
     * @param annotationClass the annotation class to replace
     * @param replacement     the replacement annotation
     * @param annotatedObject the annotated object
     *
     * @throws IllegalArgumentException if the underlying reflection methods throws exception.
     */
    public static void updateAnnotationValue(Class<? extends Annotation> annotationClass,
                                             Annotation replacement,
                                             Object annotatedObject) {

        try {
            Method annotationDataMethod = Class.class.getDeclaredMethod(ANNOTATION_DATA_INTERNAL_METHOD_NAME);
            annotationDataMethod.setAccessible(true);
            Object nestedAnnotationData = annotationDataMethod.invoke(annotatedObject.getClass());

            Field annotationsField = nestedAnnotationData.getClass().getDeclaredField(ANNOTATIONS_INTERNAL_FIELD_NAME);
            annotationsField.setAccessible(true);

            final Map<Class<? extends Annotation>, Annotation> annotationsMap
                    = (Map<Class<? extends Annotation>, Annotation>) annotationsField.get(nestedAnnotationData);
            annotationsMap.put(annotationClass, replacement);
        } catch (NoSuchMethodException
                | IllegalAccessException
                | InvocationTargetException
                | NoSuchFieldException e) {
            throw new IllegalArgumentException("Could not update annotation", e);
        }
    }
}
