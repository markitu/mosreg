package mosreg.model.doctor;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Schedule {
    private String date;
    private String time_from;
    private String time_to;
    private DocBusyType docBusyType;
    private Long count_tickets;
}