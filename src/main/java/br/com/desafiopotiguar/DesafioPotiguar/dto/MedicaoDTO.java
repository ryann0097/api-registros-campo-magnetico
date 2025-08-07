package br.com.desafiopotiguar.DesafioPotiguar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicaoDTO {
    public Integer bobinaId;
    public Integer registroId;
    public double campo_magnetico;
    public double tensao;
    public double temperatura;
}