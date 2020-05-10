package com.rzhe.max.airlines.test;


import com.rzhe.max.airlines.config.AppConfig;
import com.rzhe.max.airlines.dao.AirportDao;
import com.rzhe.max.airlines.dao.CrewManDao;
import com.rzhe.max.airlines.dao.DaoException;
import com.rzhe.max.airlines.dao.ProfessionDao;
import com.rzhe.max.airlines.entities.Airport;
import com.rzhe.max.airlines.entities.CrewMan;
import com.rzhe.max.airlines.entities.Profession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

public class TestBean {
    private static Logger logger =
            LoggerFactory.getLogger(TestBean.class);

    public static void main(String[] args) throws DaoException {
        GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AirportDao airportDao = context.getBean("airportDao", AirportDao.class);
        ProfessionDao professionDao = context.getBean("professionDao", ProfessionDao.class);
        CrewManDao crewManDao = context.getBean("crewManDao", CrewManDao.class);

//        List<Airport> airportList = airportDao.findAll();
//        airportList.forEach(System.out::println);

//        List<Profession> professions = professionDao.findAll();
//        professions.forEach(System.out::println);

        List<CrewMan> crewManList = crewManDao.findAll();
        crewManList.forEach(System.out::println);

    }
}
