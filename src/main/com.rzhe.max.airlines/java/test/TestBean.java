package test;

import config.SpringConfig;
import entities.Airport;
import entities.Flight;
import entities.User;
import entities.UserType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestBean {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserType userType = context.getBean("userType", UserType.class);
        userType.setName("admin");
        userType.setId(1L);

        User user = context.getBean(User.class);
        user.setId(1L);
        user.setFirstName("Max");
        user.setLastName("Rzhe");
        user.setLogin("admin");
        user.setPassword("admin");

        System.out.println(user);

        Airport airport = context.getBean("departureAirport", Airport.class);
        airport.setId(1L);
        airport.setCity("Moscow");
        airport.setAirportCode("MSQ");
        System.out.println(airport);

        Airport arrivalAirport = context.getBean("arrivalAirport", Airport.class);
        arrivalAirport.setId(2L);
        arrivalAirport.setCity("Minsk");
        arrivalAirport.setAirportCode("MIN");
        System.out.println(arrivalAirport);

        Flight flight = context.getBean("flight", Flight.class);
        System.out.println(flight);


    }
}
