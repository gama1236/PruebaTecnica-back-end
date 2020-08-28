package com.pruebatecnica.codesa.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_id_usuario")
    @ApiModelProperty(notes = "ID del rol", required = true)
    private Long userId;

    @Column(name = "u_nombre")
    @ApiModelProperty(notes = "nombre del rol", required = true)
    private String userName;


    @Column(name = "u_estado")
    @ApiModelProperty(notes = "nombre del rol", required = true)
    private Boolean userState;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "u_id_rol", referencedColumnName = "r_id_rol")
    private Rol rol;

}
