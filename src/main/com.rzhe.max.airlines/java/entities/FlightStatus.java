package entities;

import org.springframework.stereotype.Component;

@Component
public class FlightStatus {
   private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightStatus)) return false;

        FlightStatus that = (FlightStatus) o;

        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public String toString() {
        return "FlightStatus{" +
                "name='" + name + '\'' +
                '}';
    }
}
