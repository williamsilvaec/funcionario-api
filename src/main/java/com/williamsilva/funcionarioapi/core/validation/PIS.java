package com.williamsilva.funcionarioapi.core.validation;


import jakarta.validation.Constraint;
import jakarta.validation.OverridesAttribute;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = {})
@Pattern(regexp = "(\\d{11})?")
public @interface PIS {

    @OverridesAttribute(constraint = Pattern.class, name = "message")
    String message() default "{com.williamsilva.constraints.SKU.message}";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
