package br.com.zup.Cars;

import br.com.zup.Cars.DTO.CarroDto;
import org.springframework.web.bind.annotation.*;

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




}




