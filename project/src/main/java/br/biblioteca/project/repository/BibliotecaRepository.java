package br.biblioteca.project.repository;

import br.biblioteca.project.model.BibliotecaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecaRepository extends JpaRepository<BibliotecaEntity, Integer> {
}
