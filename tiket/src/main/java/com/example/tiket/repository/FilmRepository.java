package com.example.tiket.repository;

import com.example.tiket.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
public interface FilmRepository extends JpaRepository<Film, Integer>  {

    @Query(value = "SELECT * FROM public.film WHERE filmCode = 1 ORDER BY filmCode DESC LIMIT 50", nativeQuery = true)
    List<Film> findByFilmNameDesc();


    List<Film> findByFilmCode(int code);
}
