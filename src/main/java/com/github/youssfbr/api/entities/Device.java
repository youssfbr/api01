package com.github.youssfbr.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.youssfbr.api.entities.enums.DeviceType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_device")
@EqualsAndHashCode(of = "id")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime moment;
    private DeviceType deviceType;

    @ManyToOne
    private Brand brand;

    private String model;
    private String productId;
    private String regTypeNo;
    private String serviceTag;
    private String expressServiceCode;
    private String serialNumber;
    private String fab;
    private String voltage;
    private String setup;

    @Column(columnDefinition = "text")
    private String note;

    @ManyToOne
    @JsonIgnore
    private Client client;
}
