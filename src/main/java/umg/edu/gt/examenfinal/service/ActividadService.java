package umg.edu.gt.examenfinal.service;

import java.util.List;

import umg.edu.gt.examenfinal.model.Actividad;

public interface ActividadService {
    Actividad saveActividad(Actividad actividad);
    List<Actividad> listActividades();
    Actividad getActividad(int id);
    Actividad updateActividad(Actividad actividad, int id);
    void deleteActividad(int id);
}
