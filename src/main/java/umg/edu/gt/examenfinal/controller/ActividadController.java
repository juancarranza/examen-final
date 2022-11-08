package umg.edu.gt.examenfinal.controller;

import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import umg.edu.gt.examenfinal.model.Actividad;
import umg.edu.gt.examenfinal.service.ActividadService;

@RestController
@RequestMapping("/actividades")
public class ActividadController {
    
    private ActividadService actividadService;

    public ActividadController(ActividadService actividadService) {
        this.actividadService = actividadService;
    }

    @PostMapping()
    public ResponseEntity<Actividad> saveActividad(@RequestBody Actividad actividad){
        return new ResponseEntity<Actividad>(actividadService.saveActividad(actividad), HttpStatus.CREATED);
    }

    //Get all Actividades
    @GetMapping()
    public List<Actividad> getAllActividades(){
        return actividadService.listActividades();
    }

    // Get Actividad by ID
    @GetMapping("{id}")
   public ResponseEntity<Actividad> getActividad(@PathVariable("id") int id){
        return new ResponseEntity<Actividad>(actividadService.getActividad(id), HttpStatus.OK);
    }

    // Update Actividad
    @PutMapping("{id}") 
    public ResponseEntity<Actividad> updateActividad(@PathVariable("id") int id, @RequestBody Actividad actividad){
        return new ResponseEntity<Actividad>(actividadService.updateActividad(actividad, id), HttpStatus.OK);
    }

    //Delete Actividad 
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteActividad(@PathVariable("id") int id){
        actividadService.deleteActividad(id); 

        return new ResponseEntity<String>("Actividad eliminada correctamente", HttpStatus.OK);   
    }
}
