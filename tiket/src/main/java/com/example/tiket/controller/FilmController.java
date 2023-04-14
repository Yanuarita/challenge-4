package com.example.tiket.controller;

import com.example.tiket.model.Film;
import com.example.tiket.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

@RestController
public class FilmController {

    @Autowired
    private FilmService service;

    @GetMapping("/getAllFilmName")
    public List<Film> getFilmName() {
        return service.getFilmByFilmNameDesc();
    }

    @PostMapping("/addFilmAuto")
    public int addFilmAuto(@RequestBody Film film) {
        return service.saveFilm(film);
    }

//    film id, film code, film name, penayangan

    // tambah satu data
    @PostMapping("/addFilm")
    public Film addFilm(@RequestBody Film film) {
        return service.addFilm(film);
    }

    // tambah beberapa data
    @PostMapping("/addFilm")
    public List<Film> addFilm(@RequestBody List<Film> film) {
        return service.addFilm(film);
    }

    // mendapatkan data
    @GetMapping("/getAll")
    public Iterator<Film> getAll() {
        return service.getAll();
    }

    // mendapatkan data dari kode film
    @GetMapping("/findByFilmCode")
    public List<Film> findbyFilmCode(@RequestBody Film film) {
        return service.findByFilmCode(film.getFilmCode());
    }

    // menghapus data dari ID
    @DeleteMapping("/delete")
    public String deleteById(@RequestBody int id) {
        return service.deleteById(id);
    }

    // memperbarui data film
    @PutMapping("/update")
    public String updateFilm(@RequestBody Film film) throws ParseException {
        return service.updateFilm(film);
    }
}