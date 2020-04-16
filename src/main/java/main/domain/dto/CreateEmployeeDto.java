package main.domain.dto;

import java.io.Serializable;

public class CreateEmployeeDto implements Serializable {
    private String name;
    private String surname;

    public CreateEmployeeDto() {

    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }
}
