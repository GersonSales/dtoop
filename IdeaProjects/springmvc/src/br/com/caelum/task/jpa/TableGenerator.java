package br.com.caelum.task.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by gersonsales on 25/01/17.
 */
public class TableGenerator {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory;
        entityManagerFactory = Persistence.createEntityManagerFactory("tasks");

        entityManagerFactory.close();


    }
}
