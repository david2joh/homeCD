package homeCD.formbean;

import homeCD.validation.UserNameUnique;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@Data
public class RegisterFormBean {

  private Integer id;

    @NotBlank(message = "UserName is required")
    @UserNameUnique(message = "Username is already in use.")
    @Length(min= 3, max= 16, message="Username must be between 3 and 16 characters.")
    private String userName;

    @Length(min= 3, max= 30, message="First Name must be between 3 and 30 characters.")
    @NotBlank(message = "First Name is required")
    private String firstName;

    @Length(min= 3, max= 30, message="Last Name must be between 3 and 30 characters.")
    @NotBlank(message = "Last Name is required")
    private String lastName;

    @Length(min= 3, max= 32, message="Password must be between 3 and 32 characters.")
    @NotBlank(message="Password is required")
    // @Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){3,32}$" , message = "Password invalid: One Uppercase, One lower case, One digit, One special char")
    private String password;

    @NotBlank(message="Confirm password is required")
    private String confirmPassword;

    private Integer userType;
}

