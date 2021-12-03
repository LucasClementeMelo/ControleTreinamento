package br.com.controletreinamento.ControleTreinamento.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.controletreinamento.ControleTreinamento.model.Empregado;
import br.com.controletreinamento.ControleTreinamento.repository.EmpregadoRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empregado")
public class EmpregadoController {

    private final EmpregadoRepository empregadoRepository;

    public EmpregadoController(EmpregadoRepository empregadoRepository) {
        this.empregadoRepository = empregadoRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void salvarEmpregado(@RequestBody Empregado empregado){
        empregadoRepository.save(empregado);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Empregado> listarEmpregados(){
        return empregadoRepository.findAll();
    }

    @PutMapping
    @Transactional
    public void editar(Long id, @RequestBody Empregado empregado){
        if(empregadoRepository.existsById(id)){
           empregado.setId(id);
           empregadoRepository.save(empregado);
        } else {
            System.out.println("Não encontrado.");
        }

    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deletar(Long id){
        Optional<Empregado> empregadoOptional = empregadoRepository.findById(id);
        if(empregadoOptional.isPresent()){
            Empregado empregado = empregadoOptional.get();
            empregadoRepository.delete(empregado);
        }
    }

}
