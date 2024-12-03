package it.epicode.gestione_eventi.test;

import com.github.javafaker.Faker;
import it.epicode.gestione_eventi.dao.EventoDAO;
import it.epicode.gestione_eventi.entity.Evento;
import it.epicode.gestione_eventi.entity.EventoEnum;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");

        EntityManager em = emf.createEntityManager();

        Faker faker = new Faker(new Locale("it"));

        EventoDAO eventoDAO =new EventoDAO(em);
        Evento evento = new Evento();
        evento.setTitolo("ceck vs valentin");
        evento.setDataEvento(faker.date().future(10, java.util.concurrent.TimeUnit.DAYS));
        evento.setDescrizione("sponsor epicode ceck contro valentin");
        evento.setTipoEvento(EventoEnum.PRIVATO);
        evento.setNumeroMassimoPartecipanti(24);

        eventoDAO.insertEvento(evento);
        em.close();
    }

}
