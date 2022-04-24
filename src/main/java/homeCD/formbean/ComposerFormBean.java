package homeCD.formbean;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ComposerFormBean {

    @NotBlank(message = "Composer Name is required")
    private String composerName = "";

    private Integer id = 0;

}
