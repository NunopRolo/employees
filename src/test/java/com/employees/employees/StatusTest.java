package com.employees.employees;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusTest {
    @Test
    public void testSetterAndGetterId() throws Exception {
        Status status = new Status();
        status.setStatusID(1);

        assertEquals(status.getStatusID(), 1);
    }

    @Test
    public void testSetterAndGetterDescription() throws Exception {
        Status status = new Status();
        status.setDescription("OK");

        assertEquals(status.getDescription(), "OK");
    }
}
