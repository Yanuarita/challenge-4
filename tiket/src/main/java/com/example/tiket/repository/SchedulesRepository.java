package com.example.tiket.repository;

import com.example.tiket.model.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchedulesRepository extends JpaRepository<Schedules, Integer> {

    @Query(value = "SELECT * FROM public.schedules WHERE hargaTiket = 1 ORDER BY tanggaltayang DESC ", nativeQuery = true)
    List<Schedules> findBySchedulesHargaTiketDesc();


    List<Schedules> findByFilmCode(int code);

}