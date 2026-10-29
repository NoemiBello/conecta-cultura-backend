
package cl.duoc.actividades.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "actividad")
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    private String descripcion;

    @Min(value = 0, message = "El precio no puede ser negativo")
    private Integer precio;

    @Min(value = 0, message = "Los cupos no pueden ser negativos")
    private Integer cupos;

    private String categoria;
}
