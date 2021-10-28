package br.com.zup.Cars;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class CarController {
    @GetMapping("/car/fusca")
    @ResponseBody
    public HashMap<String, String>exibirFusca() {
        HashMap<String, String> fusca = new HashMap<>();
        fusca.put("Cor", "Azul");
        fusca.put("Ano", "1994");
        fusca.put("Motor", "Mil");
        return fusca;
    }
}
