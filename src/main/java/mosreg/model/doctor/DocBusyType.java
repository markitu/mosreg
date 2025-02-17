package mosreg.model.doctor;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DocBusyType {
    private String name;
    private String type;
    private String code;
}