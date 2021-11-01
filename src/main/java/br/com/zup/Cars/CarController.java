package br.com.zup.Cars;

import br.com.zup.Cars.DTO.CarroDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

import java.util.List;


@RestController
@RequestMapping("/car")
public class CarController {
    public List<CarroDto> garagem = new ArrayList<>();

    @GetMapping()
    public List<CarroDto> ExibirCars() {
        return garagem;
    }

    @PostMapping()
    public void CadastrarCar(@RequestBody CarroDto carroDto) {
        garagem.add(carroDto);
    }

//método para exibir carro especifico
    @GetMapping("/{nomeDoCarro}")
    public CarroDto exibirCar(@PathVariable String nomeDoCarro) {
       for (CarroDto carroReferencia : garagem) {
            if (carroReferencia.getModelo().equalsIgnoreCase(nomeDoCarro)
            ) {
                   return carroReferencia;
            }

        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    //metodo para atualizar dados de um carro
    @PutMapping("{/nomeDoCarro")
    public CarroDto atualizarCar(@PathVariable String nomeDoCarro, @RequestBody CarroDto carroDTO){
        for (CarroDto carroReferencia:garagem) {
            if(carroReferencia.getModelo().equalsIgnoreCase(nomeDoCarro)){
                carroReferencia.setCor(carroDTO.getCor());
                carroReferencia.setAno(carroDTO.getAno());
                carroReferencia.setMotor(carroDTO.getMotor());
                return carroReferencia;
            }

        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

}




