package umg.edu.gt.examenfinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="task")
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="titulo", nullable = true)
    private String titulo;

    @Column(name="descripcion", nullable = true)
    private String descripcion;

    @Column(name="fecha", nullable = true)
    private String fecha;

    @Column(name="responsable", nullable = true)
    private String responsable;

}
