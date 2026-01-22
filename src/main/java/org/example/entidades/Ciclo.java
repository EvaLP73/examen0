package org.example.entidades;

import com.mysql.cj.Session;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "ciclo")
public class Ciclo {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int id;

    @Column(name = "nombreCiclo")
    private String nombreCiclo;

    //lado inverso, no tiene FK, mappedBy
    @ManyToMany(mappedBy = "ciclos")
    private List<Instituto> institutos;

    @OneToMany(mappedBy = "ciclo")
    private List<Uso> usos;
}
