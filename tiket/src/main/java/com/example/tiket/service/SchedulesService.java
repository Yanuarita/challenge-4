package com.example.tiket.service;

import com.example.tiket.model.Schedules;
import com.example.tiket.repository.SchedulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class SchedulesService {

    @Autowired
    private SchedulesRepository repository;

    EntityManager entityManager;

    public SchedulesService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public int saveSchedules(Schedules schedules) {
        entityManager.persist(schedules);
        return schedules.getSchedulesId();
    }
    public List<Schedules> getSchedulesByHargaTiketDesc() {
        return repository.findBySchedulesHargaTiketDesc();
    }
    public List<Schedules> getAll() {
        Iterator<Schedules> check = repository.findAll().iterator();
        if (check.hasNext()) return (List<Schedules>) check;
        else throw new RuntimeException("data tidak tersedia");
    }
    public List<Schedules> findByFilmCode(int code) {
        if (repository.findByFilmCode(code).isEmpty()) throw new RuntimeException("kode film tidak ditemukan...!");
        else return repository.findByFilmCode(code);
    }

    public String deleteById(int id) {
        repository.deleteById(id);
        return "Berhasil dihapus..!";
    }
    public String updateSchedules(Schedules schedules) throws ParseException {
        if (isExist(schedules)) {
            Schedules update = repository.findById(schedules.getSchedulesId()).orElse(null);
            update.setSchedulesId(schedules.getSchedulesId());
            update.setFilmCode(schedules.getFilmCode());
            update.setTanggalTayang(schedules.getTanggalTayang());
            update.setJamMulai(schedules.getJamMulai());
            update.setJamSelesai(schedules.getJamSelesai());
            update.setHargaTiket(schedules.getHargaTiket());
            repository.save(update);
            return "data berhasil diperbarui..!";
        } else {
            throw new RuntimeException("data dengan id " + schedules.getSchedulesId() + " tidak tersedia...!");
        }
    }
     public boolean isExist(Schedules schedules) {
         Optional<Schedules> check = repository.findById(schedules.getSchedulesId());
         return check.isPresent();
     }

     public Schedules addSchedules(Schedules schedules) {
        if (isExist(schedules)) throw new RuntimeException("data sudah tersedia...!");
        else {
            return repository.save(schedules);
        }
     }
    public List<Schedules> addScheduless(List<Schedules> schedules) {
        Iterator<Schedules> check = schedules.iterator();
        while (check.hasNext()) {
            Schedules temp = check.next();
            if (isExist(temp)) throw new RuntimeException("data dengan id" + temp.getSchedulesId() + " sudah tersedia...!");
        }
        return repository.saveAll(schedules);
    }
}
