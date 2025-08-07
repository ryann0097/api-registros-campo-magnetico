package br.com.desafiopotiguar.DesafioPotiguar.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private LocalDateTime timeStampInicio;
    private LocalDateTime timeStampFim;
    private Long duracao;
}
