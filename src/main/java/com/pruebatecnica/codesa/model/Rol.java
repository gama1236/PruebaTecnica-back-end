package com.pruebatecnica.codesa.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_id_rol")
    @ApiModelProperty(notes = "ID del rol", required = true)
    private Long rolId;

    @Column(name = "r_nombre")
    @ApiModelProperty(notes = "nombre del rol", required = true)
    private String nameRol;

    @OneToMany(mappedBy = "rol", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List <User> userList;

}
