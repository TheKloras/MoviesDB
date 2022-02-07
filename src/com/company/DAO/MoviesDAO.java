package com.company.DAO;

import com.company.entity.Movies;
import com.company.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class MoviesDAO {
    public MoviesDAO() {

    }

    public void insert(Movies movies) {
        // Norint atlikti uzklausa i DB reikia is sesiju gamyklos paprasyti sesijos.
        // Sesiju objektas yra lengvasvoris (lightweight).
        // Sesiju galima tureti neribota kieki per aplikacija.
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(movies);

        session.getTransaction().commit();
        System.out.println("Sekmingai issaugojam nauja objekta.");
    }

    public void update(Movies movies) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.update(movies);

        session.getTransaction().commit();
        System.out.println("Irasa pavyko sekmingai atnaujinti (pagal ID).");
    }

    public void delete(Movies movies) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.delete(movies);

        session.getTransaction().commit();
        System.out.println("Irasa pavyko sekmingai pasalinti.");
    }

    public Movies searchByID(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Movies movies = session.get(Movies.class, id);

        session.getTransaction().commit();
        System.out.println("Pavyko atlikti paieska sekmingai pagal ID.");

        return movies;
    }

    public List<Movies> searchByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Movies> airports = new ArrayList<>();
        // Panaudosime hibernate query language (HQL). Naudojama su metodu create query.
        airports = session.createQuery("from Movies m where m.name like '" + name + "'").getResultList();

        session.getTransaction().commit();
        System.out.println("Pavyko sekmingai atlikti paieska pagal varda.");

        return airports;
    }
}
