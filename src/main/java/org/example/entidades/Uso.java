package org.example.entidades;

import com.mysql.cj.Session;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "uso")
public class Uso {


    @EmbeddedId
    private UsoId id;

    @ManyToOne
    @MapsId("cicloId")
    @JoinColumn(name = "ciclo_codigo")
    private Ciclo ciclo;

    @ManyToOne
    @MapsId("tallerId")
    @JoinColumn(name = "taller_codigo")
    private Taller taller;
}
