package com.scan.secure.dao;

import com.scan.secure.model.SegUsuarios;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author joel.sandoval
 */
//@Service
@Repository
public interface SegUsuariosRepository  extends PagingAndSortingRepository<SegUsuarios, Integer>{
    
    static final Logger LOGGER = LoggerFactory.getLogger(SegUsuariosRepository.class);      
       
    List<SegUsuarios> findByEstatus(@Param("estatus") Integer estatus);
    
    SegUsuarios findByUsuario(@Param("usuario") String usuario); 
    
    SegUsuarios findByIdAndEstatus(Integer usuario, Integer estatus);
    
    @Query("Select u From SegUsuarios u Where u.id = :usuario and u.estatus = 1")
    SegUsuarios damePorIdEstatus();
    
        
}
