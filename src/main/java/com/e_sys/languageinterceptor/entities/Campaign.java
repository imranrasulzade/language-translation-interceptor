package com.e_sys.languageinterceptor.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table
@NoArgsConstructor
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Translation header;
    @OneToOne(cascade = CascadeType.ALL)
    private Translation contentHeader;
    @OneToOne(cascade = CascadeType.ALL)
    private Translation content;
}
