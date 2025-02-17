package doctors;

import mosreg.model.doctor.Doctors;
import mosreg.model.doctor.Items;
import mosreg.model.doctor.Schedule;
import mosreg.service.DoctorService;
import mosreg.utilities.DoctorFinder;
import mosreg.utilities.DoctorSchedulePrinter;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

public class DoctorTests {

    public Optional<Doctors> findDoctorById(List<Items> items, String targetId) {
        return items.stream()
                .flatMap(item -> item.getDoctors().stream()) // Разворачиваем список doctors
                .filter(doctor -> doctor.getId().equals(targetId)) // Фильтруем по id
                .findFirst(); // Берем первый найденный объект (если есть)
    }


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

                if (schedule.getTime_from() == null || schedule.getTime_from().isEmpty() ||
                        schedule.getTime_to() == null || schedule.getTime_to().isEmpty()) {
                    System.out.println("  — Нет свободных окошек");
                } else {
                    System.out.println("  — Время: " + schedule.getTime_from() + " - " + schedule.getTime_to());
                }
            }
        }

    @Test
    public void test() {
        DoctorService doctorService = new DoctorService();
        List<Items> items = doctorService.getDoctorsList();

        String targetId = "fbb2fb98-cbda-43f3-a09e-513395e560e6b09476d0-403c-46b0-a0ff-967217c8bfc8";
        String kalashnikova = "fbb2fb98-cbda-43f3-a09e-513395e560e654bf78b0-d47f-4d93-b724-74e5bcc56449";

        DoctorFinder doctorFinder = new DoctorFinder();
        Optional<Doctors> doctorOpt = doctorFinder.findDoctorById(items, targetId);

        doctorOpt.ifPresentOrElse(
                DoctorSchedulePrinter::printDoctorSchedule,
                () -> System.out.println("Доктор не найден")
        );



    }
}