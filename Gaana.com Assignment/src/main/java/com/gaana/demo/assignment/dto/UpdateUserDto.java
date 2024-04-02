package com.gaana.demo.assignment.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateUserDto extends BaseUserDto{

    @NotNull
    private Integer id;
}
