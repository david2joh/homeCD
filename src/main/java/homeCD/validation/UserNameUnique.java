package homeCD.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UserNameUniqueImpl.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserNameUnique {

    String message() default "{UserEmailUnique}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
