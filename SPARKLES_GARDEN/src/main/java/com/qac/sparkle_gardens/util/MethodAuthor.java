package com.qac.sparkle_gardens.util;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.RetentionPolicy.CLASS;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target ({METHOD, CONSTRUCTOR})
@Retention (CLASS)
@Documented
public @interface MethodAuthor 
{
	String author() default "Undefined";
}
