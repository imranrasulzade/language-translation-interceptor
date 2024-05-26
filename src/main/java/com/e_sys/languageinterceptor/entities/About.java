package com.e_sys.languageinterceptor.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class About {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Translation title;
    @OneToOne(cascade = CascadeType.ALL)
    private Translation content;
}
