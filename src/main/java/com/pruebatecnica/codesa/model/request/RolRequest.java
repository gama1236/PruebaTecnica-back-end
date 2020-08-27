package com.pruebatecnica.codesa.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RolRequest {

    private Long rolId;
    private String nameRol;
}
