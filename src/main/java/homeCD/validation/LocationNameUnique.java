package homeCD.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = LocationNameUniqueValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LocationNameUnique {

    String message() default "{LocationNameUnique}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
