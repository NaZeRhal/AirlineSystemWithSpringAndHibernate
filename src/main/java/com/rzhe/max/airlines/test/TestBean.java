package com.rzhe.max.airlines.test;


import com.rzhe.max.airlines.config.AppConfig;
import com.rzhe.max.airlines.dao.*;
import com.rzhe.max.airlines.entities.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

public class TestBean {
    private static Logger logger =
            LoggerFactory.getLogger(TestBean.class);

    public static void main(String[] args) {
        GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AirportDao airportDao = context.getBean("airportDao", AirportDao.class);
//        ProfessionDao professionDao = context.getBean("professionDao", ProfessionDao.class);
//        CrewManDao crewManDao = context.getBean("crewManDao", CrewManDao.class);
//        UserTypeDao userTypeDao = context.getBean("userTypeDao", UserTypeDao.class);
//        UserDao userDao = context.getBean("userDao", UserDao.class);
//        FlightDao flightDao = context.getBean("flightDao", FlightDao.class);

        List<Airport> airportList = airportDao.findAll();
        airportList.forEach(System.out::println);
//
//        List<Profession> professions = professionDao.findAllWithFlights();
//        professions.forEach(i -> {
//            System.out.println(i);
//            if (i.getCrewMEN() != null) {
//                i.getCrewMEN().forEach(System.out::println);
//            }
//        });
//
//        List<UserType> userTypeList = userTypeDao.findAllWithUsers();
//        userTypeList.forEach(i -> {
//            System.out.println(i);
//            if (i.getUserSet() != null) {
//                i.getUserSet().forEach(System.out::println);
//            }
//        });
//
//        List<CrewMan> crewManList = crewManDao.findAll();
//        crewManList.forEach(System.out::println);
//        CrewMan crewMan = crewManDao.findById(1L);
//        System.out.println(crewMan);
////
//        User user = userDao.findById(1L);
//        System.out.println(user);
//        List<Flight> flights = flightDao.findAll();
//        flights.forEach(System.out::println);


    }
}
