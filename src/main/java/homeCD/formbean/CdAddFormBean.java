package homeCD.formbean;

import homeCD.validation.LocationNameFound;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CdAddFormBean {

    private Integer id = 0;

    @NotBlank(message = "Label Name is required")
    private String label;

    @NotBlank(message = "Catalog Number is required")
    private String catalogNumber;

    @LocationNameFound(message="Location Does Not Exist")
    @NotBlank(message = "Location Name is required")
    @Length(max=15,min=3,message="Location Name must be between 3 and 15 character")
    private String locationName;
}

