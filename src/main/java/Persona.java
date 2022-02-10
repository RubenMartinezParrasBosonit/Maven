import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Persona {
    private String nombre;
    private String poblacion;
    private String edad;


    public Persona(String[] persona) {

        //Aquí usamos Optional para hacer más cómodo el manejo de nulos.
        Optional<String> optName;
        Optional<String> optPoblacion;
        Optional<String> optEdad;

        try{
            optName = Optional.of(persona[0]);
        }catch(IndexOutOfBoundsException e){
            optName = Optional.of("Desconocido");
        }

        try{
            optPoblacion = Optional.of(persona[1]);
        } catch (IndexOutOfBoundsException e){
            optPoblacion = Optional.of("Desconocida");
        }

        try {
            optEdad = Optional.of(persona[2]);
        } catch (IndexOutOfBoundsException e) {
            optEdad = Optional.of("999");
        }

        this.setNombre(optName.get());
        this.setPoblacion(optPoblacion.orElse("Desconocida"));
        this.setEdad(optEdad.get());
    }

    public int getEdadInt() {
        return Integer.parseInt(edad);
    }

    @Override
    public String toString() {
        return ("Nombre: " + this.nombre + ", Población: " + this.poblacion + ", Edad: " + this.edad);
    }
}