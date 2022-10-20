package com.machinestalk.machinestalktestback.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.machinestalk.machinestalktestback.enums.Gender;
import com.machinestalk.machinestalktestback.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserMachinestalk {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(value = "id")
    private Integer id;
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    @JsonProperty(value = "gender")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @JsonProperty(value = "status")
    private Status status;

}
