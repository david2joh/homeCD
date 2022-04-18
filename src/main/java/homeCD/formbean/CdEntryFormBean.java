package homeCD.formbean;

import homeCD.database.entity.Composer;
import homeCD.database.entity.Performance;
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
public class CdEntryFormBean {

    private Integer id = 0;

    @NotBlank(message = "Label/Publisher Name is required")
    private String label;

    @NotBlank(message = "Catalog Number is required")
    private String catalogNumber;

    @NotBlank(message = "Composer is required")
    private String composer;

    @NotBlank(message = "Performance Name is required")
    private String work;

    @NotBlank(message = "Artist Name is required")
    private String artist;

    @LocationNameFound(message="Location Does Not Exist")
    @NotBlank(message = "Location Name is required")
    @Length(max=15,min=3,message="Location Name must be between 3 and 15 character")
    private String locationName;

    //Used to circumvent a set of DB lookups while we are creating the CD
    List<String> composers = new ArrayList<>();
    List<String> works     = new ArrayList<>();
    List<String> artists   = new ArrayList<>();
    List<Integer> performancePK = new ArrayList<>();
}
