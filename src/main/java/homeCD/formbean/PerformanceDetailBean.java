package homeCD.formbean;


import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PerformanceDetailBean {

    private Integer cdId;

    private String performance;

    private String composer;

    private String artist;

    private String locationName;
}
