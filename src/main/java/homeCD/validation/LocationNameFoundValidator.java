package homeCD.validation;

import homeCD.database.DAO.LocationDAO;
import homeCD.database.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LocationNameFoundValidator implements ConstraintValidator<LocationNameFound, String> {

    @Autowired
    private LocationDAO locationDAO;

    @Override
    public void initialize(LocationNameFound constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
        if (str.isEmpty()) {return true;}
        Location location = locationDAO.findByLocationName(str);
        return (location != null);

    }
}
