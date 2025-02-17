package mosreg.model.doctor;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ClosestEntry {
    private String timeTableGuid;
    private String beginTime;
}