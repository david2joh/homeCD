package homeCD.formbean;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


//
//This bean is actually carrying the lists of performances
// to the front end as read-only
//
//  As an extension try to map this with @ModelAttribute
//
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CdDetailsBean {

    private Integer id = 0;

    private String label = "";

    private String catalogNumber = "";

    private String locationName = "";

    private List<String> composers = new ArrayList<>();

    private List<String> works = new ArrayList<>();

    private List<String> artists = new ArrayList<>();

}
