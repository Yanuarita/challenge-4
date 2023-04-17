package com.example.tiket.controller;

import com.example.tiket.model.Film;
import com.example.tiket.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private FilmService service;

    @GetMapping ("/getAllFilmName")
    public List<Film> getFilmName(){
        return service.getFilmByFilmNameDesc();
    }

    @PostMapping("/addFilmAuto")
    public int addFilmAuto(@RequestBody Film film){
        return service.saveFilm(film);
    }
    // film id

    //tambah satu data
    @PostMapping("/addFilm")
    public Film addFilm(@RequestBody Film film) {
        return service.addFiLm(film);
    }

    // tambah beberapa data
    @PostMapping("/addFilms")
    public List<Film> addFilms(@RequestBody List<Film> films){
        return service.addFilms(films);
    }

    // mendapatkan data
    @GetMapping("/getAll")
    public Iterator<Film> getAll() {
        return service.getAll();
    }

    //mendapatkan data dari kode film
    @GetMapping("/findByFilmCode")
    public List<Film> findByFilmCode(@RequestBody Film film) {
        return service.findByFilmCode(film.getFilmCode());
    }

    // menghapus data dari ID
    @DeleteMapping("/delete")
    public String deleteData(@RequestBody int id) {
        return service.deleteData(id);
    }

    // mempebarui data
    @PutMapping("/update")
    public String updateFilm(@RequestBody Film film) throws ParseException {
        return service.updateData(film);
        }

    }

