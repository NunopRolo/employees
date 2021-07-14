package com.employees.employees;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class PositionTest {
    @Test
    public void testSetterAndGetterId() throws Exception {
        Position position = new Position();
        position.setPositionID(1);

        assertEquals(position.getPositionID(), 1);
    }

    @Test
    public void testSetterAndGetterDescription() throws Exception {
        Position position = new Position();
        position.setDescription("Java Developer");

        assertEquals(position.getDescription(), "Java Developer");
    }
}
