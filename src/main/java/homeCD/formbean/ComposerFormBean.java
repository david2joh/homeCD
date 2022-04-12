package homeCD.formbean;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ComposerFormBean {

    @NotBlank(message = "Composer Name is required")
    private String composerName ="";

    private Integer id = 0;

}
