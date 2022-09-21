package com.scan.secure.dao;

import com.scan.secure.model.IPermisos;
import com.scan.secure.model.SegGrupos;
import com.scan.secure.model.SegGruposPermisos;
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
public interface SegGruposPermisosRepository  extends PagingAndSortingRepository<SegGruposPermisos, Integer>{
    
    static final Logger LOGGER = LoggerFactory.getLogger(SegGruposPermisosRepository.class);      
        
    List<SegGruposPermisos> findByGrupo(@Param("grupo") SegGrupos grupo);
    
    @Query(value= "SELECT gp.id, p.estatus, p.accion as permisoD, p.id as permisoID, "
            + " gp.grupo as grupoID, p.proceso, p.sentido, p.color"
            + " FROM seg_grupos_permisos gp "            
            + " INNER JOIN seg_permisos p on p.id = gp.permiso  "
            + " WHERE gp.grupo = :grupo"
            + " AND p.proceso = 1", 
            nativeQuery = true)
    List<IPermisos> dameByGrupo(@Param("grupo") Integer grupo);
    
    
    @Query(value= "SELECT gp.id, p.estatus, p.accion as permisoD, p.id as permisoID, "
            + " g.id as grupoID, p.proceso, p.sentido, p.color"
            + " FROM seg_grupos_permisos gp "            
            + " INNER JOIN seg_permisos p on p.id = gp.permiso  "
            + " INNER JOIN seg_grupos g on gp.grupo = g.id  "
            + " WHERE g.role LIKE :role"
            + " AND p.proceso = 1", 
            nativeQuery = true)
    List<IPermisos> findByRole(@Param("role") String role);
    
    List<SegGruposPermisos> findAllByOrderByPermiso();
    
    @Query(value= "SELECT gp.id, p.estatus, p.accion as permisoD, p.id as permisoID, "
            + " g.id as grupoID, p.proceso, p.sentido, p.color"
            + " FROM seg_grupos_permisos gp "            
            + " INNER JOIN seg_permisos p on p.id = gp.permiso  "
            + " INNER JOIN seg_grupos g on gp.grupo = g.id  "
            + " WHERE g.role LIKE :role"
            + " AND p.proceso = 1", 
            nativeQuery = true)
    List<String> getRoles();

}
