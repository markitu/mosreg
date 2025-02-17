package mosreg.utilities;

import mosreg.model.doctor.Doctors;
import mosreg.model.doctor.Items;

import java.util.List;
import java.util.Optional;

public class DoctorFinder {
    public Optional<Doctors> findDoctorById(List<Items> items, String targetId) {
        return items.stream()
                .flatMap(item -> item.getDoctors().stream()) // Разворачиваем список doctors
                .filter(doctor -> doctor.getId().equals(targetId)) // Фильтруем по id
                .findFirst(); // Берем первый найденный объект (если есть)
    }
}