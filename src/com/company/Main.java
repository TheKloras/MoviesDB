package com.company;

import com.company.DAO.MoviesDAO;
import com.company.entity.Movies;

public class Main {

    public static void main(String[] args) {
        System.out.println("pagnali");
        MoviesDAO moviesDAO = new MoviesDAO();

        Movies movie = new Movies("test", 10);
        moviesDAO.insert(movie);
    }
}
