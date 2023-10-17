package sit.int202.classicmodels;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sit.int202.classicmodels.entities.Employee;
import sit.int202.classicmodels.entities.Office;

import java.util.Scanner;

public class TestJpa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        Office office = em.find(Office.class, "2");
        if(office != null){
            System.out.println(office);
        }else{
            System.out.println("Add new Office");
            Office newOffice = new Office();
            newOffice.setOfficeCode("10");
            newOffice.setCountry("Thailand");
            newOffice.setCity("Bangkok");
            newOffice.setAddressLine1("126 Pracha Unit");
            newOffice.setPhone("987665");
            newOffice.setPostalCode("10140");
            newOffice.setTerritory("XX");
            em.getTransaction().begin();
            em.persist(newOffice);
            em.getTransaction().commit();
        }
        System.out.println("Enter office Code you want to delete:");
        String x = new Scanner(System.in).next();
        Office delOffice = em.find(Office.class, x);
        if(delOffice != null){
            em.getTransaction().begin();
            em.remove(delOffice);
            em.getTransaction().commit();
        }
        Employee employee = em.find(Employee.class,1002);
        System.out.println(employee);
        em.close();
        emf.close();
    }
}
