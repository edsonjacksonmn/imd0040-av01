package br.ufrn.imd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.*;

public class VehicleTest {

    @Test
    public void testCarCreation() throws Exception {
        Class<?> vehicleFactoryClass = Class.forName("br.ufrn.imd.VehicleFactory");
        Class<?> carClass = Class.forName("br.ufrn.imd.Car");

        Method createVehicleMethod = vehicleFactoryClass.getMethod("createVehicle",
                Class.forName("br.ufrn.imd.VehicleType"), String.class, double.class, int.class);
        Object car = createVehicleMethod.invoke(null,
                Enum.valueOf((Class<Enum>) Class.forName("br.ufrn.imd.VehicleType"), "CAR"),
                "ABC1234", 30000.0, 4);

        Field doorsField = carClass.getDeclaredField("doors");
        doorsField.setAccessible(true);
        assertEquals(4, doorsField.getInt(car));

        Method getValueMethod = carClass.getMethod("getValue");
        assertEquals(30000.0, (double) getValueMethod.invoke(car));
    }

    @Test
    public void testMotorcycleCreation() throws Exception {
        Class<?> vehicleFactoryClass = Class.forName("br.ufrn.imd.VehicleFactory");
        Class<?> motorcycleClass = Class.forName("br.ufrn.imd.Motorcycle");

        Method createVehicleMethod = vehicleFactoryClass.getMethod("createVehicle",
                Class.forName("br.ufrn.imd.VehicleType"), String.class, double.class, int.class);
        Object motorcycle = createVehicleMethod.invoke(null,
                Enum.valueOf((Class<Enum>) Class.forName("br.ufrn.imd.VehicleType"), "MOTORCYCLE"),
                "XYZ5678", 15000.0, 600);

        Field engineCapacityField = motorcycleClass.getDeclaredField("engineCapacity");
        engineCapacityField.setAccessible(true);
        assertEquals(600, engineCapacityField.getInt(motorcycle));

        Method getValueMethod = motorcycleClass.getMethod("getValue");
        assertEquals(15000.0, (double) getValueMethod.invoke(motorcycle));
    }

    @Test
    public void testCarTaxCalculation() throws Exception {
        Class<?> vehicleFactoryClass = Class.forName("br.ufrn.imd.VehicleFactory");

        Method createVehicleMethod = vehicleFactoryClass.getMethod("createVehicle",
                Class.forName("br.ufrn.imd.VehicleType"), String.class, double.class, int.class);
        Object car = createVehicleMethod.invoke(null,
                Enum.valueOf((Class<Enum>) Class.forName("br.ufrn.imd.VehicleType"), "CAR"),
                "ABC1234", 30000.0, 4);

        Method calculateTaxMethod = car.getClass().getMethod("calculateTax");
        assertEquals(900.0, (double) calculateTaxMethod.invoke(car));
    }

    @Test
    public void testMotorcycleTaxCalculation() throws Exception {
        Class<?> vehicleFactoryClass = Class.forName("br.ufrn.imd.VehicleFactory");

        Method createVehicleMethod = vehicleFactoryClass.getMethod("createVehicle",
                Class.forName("br.ufrn.imd.VehicleType"), String.class, double.class, int.class);
        Object motorcycle = createVehicleMethod.invoke(null,
                Enum.valueOf((Class<Enum>) Class.forName("br.ufrn.imd.VehicleType"), "MOTORCYCLE"),
                "XYZ5678", 15000.0, 600);

        Method calculateTaxMethod = motorcycle.getClass().getMethod("calculateTax");
        assertEquals(225.0, (double) calculateTaxMethod.invoke(motorcycle));
    }

    @BeforeAll
    public static void testTotalVehiclesCount() throws Exception {
        Class<?> vehicleFactoryClass = Class.forName("br.ufrn.imd.VehicleFactory");
        Class<?> vehicleClass = Class.forName("br.ufrn.imd.Vehicle");

        Method createVehicleMethod = vehicleFactoryClass.getMethod("createVehicle",
                Class.forName("br.ufrn.imd.VehicleType"), String.class, double.class, int.class);
        createVehicleMethod.invoke(null,
                Enum.valueOf((Class<Enum>) Class.forName("br.ufrn.imd.VehicleType"), "CAR"),
                "ABC1234", 30000.0, 4);
        createVehicleMethod.invoke(null,
                Enum.valueOf((Class<Enum>) Class.forName("br.ufrn.imd.VehicleType"), "MOTORCYCLE"),
                "XYZ5678", 15000.0, 600);

        Method createVehicleMethod2 = vehicleFactoryClass.getMethod("createVehicle",
                Class.forName("br.ufrn.imd.VehicleType"), String.class, double.class);
        createVehicleMethod2.invoke(null,
                Enum.valueOf((Class<Enum>) Class.forName("br.ufrn.imd.VehicleType"), "CAR"),
                "ABC1234", 30000.0);
        createVehicleMethod2.invoke(null,
                Enum.valueOf((Class<Enum>) Class.forName("br.ufrn.imd.VehicleType"), "MOTORCYCLE"),
                "XYZ5678", 15000.0);

        Method getTotalVehiclesMethod = vehicleClass.getMethod("getTotalVehicles");
        assertEquals(4, (int) getTotalVehiclesMethod.invoke(null));
    }
}

