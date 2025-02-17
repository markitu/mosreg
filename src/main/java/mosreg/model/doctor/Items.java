package mosreg.model.doctor;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Items {
    private Long lpu_code;
    private Uchastok uchastok;
    private Lpu lpu;
    private List<Doctors> doctors;
}