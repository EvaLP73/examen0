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
@Table(name = "taller")
public class Taller {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
