package mosreg.utilities;

import mosreg.model.doctor.Doctors;
import mosreg.model.doctor.Schedule;

import java.util.List;

public class DoctorSchedulePrinter {
    public static void printDoctorSchedule(Doctors doctor) {
        System.out.println("Врач: " + doctor.getFamily() + " " + doctor.getName() + " " + doctor.getSurname());
        System.out.println("Расписание:");

        List<Schedule> schedules = doctor.getSchedule();
        if (schedules == null || schedules.isEmpty()) {
            System.out.println("  Нет доступного расписания.");
            return;
        }

        for (Schedule schedule : schedules) {
            System.out.print("  Дата = " + schedule.getDate());

            boolean hasTime = schedule.getTime_from() != null && !schedule.getTime_from().isEmpty() &&
                    schedule.getTime_to() != null && !schedule.getTime_to().isEmpty();

            if (!hasTime || schedule.getCount_tickets() == 0) {
                System.out.println("  — Нет свободных окошек");
            } else {
                System.out.println("  — Время: " + schedule.getTime_from() + " - " + schedule.getTime_to());
            }
        }
    }
}