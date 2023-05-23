package com.productos.apirest.models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "producto")
public class Producto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //especifica o id criado automaticamente
	 private Integer id;
	 private String nombre;
	 private String categoria;
	 private BigDecimal precio;
	 private String ubicacion;
}