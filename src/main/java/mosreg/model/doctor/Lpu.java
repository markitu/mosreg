package mosreg.model.doctor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Lpu {
    private String guid;
    private String oid;
    private String name;
    private String address;
    private String phone;
    private String mcod;
    private Boolean recipe;
    private Boolean wlist;
}