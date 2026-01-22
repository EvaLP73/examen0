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
@Table(name = "instituto")
public class Instituto {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tf", columnDefinition = "CHAR")
    private String telefono;

    @Column(name = "director")
    private int directorId;

    @OneToOne
    @JoinColumn(name = "instituto")
    private Director director;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "ies_ciclos",
            joinColumns = @JoinColumn(name = "cod_instituto"),
            inverseJoinColumns = @JoinColumn(name = "cod_ciclo")
                )
    private List<Ciclo> ciclos;


    public Instituto(String nombreInstituto, String telefono, String director) {
    }
}
