package homeCD.formbean;

import homeCD.database.entity.Composer;
import homeCD.database.entity.Performance;

import java.util.List;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CdMultiEntryFormBean {

    private Integer id;

    @NotBlank(message = "Publisher is required")
    private String label;

    @NotBlank(message = "Catalog Number is required")
    private String catalogNumber;

    @NotBlank(message = "Location Name is required")
    private String locationName;

    @NotBlank(message = "Composer Name is required")
    private List<Composer> composer;

    @NotBlank(message = "Performance Name is required")
    private List<Performance> performance;
}
