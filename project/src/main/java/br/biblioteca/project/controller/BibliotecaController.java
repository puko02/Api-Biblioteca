package br.biblioteca.project.controller;

import br.biblioteca.project.model.BibliotecaEntity;
import br.biblioteca.project.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblioteca")
public class BibliotecaController {

    @Autowired
    private final BibliotecaService bibliotecaService;

    public BibliotecaController(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<BibliotecaEntity>> findAll() {
        try {
            var result = bibliotecaService.findAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<BibliotecaEntity> findById (@PathVariable Integer id){
        try{
            var result = bibliotecaService.findById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<BibliotecaEntity> save(@RequestBody BibliotecaEntity bibliotecaEntity) {
        try {
            var result = bibliotecaService.save(bibliotecaEntity);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BibliotecaEntity> update(@PathVariable Integer id, @RequestBody BibliotecaEntity bibliotecaUpdate){
        try {
            var result = bibliotecaService.update(id, bibliotecaUpdate);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BibliotecaEntity> delete(@PathVariable Integer id){
        try {
            bibliotecaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }
}