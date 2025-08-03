package br.biblioteca.project.service;

import br.biblioteca.project.model.BibliotecaEntity;
import br.biblioteca.project.repository.BibliotecaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecaService {

    private final BibliotecaRepository bibliotecaRepository;
    public BibliotecaService(BibliotecaRepository bibliotecaRepository) {
        this.bibliotecaRepository = bibliotecaRepository;
    }

    public BibliotecaEntity save(BibliotecaEntity bibliotecaEntity) {
       return bibliotecaRepository.save(bibliotecaEntity);
    }

    public List<BibliotecaEntity> findAll(){
        return bibliotecaRepository.findAll();
    }

    public BibliotecaEntity findById(Integer id){
        return bibliotecaRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public BibliotecaEntity update(Integer id, BibliotecaEntity bibliotecaEntity){
        BibliotecaEntity update = findById(id);

        if(bibliotecaEntity.getNome() != null && !bibliotecaEntity.getNome().isBlank()){
            update.setNome(bibliotecaEntity.getNome());
        }

        if(bibliotecaEntity.getTelefone() != null && !bibliotecaEntity.getTelefone().isBlank()){
            update.setTelefone(bibliotecaEntity.getTelefone());
        }

        return bibliotecaRepository.save(update);
    }

    public void delete(Integer id){
        BibliotecaEntity delete =findById(id);
        bibliotecaRepository.delete(delete);
    }
}
