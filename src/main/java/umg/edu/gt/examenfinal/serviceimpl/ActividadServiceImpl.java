package umg.edu.gt.examenfinal.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.servlet.annotation.ServletSecurity.EmptyRoleSemantic;

import org.springframework.stereotype.Service;

import umg.edu.gt.examenfinal.model.Actividad;
import umg.edu.gt.examenfinal.repository.ActividadRepository;
import umg.edu.gt.examenfinal.service.ActividadService;

@Service
public class ActividadServiceImpl implements ActividadService{

    private ActividadRepository actividadRepository;
  
    public ActividadServiceImpl(ActividadRepository actividadRepository) {
        this.actividadRepository = actividadRepository;
    }
    @Override
    public Actividad saveActividad(Actividad actividad) {
        return actividadRepository.save(actividad);
    }
    @Override
    public List<Actividad> listActividades() {
        return actividadRepository.findAll();
    }
    @Override
    public Actividad getActividad(int id) {
        Optional<Actividad> actividad =actividadRepository.findById(id);
        
        if(actividad.isPresent()){
            return actividad.get();
        }else{
            throw new EntityNotFoundException();
        }
        
    }
    @Override
    public Actividad updateActividad(Actividad actividad, int id) {
        
        Actividad existingActividad = actividadRepository.findById(id).orElseThrow(null);

        existingActividad.setTitulo(actividad.getTitulo());
        existingActividad.setDescripcion(actividad.getDescripcion());
        existingActividad.setFecha(actividad.getFecha());
        existingActividad.setResponsable(actividad.getResponsable());
        //save
        actividadRepository.save(existingActividad);
        return existingActividad;

    }
    @Override
    public void deleteActividad(int id) {
        actividadRepository.findById(id).orElseThrow(null);
        actividadRepository.deleteById(id);
    }

    
    
    
}
