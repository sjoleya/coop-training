package Worksheet.Q9;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * 9. Chained exceptions across layers
    Simulate a layered app:
    - Repository throws `SQLException`.
    - Service layer catches it, wraps it in a `ServiceLayerException`.
    - Controller layer catches `ServiceLayerException` and logs it.
    Write code demonstrating this multi-layer exception wrapping.
 */

public class Question9 {

    private static final Logger LOGGER = Logger.getLogger(Question9.class.getName());
    private static Service service = new Service();

    public static void main(String[] args) {
        try {
            service.processData();
        } catch (ServiceLayerException e) {
            LOGGER.log(Level.SEVERE, "Error in controller layer", e);
        }
    }
}