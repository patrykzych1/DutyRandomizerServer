package main.domain.dto;

import java.io.Serializable;

public class EmployeeDto implements Serializable {
    private Long id;
    private String name;
    private String surname;

    public EmployeeDto() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
