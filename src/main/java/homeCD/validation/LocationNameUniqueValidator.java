package homeCD.validation;

import homeCD.database.DAO.LocationDAO;
import homeCD.database.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LocationNameUniqueValidator implements ConstraintValidator<LocationNameUnique, String> {

    @Autowired
    private LocationDAO locationDAO;

    @Override
    public void initialize(LocationNameUnique constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
        if (str.isEmpty()) {return true;}
        Location location = locationDAO.findByLocationName(str);
        return (location == null);

    }
}
