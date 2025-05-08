package Worksheet.Q8_Employee_Hierarchy;

import java.util.Objects;

public class Manager extends Employee{
    public Manager(String name) {
        super(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager manager)) return false;
        return name.equals(manager.name) && id == manager.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
