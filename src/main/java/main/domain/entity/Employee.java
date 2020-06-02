package main.domain.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pracownicy")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pracownika")
    private Long id;

    @Column(name = "imie")
    private String name;

    @Column(name = "nazwisko")
    private String surname;

    public Employee() {

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
