/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.assignment.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Hansani Kariyawasam
 */
public class SessionFactoryUtil {
    private static SessionFactory sessionFactroy;

    private SessionFactoryUtil() {
        sessionFactroy=new Configuration().configure("/lk/edu/ijse/assignment/config/hibernate.cfg.xml").buildSessionFactory();
    }
    
    public static SessionFactory getSession(){
        if(sessionFactroy==null){
            SessionFactoryUtil sessionFactoryUtil=new SessionFactoryUtil();
        }
        return sessionFactroy;
    }
    
}
