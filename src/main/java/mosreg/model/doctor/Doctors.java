package mosreg.model.doctor;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Doctors {
    private List<Schedule> schedule;
    private ClosestEntry closestEntry;
    private String id;
    private String displayName;
    private String person_id;
    private String lpu_code;
    private Long type;
    private String type_name;
    private String name;
    private String family;
    private String surname;
    private String position;
    private String positionCode;
    private String department;
    private String room;
    private Boolean isWaitingList;
    private Boolean isSpecial;
    private String snils;
    private String birthday;
    private String description;
    private String separation;
    private String rating;
    private String photo;
    private String equipment;
    private String lpu;
    private String uchastokName;
}