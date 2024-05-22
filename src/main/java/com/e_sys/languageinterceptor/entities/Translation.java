package com.e_sys.languageinterceptor.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
@Table
public class Translation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String az;
    private String ru;
    private String en;
    private String parentTable;
    private String parentId;
    private Boolean status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Translation that)) return false;
        return Objects.equals(getAz(), that.getAz()) && Objects.equals(getRu(), that.getRu()) && Objects.equals(getEn(), that.getEn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAz(), getRu(), getEn());
    }
}
