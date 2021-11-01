package br.com.zup.Cars;

import br.com.zup.Cars.DTO.CarroDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    public List<CarroDto> garagem = new ArrayList<>();

    public List<CarroDto> pegarCars() {
        return garagem;
    }
//método para salvar carros na lista
    public void salvarCar(CarroDto carroDto) {
        garagem.add(carroDto);
    }

    //método para buscar carro especifico
    public CarroDto buscarCar(String nomeDoCarro) {
        for (CarroDto carroReferencia : garagem) {
            if (carroReferencia.getModelo().equalsIgnoreCase(nomeDoCarro)) {
                return carroReferencia;
            }

        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    //metodo para atualizar dados de um carro
    public CarroDto atualizarCar(String nomeDoCarro, CarroDto carroDto) {
        CarroDto carro = buscarCar(nomeDoCarro);
        carro.setCor(carroDto.getCor());
        carro.setAno(carroDto.getAno());
        carro.setMotor(carroDto.getMotor());
        return carro;
    }

    //metodo para deletar carro especifico
    public void excluirCar(String nomeDoCarro) {
        CarroDto carro = buscarCar(nomeDoCarro);
        garagem.remove(carro);

    }
}
