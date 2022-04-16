package homeCD.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = LocationNameFoundValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface  LocationNameFound {

    String message() default "{ LocationNameFound}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
