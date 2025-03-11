package com.nahdaicue.peluqueriacanina.logica;

import com.nahdaicue.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.List;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    //Crear---------------------------------------------------------------------
    public void guardar(String nombreMasco, String raza, String color,
            String observaciones, String alergico, String atenEsp,
            String nombreDuenio, String celDuenio) {

        //Crear duenio
        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);

        //Crear mascota
        Mascota masco = new Mascota();
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atenEsp);

        //Enlazar mascota a dueño
        masco.setUnDuenio(duenio);

        //Mandar a persistencia
        controlPersis.guardar(duenio, masco);
    }

    public List<Mascota> traerMascotas() {
        return controlPersis.traerMascotas();
    }

    public void borrarMascota(int num_cliente) {
        controlPersis.borrarMascota(num_cliente);
    }

    public Mascota traerMascota(int num_cliente) {
        return controlPersis.traerMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco, String nombreMasco, String raza, String color, String observaciones, String alergico, String atenEsp, String nombreDuenio, String celDuenio) {

        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atenEsp);

        //Modifico mascota
        controlPersis.modificarMascota(masco);
        
        //Setteo valor de duenio
        Duenio duenio = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);
        
        //Modifico duenio
        this.modificarDuenio(duenio);
    }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio duenio) {
        controlPersis.modificarDuenio(duenio);
    }

    public List<Mascota> buscarMascotas(String filtro) {
    List<Mascota> todasMascotas = traerMascotas();  // Obtener todas las mascotas
    List<Mascota> filtrados = new ArrayList<>();

    // Filtrar por nombre, raza y duenio
    for (Mascota mascota : todasMascotas) {
        if (mascota.getNombre().toLowerCase().contains(filtro.toLowerCase()) ||
            mascota.getRaza().toLowerCase().contains(filtro.toLowerCase()) ||
            mascota.getUnDuenio().getNombre().toLowerCase().contains(filtro.toLowerCase())) {
            filtrados.add(mascota);
        }
    }

    return filtrados;
}
}
