package com.services.webcarservicessystem;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author AjayMukhi
 */
public class Utility {

    public static EntityManager createEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
        return em;
    }

    

    

    public static Date formatDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date formattedDate = new Date();
        try {
            formattedDate = sdf.parse(date);
        } catch (ParseException e) {
            System.out.println(e.getStackTrace());
        }
        return formattedDate;
    }

    public static Date formatTime(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy:HH:mm:SS");
        Date formattedDate = new Date();
        try {
            formattedDate = sdf.parse(date);
        } catch (ParseException e) {
            System.out.println(e.getStackTrace());
        }
        return formattedDate;
    }
    private static final Logger LOG = Logger.getLogger(Utility.class.getName());
}
