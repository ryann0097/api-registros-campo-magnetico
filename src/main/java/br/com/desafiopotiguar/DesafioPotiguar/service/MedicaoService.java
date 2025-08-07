package br.com.desafiopotiguar.DesafioPotiguar.service;

import br.com.desafiopotiguar.DesafioPotiguar.dto.MedicaoDTO;
import br.com.desafiopotiguar.DesafioPotiguar.entity.Medicao;
import br.com.desafiopotiguar.DesafioPotiguar.entity.Registro;
import br.com.desafiopotiguar.DesafioPotiguar.repository.BobinaRepository;
import br.com.desafiopotiguar.DesafioPotiguar.repository.MedicaoRepository;
import br.com.desafiopotiguar.DesafioPotiguar.repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.time.LocalDateTime;

@Service
public class MedicaoService {
    @Autowired
    MedicaoRepository repository;

    @Autowired
    BobinaRepository bobinaRepository;

    @Autowired
    RegistroRepository registroRepository;

    public Medicao salvar(MedicaoDTO dto){
        Registro registro = new Registro();

        LocalDateTime timestampFinal = LocalDateTime.now();
        LocalDateTime timestampInicio = timestampFinal.minusMinutes(5);
        Duration duracao = java.time.Duration.between(timestampInicio, timestampFinal);
        Long duracaoSegundos = duracao.getSeconds();

        registro.setTimeStampInicio(timestampInicio);
        registro.setTimeStampFim(timestampFinal);
        registro.setDuracao(duracaoSegundos);

        Registro registro1 = registroRepository.save(registro);

        Medicao m = new Medicao();
        m.setCampo_magnetico(dto.getCampo_magnetico());
        m.setTemperatura(dto.getTemperatura());
        m.setTensao(dto.getTensao());
        m.setBobina(bobinaRepository.findById(dto.getBobinaId()).orElse(null));
        m.setRegistro(registro1);

        return repository.save(m);
    }

    public List<Medicao> listarTodas() {
        return repository.findAllWithBobina();
    }
}
