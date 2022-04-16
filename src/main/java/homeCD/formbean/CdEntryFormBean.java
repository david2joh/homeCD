package homeCD.formbean;

import homeCD.database.entity.Composer;
import homeCD.database.entity.Performance;
import homeCD.validation.LocationNameFound;
import lombok.*;

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

    @NotBlank(message = "Last Name is required")
    private String label;

    @NotBlank(message = "Catalog Number is required")
    private String catalogNumber;

    @NotBlank(message = "Composer is required")
    private String composer;

    @NotBlank(message = "Performance Name is required")
    private String work;

    @NotBlank(message = "Artist Name is required")
    private String artist;

    @LocationNameFound(message="Location does not Exist")
    @NotBlank(message = "Location Name is required")
    private String locationName;

    //Used to circumvent a set of DB lookups while we are creating the CD
    List<String> composers = new ArrayList<>();
    List<String> works     = new ArrayList<>();
    List<String> artists   = new ArrayList<>();
    List<Integer> performancePK = new ArrayList<>();
}
