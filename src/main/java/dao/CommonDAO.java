package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

public abstract class CommonDAO<T> {
    protected Connection connection;

    public CommonDAO(Connection connection) {this.connection = connection; }

    public abstract T create(T object);

    public abstract boolean delete(T object);

    public abstract boolean update(T object);

    public abstract T findById(int id);

    public abstract T findByName(String name);

    public abstract ArrayList<T> findAll();

    public abstract ArrayList<T> findIntervale(double val1, double val2);

    public abstract ArrayList<T> findByDate(java.sql.Date date);

    public abstract void afficherResultat();

    public abstract ArrayList<T> findOverAverage();

    public abstract ArrayList<T> findArticleStartWith(char c);

    public abstract ArrayList<T> showAllCommandeWithLivraison();

    public abstract ArrayList<T> showCommandesClientByNoCommandeOverX(int noclient, int nocommande);

}
