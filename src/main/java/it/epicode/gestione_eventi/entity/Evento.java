package it.epicode.gestione_eventi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "eventi")
public class Evento {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Long id;

    @Column(nullable = false)
        private String titolo;

    @Column(name = "data_evento",nullable = false)
    private Date dataEvento;

    @Column(nullable = false)
    private String descrizione;

    @Column(name = "tipo_evento",nullable = false)
    private EventoEnum tipoEvento;

    @Column(name = "partecipanti_max",nullable = false)
    private int numeroMassimoPartecipanti;


}
