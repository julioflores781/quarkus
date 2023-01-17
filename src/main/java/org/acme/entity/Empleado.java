package org.acme.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.smallrye.common.constraint.NotNull;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "empleados")
public class Empleado extends PanacheEntity {

 @NotNull
 @Column(name = "empleado_id")
 private String empleado_id;
 private String nombre;
 private String apellido;
 private short  puesto_id;
 private char editorial_id;
 private Date fecha_ingreso;

 private Long id;

 public void setId(Long id) {
  this.id = id;
 }

 public Empleado(String empleado_id, String nombre, String apellido, short puesto_id, char editorial_id, Date fecha_ingreso) {
  this.empleado_id = empleado_id;
  this.nombre = nombre;
  this.apellido = apellido;
  this.puesto_id = puesto_id;
  this.editorial_id = editorial_id;
  this.fecha_ingreso = fecha_ingreso;
 }

 public Empleado() {
 }

 public String getEmpleado_id() {
  return empleado_id;
 }

 public void setEmpleado_id(String empleado_id) {
  this.empleado_id = empleado_id;
 }

 public Long getId() {
  return id;
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
  this.apellido = apellido;
 }

 public short getPuesto_id() {
  return puesto_id;
 }

 public void setPuesto_id(short puesto_id) {
  this.puesto_id = puesto_id;
 }

 public char getEditorial_id() {
  return editorial_id;
 }

 public void setEditorial_id(char editorial_id) {
  this.editorial_id = editorial_id;
 }

 public Date getFecha_ingreso() {
  return fecha_ingreso;
 }

 public void setFecha_ingreso(Date fecha_ingreso) {
  this.fecha_ingreso = fecha_ingreso;
 }

 @Override
 public String toString() {
  return "Empleado{" +
          "empleado_id='" + empleado_id + '\'' +
          ", nombre='" + nombre + '\'' +
          ", apellido='" + apellido + '\'' +
          ", puesto_id=" + puesto_id +
          ", editorial_id=" + editorial_id +
          ", fecha_ingreso=" + fecha_ingreso +
          '}';
 }
}
