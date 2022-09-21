package com.scan.secure.dao;

import com.scan.secure.model.IMenuP;
import com.scan.secure.model.SegPermisos;
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
public interface SegPermisosRepository extends PagingAndSortingRepository<SegPermisos, Integer> {

    static final Logger LOGGER = LoggerFactory.getLogger(SegPermisosRepository.class);
    
    SegPermisos findByPermiso(String permiso);
    
    List<SegPermisos> findByProceso(Integer proceso);
    
    @Query(value = "select distinct p.permiso, p.accion, p.id as accionId, p.color, p.icono, a.corto as area, "
            + " a.id, p.estatus, p.proceso, p.situacion, a.sinat_dependencia as dependencia, "
            + " p.sentido, p.etapa, p.efecto, a.sinat_area as areaSinat, a.nivel, a.entidad, gp.futura "
            + " from seg_permisos p "
            + " inner join seg_grupos_permisos gp on p.id = gp.permiso  "
            + " inner join seg_grupos g on gp.grupo = g.id   "
            + " inner join seg_grupos_areas ga on ga.grupo = g.id  "
            + " inner join seg_areas a on ga.area = a.id  "
            + " inner join seg_adscripcion ad on a.id = ad.area  "
            + " inner join seg_usuarios u on ad.usuario = u.id "
            + " where u.id = :usuario and ad.estatus = true "
            + " order by p.situacion",
            nativeQuery = true)
    List<IMenuP> dameByUsuarioArea(@Param("usuario") Integer usuario);

    @Query(value = "select distinct p.permiso  "
            + "from seg_usuarios u  "
            + "inner join seg_adscripcion ad on ad.usuario = u.id "
            + "inner join seg_areas a on a.id  = ad.area "
            + "inner join seg_grupos_areas ga on ga.area = a.id "
            + "inner join seg_grupos g on ga.grupo = g.id  "
            + "inner join seg_grupos_permisos gp on gp.grupo = g.id  "
            + "inner join seg_permisos p on p.id = gp.permiso  "
            + "where  "
            + "u.id = :usuario",
            nativeQuery = true)
    List<String> dameByUsuario(@Param("usuario") Integer usuario);

    @Query(value = "select distinct p.permiso, p.accion, fb.orden,  "
            + "   p.color, p.icono  "
            + "   from seg_permisos p  "
            + "   inner join tramite_flujo_base fb on fb.actual = p.permiso "
            + "   order by fb.orden",
            nativeQuery = true)
    List<IMenuP> dameMenuPendientes();

    @Query(value = "select distinct sp.* from seg_permisos sp  "
            + "inner join tramite_flujo_config fc on fc.futura = sp.id  "
            + "where fc.situacion = :situacion", nativeQuery = true)
    List<IMenuP> dameFuturas(@Param("situacion") Integer situacion);

    @Query(value = "select distinct p.permiso, p.accion, p.id as accionId, p.color, p.icono, "
            + "a.id, p.estatus, p.proceso, p.situacion, a.sinat_dependencia as dependencia, "
            + "p.sentido, p.etapa, p.efecto, a.sinat_area as areaSinat, a.nivel, a.entidad "
            + "from seg_permisos p "
            + "inner join tramite_flujo_config fc on fc.futura = p.id "
            + "inner join seg_grupos_permisos gp on p.id = gp.permiso  "
            + "inner join seg_grupos g on gp.grupo = g.id   "
            + "inner join seg_grupos_areas ga on ga.grupo = g.id  "
            + "inner join seg_areas a on ga.area = a.id  "
            + "inner join seg_adscripcion ad on a.id = ad.area  "
            + "inner join seg_usuarios u on ad.usuario = u.id "
            + "where fc.situacion = :situacion and a.id = :area and gp.futura = true "
            + "order by p.accion", nativeQuery = true)
    List<IMenuP> dameFuturasArea(@Param("situacion") Integer situacion, @Param("area") Integer area);

}
