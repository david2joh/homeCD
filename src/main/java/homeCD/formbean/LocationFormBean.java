package homeCD.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
public class LocationFormBean {

    @NotBlank(message = "Location Name is required")
    @Length(max=15,min=3,message="Location Name must be between 3 and 15 character")
    private String locationName;

    private Integer id;
}
