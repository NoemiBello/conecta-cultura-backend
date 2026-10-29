
package cl.duoc.actividades.controller;

import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import cl.duoc.actividades.model.Actividad;
import cl.duoc.actividades.services.ActividadService;

import java.util.List;

@RestController
@RequestMapping("/api/actividades")
public class ActividadController {

    private final ActividadService service;

    public ActividadController(ActividadService service) {
        this.service = service;
    }

    @GetMapping
    public List<Actividad> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Actividad buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PostMapping
    public ResponseEntity<Actividad> crear(@Valid @RequestBody Actividad actividad) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.guardar(actividad));
    }

    @PutMapping("/{id}")
    public Actividad actualizar(@PathVariable Long id,
            @Valid @RequestBody Actividad actividad) {
        return service.actualizar(id, actividad);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
