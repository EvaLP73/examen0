package org.example.entidades;

import com.mysql.cj.Session;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "director")
public class Director {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "codigoCuerpo")
    private String codigoCuerpo;

    @NonNull
    @Column(name = "edad")
    private int edad;

    @Column(name = "nombre")
    private String nombre;

    @OneToOne(mappedBy = "director", cascade = CascadeType.ALL, orphanRemoval = true)
    private Instituto instituto;
}
