package com.example.tiket.service;

import com.example.tiket.model.Film;
import com.example.tiket.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    @Autowired
    private FilmRepository repository;

    EntityManager entityManager;


    public FilmService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public int saveFilm(Film film) {
        entityManager.persist(film);
        return film.getFilmId();
    }

    public List<Film> getFilmByFilmNameDesc() {
        return repository.findByFilmFilmNameDesc();
    }

    public Iterator<Film> getAll() {
        Iterator<Film> check = repository.findAll().iterator();
        if (check.hasNext()) return check;
        else throw new RuntimeException("data tidak tersedia");
    }

    public List<Film> findByFilmCode(int code) {
        if (repository.findByFilmCode(code).isEmpty()) throw new RuntimeException("kode film tidak ditemukan...!");
        else return repository.findByFilmCode(code);
    }

    public String deleteById(int id) {
        repository.deleteById(id);
        return "Berhasil di hapus..!";
    }


    public String updateFilm(Film film) throws ParseException {
        if (isExist(film)) {
            Film update = repository.findById(film.getFilmId()).orElse(null);
            update.setFilmId(film.getFilmId());
            update.setFilmCode(film.getFilmCode());
            update.setFilmName(film.getFilmName());
            update.setPenayangan(film.getPenayangan());
            repository.save(update);
            return "data berhasil di perbarui..!";
        } else {
            throw new RuntimeException("data dengan id " + film.getFilmId() + " tidak tersedia...!");
        }
    }


    public boolean isExist(Film film) {
        Optional<Film> check = repository.findById(film.getFilmId());
        return check.isPresent();
    }

    public Film addFilm(Film film) {
        if (isExist(film)) throw new RuntimeException("data sudah tersedia...!");
        else {
            return repository.save(film);
        }
    }

    public List<Film> addFilm(List<Film> film) {
        Iterator<Film> check = film.iterator();
        while (check.hasNext()) {
            Film temp = check.next();
            if (isExist(temp)) throw new RuntimeException("data dengan id " + temp.getFilmId() + " sudah tersedia...!");
        }
        return repository.saveAll(film);
    }
}