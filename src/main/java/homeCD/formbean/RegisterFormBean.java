package homeCD.formbean;

import homeCD.validation.UserNameUnique;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Data
public class RegisterFormBean {

  private Integer id;

    @NotBlank(message = "UserName is required")
    @UserNameUnique(message = "Username is already in use.")
    @Length(min= 3, max= 16, message="Password must be between 3 and 16 characters.")
    private String userName;

    @Length(min= 3, max= 30, message="Password must be between 3 and 30 characters.")
    @NotBlank(message = "First Name is required")
    private String firstName;

    @Length(min= 3, max= 30, message="Password must be between 3 and 30 characters.")
    @NotBlank(message = "Last Name is required")
    private String lastName;

    @Length(min= 3, max= 32, message="Password must be between 3 and 32 characters.")
    @NotBlank(message="Password is required")
    private String password;

    @NotBlank(message="Confirm password is required")
    private String confirmPassword;

    private Integer userType;
}

