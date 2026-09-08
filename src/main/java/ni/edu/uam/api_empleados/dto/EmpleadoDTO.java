package ni.edu.uam.api_empleados.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class EmpleadoDTO {

    private Long id;

    @NotBlank(message = "Los nombres son obligatorios")
    @Size(
            min = 2,
            max = 60,
            message = "Los nombres deben tener entre 2 y 60 caracteres"
    )
    private String nombres;

    @NotBlank(message = "Los apellidos son obligatorios")
    @Size(
            min = 2,
            max = 60,
            message = "Los apellidos deben tener entre 2 y 60 caracteres"
    )
    private String apellidos;

    @NotBlank(message = "El cargo es obligatorio")
    @Size(
            min = 2,
            max = 50,
            message = "El cargo debe tener entre 2 y 50 caracteres"
    )
    private String cargo;

    @NotNull(message = "El salario es obligatorio")
    @DecimalMin(
            value = "0.0",
            inclusive = false,
            message = "El salario debe ser mayor que 0"
    )
    private BigDecimal salario;
}