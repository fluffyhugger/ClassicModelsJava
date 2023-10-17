package sit.int202.classicmodels;

import com.sun.security.jgss.GSSUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import sit.int202.classicmodels.entities.*;

import java.util.List;

public class TestQuery {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("OFFICE.FIND_ALL");
        Query query2 = em.createNamedQuery("EMPLOYEE.FIND_ALL");
        List<Office> officeList = query.getResultList();
        for(Office office : officeList) {
            System.out.printf("%-2s %-25s %-13s %-12s\n",
                    office.getOfficeCode(), office.getAddressLine1(), office.getCity(), office.getCountry());
        }
        System.out.println("--------");
        for(Employee employee : (List<Employee>) em.createNamedQuery("EMPLOYEE.FIND_ALL").getResultList()){
            System.out.printf("%-25s %-25s \n",employee.getFirstName(),employee.getEmail());
        }
        em.close();
    }
}