package br.com.Okena.service;

import br.com.Okena.domain.bairro.dto.BairroRequestDTO;
import br.com.Okena.domain.bairro.dto.BairroResponseDTO;
import br.com.Okena.domain.bairro.dto.BairroUpdateDTO;
import br.com.Okena.domain.bairro.Bairro;
import br.com.Okena.repository.BairroRepository;
import br.com.Okena.infra.error.exceptions.BairroNotFoundException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BairroService {

    private final BairroRepository bairroRepository;

    public BairroService(BairroRepository bairroRepository){
        this.bairroRepository = bairroRepository;
    }

    public List<BairroResponseDTO> obterBairros() {
        return bairroRepository.findAll().stream().map(this::toResponse).toList();
    }

    public void addBairro(BairroRequestDTO dados){
        Bairro bairro = new Bairro(dados);
        bairroRepository.save(bairro);
    }

    public void updateBairro(BairroUpdateDTO dados) {
        if(bairroRepository.existsById(dados.id())){
            Bairro bairro = bairroRepository.getReferenceById(dados.id());
            bairro.update(dados);
        }
    }

    public void deleteBairro(Long id) {
        if(bairroRepository.existsById(id)){
            bairroRepository.deleteById(id);
        } else {
            System.out.println("id não encontado");
        }

    }

    public BairroResponseDTO getById(Long id) {
        Bairro bairro = bairroRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, "Bairro"));
        return toResponse(bairro);
    }

    public Bairro getBairroById(Long id) {
        return bairroRepository.findById(id)
                .orElseThrow(() -> new BairroNotFoundException(id));
    }

    private BairroResponseDTO toResponse(Bairro b){
        return new BairroResponseDTO(
                b.getId(),
                b.getNome(),
                b.getLatitude(),
                b.getLongitude()
        );
    }



}
