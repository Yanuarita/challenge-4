package com.example.tiket.repository;

import com.example.tiket.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
@EnableJpaRepositories
public interface FilmRepository extends JpaRepository<Film, Integer> {

    @Query(value = "SELECT * FROM public.film WHERE filmName = 1 ORDER BY penayangan DESC LIMIT 50", nativeQuery = true)
    List<Film> findByFilmFilmNameDesc();


    List<Film> findByFilmCode(int code);

}