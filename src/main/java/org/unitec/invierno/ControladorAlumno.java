/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.invierno;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ControladorAlumno {
    
  @Autowired AlumnoRepositorio alumnRepo;
  
  //Este metodo busca todos los alumnos guardados (SI ES QUE HAY)
  @GetMapping("/alumno")
    public List<Alumno> buscarTodos()throws Exception{
            return alumnRepo.findAll();
       
  }
   
    //EL METODO PARA GUARDAR UN NUEVO ALUMNO 
        @PostMapping("/alumno")
        public Estatus guardarAlumno(@RequestBody String json) throws Exception{
           
    //Primero el cuerpo que llega lo deserializamos  
            ObjectMapper maper= new ObjectMapper();
    
    //Ahora si lo mapeamos 
            Alumno a=maper.readValue(json, Alumno.class);
    
    //Ahora si guardaremos
                alumnRepo.save(a);
                
    //Debemos informar el response al cliente que mas adelante sera android
                Estatus e=new Estatus();
                e.setMensaje("Alumno e guardo con exito ");
                e.setSuccess(true);
                return e;
        }      
                        
    }
