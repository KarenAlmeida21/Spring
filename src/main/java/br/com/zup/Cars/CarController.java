package br.com.zup.Cars;

import br.com.zup.Cars.DTO.CarroDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
@RequestMapping("/car")
public class CarController {
    @GetMapping("/fusca")

    public CarroDto exibirFusca() {
        CarroDto fusca = new CarroDto("fusca", "branco", "mil", 1971);
        return fusca;
    }

    @GetMapping("gol")
    public CarroDto exibirGol() {
        CarroDto gol = new CarroDto("gol", "branco", "1.4", 2014);
        return gol;
    }
}
