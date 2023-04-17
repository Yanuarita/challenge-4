package com.example.tiket.controller;

import com.example.tiket.model.Schedules;
import com.example.tiket.service.SchedulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/schedules")
public class SchedulesController {

    @Autowired
    private SchedulesService service;

    @GetMapping("/getAllHargaTiket")
    public List<Schedules> getHargaTiket() {
        return service.getSchedulesByHargaTiketDesc();
    }

    @PostMapping("/addSchedulesAuto")
    public int addSchedulesAuto(@RequestBody Schedules schedules) {
        return service.saveSchedules(schedules);
    }

   // schedules id

    // tambah satu data

    @PostMapping("/addSchedules")
    public Schedules addSchedules(@RequestBody Schedules schedules) {
        return service.addSchedules(schedules);
    }

    // tambah beberapa data

    @PostMapping("/addScheduless")
    public List<Schedules> addScheduless(@RequestBody List<Schedules> schedules ) {
        return service.addScheduless(schedules);
    }
    // mendapatkan data
    @GetMapping("/getAll")
    public Iterator<Schedules> getAll() {
        return (Iterator<Schedules>)
        service.getAll();
    }

    @GetMapping("/findByFilmCode")
    public List<Schedules> findByFilmCode(@RequestBody Schedules schedules) {
        return service.findByFilmCode(schedules.getFilmCode());
    }

    // menghapus data dari ID
    @DeleteMapping("/delete")
    public String deleteById(@RequestBody int id) {
        return service.deleteById(id);
    }

    // mempebarui data
    @PutMapping("/update")
    public String updateSchedules(@RequestBody Schedules schedules) throws ParseException {
        return service.updateSchedules(schedules);
    }
}
