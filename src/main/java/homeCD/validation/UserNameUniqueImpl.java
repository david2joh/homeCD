package homeCD.validation;

import homeCD.database.DAO.UserDAO;
import homeCD.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserNameUniqueImpl implements ConstraintValidator<UserNameUnique, String> {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void initialize(UserNameUnique constraintAnnotation) {
    }

    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
        if (str.isEmpty()) {return true;}
        User user = userDAO.findByUserName(str);
        return (user == null);
    }





}
