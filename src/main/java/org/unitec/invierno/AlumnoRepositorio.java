/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.invierno;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface AlumnoRepositorio extends MongoRepository<Alumno,String> {
    
}
