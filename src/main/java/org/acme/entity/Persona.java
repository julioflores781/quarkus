package org.acme.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Persona extends PanacheEntity {

    private Integer id =1;
    private String nombre;
    private String apellido;

    public Persona(){
        id+=1;
    }
    public Persona(String nombre, String apellido){
        super();
        this.nombre = nombre;
        this.apellido = apellido;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        apellido = apellido;
    }
}
