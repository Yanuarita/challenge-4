package com.example.tiket.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "filmid")
    int filmId;
    @Column(name = "filmcode")
    int filmCode;
    @Column(name = "filmname")
    String filmName;
    @Column(name = "penayangan")
    String penayangan;

}