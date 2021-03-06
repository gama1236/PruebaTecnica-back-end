package com.pruebatecnica.codesa.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private Long userId;
    private String userName;
    private Boolean userState;
    private RolRequest rol;
}
