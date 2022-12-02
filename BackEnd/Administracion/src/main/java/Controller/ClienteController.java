package Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @GetMapping ("/nombre")
    public String nombre() {
        return "Titulo";
    }

    @GetMapping ("/descripcion")
    public String descripcion() {
        return "Descripcion";
    }
}
