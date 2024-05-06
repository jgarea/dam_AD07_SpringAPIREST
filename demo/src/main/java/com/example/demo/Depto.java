package com.example.demo;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "depto")
public class Depto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numdep")
    private Long numdep;

    @NonNull
    @Column(name = "nomdep", length = 14)
    private String nomdep;

    @NonNull
    @Column(name = "localidad", length = 13)
    private String localidad;

}
