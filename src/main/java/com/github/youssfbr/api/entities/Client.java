package com.github.youssfbr.api.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_client")
@EqualsAndHashCode(of = "id")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String cpfOrCnpj;
    private LocalDate birthDate;

    @Column(columnDefinition = "text")
    private String note;

    @OneToMany
    @JoinTable(name = "tb_client_phones",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "phone_id"))
    private List<Phone> phones = new ArrayList<>();

    @OneToMany
    @JoinTable(name = "tb_client_devices",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "device_id"))
    private List<Device> devices = new ArrayList<>();

    private Boolean active;

    @Column(updatable = false)
    private LocalDate moment;

}
