import org.modelmapper.ModelMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        // En estas primeras líneas, leemos el fichero, lo dividimos usando el delimitador ":" y
        // añadimos a las personas
        // a nuestra lista de tipo Persona
        File doc =
                new File(
                        "C:\\Users\\ruben.mparras\\IdeaProjects\\EjMaven\\personas.txt");

        BufferedReader obj = new BufferedReader(new FileReader(doc));
        List<Persona> personas = new ArrayList();
        String strng;
        String[] splitText;
        while ((strng = obj.readLine()) != null) {
            splitText = strng.split(":");
            personas.add(new Persona(splitText));
            Arrays.fill(splitText, null);
        }

        // Con este fragmento de código, filtro las poblaciones que tienen "" y las cambio "Desconocida"
        // usando stream(). Se ha intentado usar expresiones regulares como \\S, pero no he conseguido que funcione
        personas.stream()
                .filter(persona -> persona.getPoblacion() == "")
                .forEach(
                        (p) -> {
                            p.setPoblacion("Desconocida");
                        });


        //Intento de uso de Pattern para cambiar los nombres de las poblaciones vacías
    /*Pattern patron = Pattern.compile("\\D+");
    Stream<List<Persona>> personaStream = Stream.of(personas);

      personaStream
        .filter(patron.asPredicate())
        .forEach(
            (p) -> {
              p.setPoblacion("Desconocida");
            });*/

        // En este fragmento, filtramos y mostramos las personas que tienen menos de 25 años
        personas.stream()
                .filter(persona -> persona.getEdadInt() < 25)
                .forEach(
                        (p) -> {
                            System.out.println(p);
                        });

        // Si queremos meter a las personas filtradas en una lista, se haría así.
    /*List<Persona> personaFiltro = personas.stream().filter(persona -> persona.getEdadInt() < 25).collect(Collectors.toList());
    personaFiltro.stream().forEach((p)-> {
        System.out.println(p.getNombre());
        System.out.println(p.getPoblacion());
        System.out.println(p.getEdad());
    });*/

        //Testeando ModelMapper
        PersonaPrueba personaPrueba = new PersonaPrueba(new NombreApellidos("Rubén", "Martínez"));
        ModelMapper modelMapper = new ModelMapper();
        PersonaPruebaDTO personaPruebaDTO = modelMapper.map(personaPrueba, PersonaPruebaDTO.class);
        System.out.println(personaPrueba);
        System.out.println(personaPruebaDTO);
        //Funciona perfectamente

    }


}
