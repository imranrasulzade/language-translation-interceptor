package com.e_sys.languageinterceptor.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Translation name;
    private String email;
    private String phone;
    private Boolean status;
}
