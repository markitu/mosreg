package mosreg.model.doctor;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Uchastok {
    private String name;
    private String code;
    private String docPrvd;
}