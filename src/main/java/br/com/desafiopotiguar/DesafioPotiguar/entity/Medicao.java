package br.com.desafiopotiguar.DesafioPotiguar.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Medicao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private double campo_magnetico;
    private double tensao;
    private double temperatura;

    @ManyToOne
    @JoinColumn(name = "bobina_id")
    private Bobina bobina;

    @ManyToOne
    @JoinColumn(name = "registro_id")
    private Registro registro;
}
