package homeCD.validation;

import homeCD.database.DAO.UserDAO;
import homeCD.database.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
@Component
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
