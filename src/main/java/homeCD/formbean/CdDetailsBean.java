package homeCD.formbean;

//The CdDetails bean is a container to hold the results
//of the join from location to CD to Composer with the added
//field of the performance snd artist from the CD_Composer table
//
//As such we do not have a controller for this rather this bean
//is used to transmit aggregate data as read-only to the front-end
//

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CdDetailsBean {

    private Integer id = 0;

    private String locationName ="";

    private String composer ="";

    private String performance ="";

    private String artist ="";

}
