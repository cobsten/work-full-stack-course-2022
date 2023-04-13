package com.ats.project.monolith.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ScheduleConstraint {
    String message() default "Invalid schedule time values";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
