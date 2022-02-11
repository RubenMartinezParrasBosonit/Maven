import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaPrueba {
    private NombreApellidos nombreApellidos;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class NombreApellidos{
    String nombre;
    String apellidos;
}


