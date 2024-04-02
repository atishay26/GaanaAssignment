package com.gaana.demo.assignment.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class BaseUserDto {
    @NotBlank(message = "name can not be blank.")
    private String name;

    @Min(value = 16, message = "User can not be less than 16 years old.")
    private Integer age;

    @Min(value = 1, message = "Min required experience is 1 year.")
    private Integer experience;
}
