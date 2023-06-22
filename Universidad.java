import java.util.ArrayList;
import java.util.List;

public class Universidad {
    private String nombre;
    private List<String> direcciones;
    private String tipo;
    private List<Facultad> facultades;

    public Universidad(String nombre, List<String> direcciones, String tipo) {
        this.nombre = nombre;
        this.direcciones = direcciones;
        this.tipo = tipo;
        this.facultades = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<String> direcciones) {
        this.direcciones = direcciones;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Facultad> getFacultades() {
        return facultades;
    }

    public void setFacultades(List<Facultad> facultades) {
        this.facultades = facultades;
    }

    public List<Profesor> getProfesores() {
        List<Profesor> profesores = new ArrayList<>();
        for (Facultad facultad : facultades) {
            profesores.addAll(facultad.getProfesores(null));
        }
        return profesores;
    }

    public List<Administrativo> getAdministrativos() {
        List<Administrativo> administrativos = new ArrayList<>();
        for (Facultad facultad : facultades) {
            administrativos.addAll(facultad.getAdministrativos());
        }
        return administrativos;
    }
}

public class Facultad {
    private String nombre;
    private String ubicacion;
    private List<Departamento> departamentos;

    public Facultad(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.departamentos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public List<Profesor> getProfesores(String nombreProfesor) {
        List<Profesor> profesoresEncontrados = new ArrayList<>();
        for (Departamento departamento : departamentos) {
            profesoresEncontrados.addAll(departamento.getProfesores(nombreProfesor));
        }
        return profesoresEncontrados;
    }

    public List<Carrera> getCarreras() {
        List<Carrera> carreras = new ArrayList<>();
        for (Departamento departamento : departamentos) {
            carreras.addAll(departamento.getCarreras());
        }
        return carreras;
    }
}

public class Departamento {
    private String nombre;
    private List<Administrativo> administrativos;
    private List<Profesor> profesores;
    private List<Carrera> carreras;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.administrativos = new ArrayList<>();
        this.profesores = new ArrayList<>();
        this.carreras = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Administrativo> getAdministrativos() {
        return administrativos;
    }

    public void setAdministrativos(List<Administrativo> administrativos) {
        this.administrativos = administrativos;
    }

    public List<Profesor> getProfesores(String tipoContrato) {
        List<Profesor> profesoresFiltrados = new ArrayList<>();
        for (Profesor profesor : profesores) {
            if (tipoContrato == null || profesor.getTipoContrato().equals(tipoContrato)) {
                profesoresFiltrados.add(profesor);
            }
        }
        return profesoresFiltrados;
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }
}

public abstract class Trabajador {
    private String titulo;
    private String nombre;
    private String direccion;
    private String estadoCivil;
    private String rut;
    private String horario;

    public Trabajador(String titulo, String nombre, String direccion, String estadoCivil, String rut, String horario) {
        this.titulo = titulo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.estadoCivil = estadoCivil;
        this.rut = rut;
        this.horario = horario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public abstract String getTipo();
}

public class Profesor extends Trabajador {
    private String tipoContrato;

    public Profesor(String titulo, String nombre, String direccion, String estadoCivil, String rut, String horario, String tipoContrato) {
        super(titulo, nombre, direccion, estadoCivil, rut, horario);
        this.tipoContrato = tipoContrato;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    @Override
    public String getTipo() {
        return "Profesor";
    }
}

public class Administrativo extends Trabajador {
    public Administrativo(String titulo, String nombre, String direccion, String estadoCivil, String rut, String horario) {
        super(titulo, nombre, direccion, estadoCivil, rut, horario);
    }

    @Override
    public String getTipo() {
        return "Administrativo";
    }
}

public class Carrera {
    private String nombre;

    public Carrera(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

public class Main {
    public static void main(String[] args) {
        // Crear objetos de prueba
        Universidad universidad = new Universidad("Universidad XYZ", new ArrayList<>(), "Privada");

        Facultad facultad1 = new Facultad("Facultad de Ciencias", "Ubicación 1");
        facultad1.getDepartamentos().add(new Departamento("Departamento 1"));
        facultad1.getDepartamentos().add(new Departamento("Departamento 2"));

        Facultad facultad2 = new Facultad("Facultad de Ingeniería", "Ubicación 2");
        facultad2.getDepartamentos().add(new Departamento("Departamento 3"));
        facultad2.getDepartamentos().add(new Departamento("Departamento 4"));

        universidad.getFacultades().add(facultad1);
        universidad.getFacultades().add(facultad2);

        Departamento departamento1 = facultad1.getDepartamentos().get(0);
        departamento1.getProfesores().add(new Profesor("Licenciado", "Juan Pérez", "Dirección 1", "Soltero", "123456789", "9:00 - 18:00", "Jornada Completa"));
        departamento1.getProfesores().add(new Profesor("Ingeniero", "María López", "Dirección 2", "Casado", "987654321", "8:00 - 14:00", "Media Jornada"));
        departamento1.getProfesores().add(new Profesor("Doctor", "Carlos González", "Dirección 3", "Soltero", "456789123", "13:00 - 20:00", "Jornada Parcial"));

        Departamento departamento2 = facultad1.getDepartamentos().get(1);
        departamento2.getProfesores().add(new Profesor("Licenciado", "Ana Rodríguez", "Dirección 4", "Casado", "321654987", "10:00 - 16:00", "Media Jornada"));

        Departamento departamento3 = facultad2.getDepartamentos().get(0);
        departamento3.getProfesores().add(new Profesor("Ingeniero", "Pedro Gómez", "Dirección 5", "Soltero", "654789321", "9:00 - 18:00", "Jornada Completa"));
        departamento3.getProfesores().add(new Profesor("Licenciado", "Laura Torres", "Dirección 6", "Casado", "789123456", "8:00 - 14:00", "Media Jornada"));

        Departamento departamento4 = facultad2.getDepartamentos().get(1);
        departamento4.getProfesores().add(new Profesor("Doctor", "Andrés Sánchez", "Dirección 7", "Soltero", "987321654", "13:00 - 20:00", "Jornada Parcial"));
        departamento4.getAdministrativos().add(new Administrativo("Técnico", "Roberto Silva", "Dirección 8", "Casado", "852369741", "9:00 - 18:00"));

        // Ejemplo de uso de los métodos

        // Obtener todos los profesores de una facultad por nombre
        List<Profesor> profesoresFacultad = facultad1.getProfesores("Juan Pérez");
        System.out.println("Profesores de la facultad: " + profesoresFacultad.size());

        // Obtener todas las carreras universitarias de una facultad
        List<Carrera> carrerasFacultad = facultad2.getCarreras();
        System.out.println("Carreras de la facultad: " + carrerasFacultad.size());

        // Obtener todos los profesores contratados a jornada parcial de un departamento
        List<Profesor> profesoresJornadaParcial = departamento4.getProfesores("Jornada Parcial");
        System.out.println("Profesores contratados a jornada parcial: " + profesoresJornadaParcial.size());

        // Obtener todos los profesores de la universidad
        List<Profesor> todosLosProfesores = universidad.getProfesores();
        System.out.println("Todos los profesores de la universidad: " + todosLosProfesores.size());

        // Obtener todos los administrativos de la universidad
        List<Administrativo> todosLosAdministrativos = universidad.getAdministrativos();
        System.out.println("Todos los administrativos de la universidad: " + todosLosAdministrativos.size());
    }
}
