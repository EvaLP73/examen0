package org.example.entidades;

import com.mysql.cj.Session;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UsoId {


    @NonNull
    @Column(name = "taller_codigo")
    private int tallerId;

    @NonNull
    @Column(name = "ciclo_codigo")
    private int cicloId;

    @NonNull
    @Column(name = "hora", columnDefinition = "TIME")
    private LocalTime hora;

    @NonNull
    @Column(name = "fecha", columnDefinition = "DATE")
    private LocalDate fecha;
}
