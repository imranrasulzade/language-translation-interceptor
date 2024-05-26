package com.e_sys.languageinterceptor.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class CampaignType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Translation type;
}
