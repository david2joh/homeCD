package homeCD.formbean;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LocationFormBean {

    @NotNull(message = "Location Name is required")
    @NotBlank(message = "Location Name is required")
    @Length(max = 15, min = 3, message = "Location Name must be between 3 and 15 character")
//    @LocationNameFound(message = "Location Does Not Exist")
    private String locationName = "";

    private Integer id = 0;

}
