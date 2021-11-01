package br.com.zup.Cars;

import br.com.zup.Cars.DTO.CarroDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    //Exibir lista de cars
    @GetMapping()
    public List<CarroDto> ExibirCars() {
        return carService.pegarCars();
    }

    //Cadastrar Cars
     @PostMapping()
    public void CadastrarCar(@RequestBody CarroDto carroDto) {
        carService.salvarCar(carroDto);
    }

    //Exibir carro especifico
    @GetMapping("/{nomeDoCarro}")
    public CarroDto exibirCar(@PathVariable String nomeDoCarro) {
        return carService.buscarCar(nomeDoCarro);
    }

    //Atualizar dados de um carro
    @PutMapping("{/nomeDoCarro}")
    public CarroDto atualizarCar(@PathVariable String nomeDoCarro, @RequestBody CarroDto carroDTO) {
        return carService.atualizarCar(nomeDoCarro, carroDTO);
    }

    //Deletar carro especifico
    @DeleteMapping("{/nomeDoCarro}")
    public void excluirCar(@PathVariable String nomeDoCarro) {
        carService.excluirCar(nomeDoCarro);
    }

}






