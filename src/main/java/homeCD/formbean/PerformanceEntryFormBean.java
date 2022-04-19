package homeCD.formbean;

import homeCD.database.entity.Cd;
import homeCD.database.entity.Performance;
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

    private String label;

    private String catalogNumber;

    private String locationName;

//    private Cd cd = new Cd();

    @NotBlank(message = "Composer is required")
    private String composer;

    @NotBlank(message = "Performance Name is required")
    private String performance;

    @NotBlank(message = "Artist Name is required")
    private String artist;


    //Used to circumvent a set of DB lookups while we are creating the CD
    List<String> composers = new ArrayList<>();
    List<String> works     = new ArrayList<>();
    List<String> artists   = new ArrayList<>();
    List<Integer> performancePK = new ArrayList<>();

    List<Performance> performances = new ArrayList<>();

}
