package br.com.controletreinamento.ControleTreinamento.controller;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.controletreinamento.ControleTreinamento.model.Treinamento;
import br.com.controletreinamento.ControleTreinamento.repository.TreinamentoRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/treinamento")
public class TreinamentoController {

    private final TreinamentoRepository treinamentoRepository ;

    public TreinamentoController(TreinamentoRepository treinamentoRepository) {
        this.treinamentoRepository = treinamentoRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void salvar(@RequestBody Treinamento treinamento){
        treinamentoRepository.save(treinamento);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Treinamento> listaTreinamento(){
        return treinamentoRepository.findAll();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void editar(Long id, @RequestBody Treinamento treinamento){
        if(treinamentoRepository.existsById(id)){
            treinamento.setId(id);
            treinamentoRepository.save(treinamento);
        } else {
            System.out.println("Não encontrado.");
        }
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deletar(Long id){
        Optional<Treinamento> treinamentoOptional = treinamentoRepository.findById(id);
        if(treinamentoOptional.isPresent()){
            Treinamento treinamento = treinamentoOptional.get();
            treinamentoRepository.delete(treinamento);
        }
    }

}
