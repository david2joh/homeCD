package homeCD.validation;

import homeCD.database.DAO.LocationDAO;
import homeCD.database.entity.Location;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
@Component
public class LocationNameFoundValidator implements ConstraintValidator<LocationNameFound, String> {

    @Autowired
    private LocationDAO locationDAO;

    @Override
    public void initialize(LocationNameFound constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
        if (str.isEmpty()) {
            return true;
        }
        Location location = locationDAO.findByLocationName(str);
        return (location != null);

    }
}
