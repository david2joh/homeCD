package homeCD.formbean;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PerformanceEntryFormBean {

    private Integer id;

    @NotBlank(message = "Composer is required")
    private String composer;

    @NotBlank(message = "Performance Name is required")
    private String performance;

    @NotBlank(message = "Artist Name is required")
    private String artist;

    private String label;

    private String catalogNumber;

    private String locationName;

    //Used to circumvent a set of DB lookups while we are creating the CD
    List<String> composers = new ArrayList<>();
    List<String> works     = new ArrayList<>();
    List<String> artists   = new ArrayList<>();
    List<Integer> performancePK = new ArrayList<>();
}
