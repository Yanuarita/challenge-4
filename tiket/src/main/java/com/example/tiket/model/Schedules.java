package com.example.tiket.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Data
@Entity
@Table(name = "schedules")
public class Schedules {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedulesid")
    int schedulesId;
    @Column(name = "filmcode")
    int filmCode;
    @Column(name = "tanggaltayang")
    Date tanggalTayang;
    @Column(name = "jammulai")
    Time jamMulai;
    @Column(name = "jamselesai")
    Time jamSelesai;
    @Column (name = "hargatiket")
    int hargaTiket;

}