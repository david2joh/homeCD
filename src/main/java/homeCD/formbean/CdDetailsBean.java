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
public class CdDetailsBean {

        private Integer id = 0;

        private String label = "";

        private String catalogNumber = "";

        private String locationName ="";

        private List<String> composers = new ArrayList<>();

        private List<String> works = new ArrayList<>();

        private List<String> artists = new ArrayList<>();

}
