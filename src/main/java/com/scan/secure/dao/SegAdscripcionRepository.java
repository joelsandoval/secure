package com.scan.secure.dao;

import com.scan.secure.model.IAreaAdscripcion;
import com.scan.secure.model.SegAdscripcion;
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
public interface SegAdscripcionRepository extends PagingAndSortingRepository<SegAdscripcion, Integer> {

    static final Logger LOGGER = LoggerFactory.getLogger(SegAdscripcionRepository.class);

    @Query("Select a From SegAdscripcion a Where a.padre = :area or a.abuelo = :area")
    List<SegAdscripcion> dameAreaEva(@Param("area") Integer area);

    @Query("Select a From SegAdscripcion a Where a.id = :area ")
    SegAdscripcion dameAdscripcion(@Param("area") Integer area);

    @Query("Select a From SegAdscripcion a Where a.padre = :area and a.estatus = true and a.eia = true "
            + "Order By a.nivel, a.userCorto")
    List<SegAdscripcion> dameAreaHijos(@Param("area") Integer area);

    @Query(value = "select a.area_id id, a.area, a.corto, 4 as nivel, :area as padre, a.abuelo, a.entidad, "
            + "a.sinat_area sinatArea, a.sinat_dependencia sinatDependencia, a.cargo, a.estatus, a.user_id userId, "
            + "a.user_nombre userNombre, a.user_paterno userPaterno, a.user_materno userMaterno, "
            + "a.user_corto userCorto, a.siglas, 0 as hijos, a.eia, a.principal   "
            + "From vw_seg_adscripcion a where  "
            + "(a.padre = :area or a.area_id = :area) and a.estatus = true and a.eia = true "
            + "Order By a.nivel, a.user_corto", nativeQuery = true)
    List<IAreaAdscripcion> dameAreaHijosSD(@Param("area") Integer area);

    @Query(value = "select a.area_id id, a.area, a.corto, 4 as nivel, a.padre, a.abuelo, a.entidad, "
            + "    a.sinat_area sinatArea, a.sinat_dependencia sinatDependencia, a.cargo, a.estatus, a.user_id userId, "
            + "    a.user_nombre userNombre, a.user_paterno userPaterno, a.user_materno userMaterno, "
            + "    a.user_corto userCorto, a.siglas, 0 as hijos, a.eia, a.principal  "
            + "    From vw_seg_adscripcion a  "
            + "    left outer join tramite_usuario tu on (tu.usuario = a.user_id and tu.tramite = :tramite and tu.estatus = 1) "
            + "    where (a.padre = :area or a.abuelo = :area) and a.estatus = true  "
            + "    and tu.usuario is null  "
            + "order by a.nivel, a.user_corto", nativeQuery = true)
    List<IAreaAdscripcion> dameAreaDASinTram(@Param("area") Integer area, @Param("tramite") Integer tramite);

    @Query(value = "select distinct a.area_id id, a.area, a.corto, a.nivel, a.padre, a.abuelo, a.entidad, "
            + "    a.sinat_area sinatArea, a.sinat_dependencia sinatDependencia, a.cargo, a.estatus, a.user_id userId, "
            + "    a.user_nombre userNombre, a.user_paterno userPaterno, a.user_materno userMaterno, "
            + "    a.user_corto userCorto, a.siglas, a.hijos, a.eia, a.principal   "
            + "from vw_seg_adscripcion a  "
            + "inner join oficios_flujo ofl on ofl.usuario_destino = a.user_id  "
            + "inner join oficios o on o.id = ofl.oficio  "
            + "inner join oficios_tramites ot on ot.oficio = o.id "
            + "where  "
            + "a.estatus = true and ot.tramite = :tramite "
            + "and nivel > :nivel "
            + "order by a.nivel, a.user_corto", nativeQuery = true)
    List<IAreaAdscripcion> dameAreaHijosEnTramite(@Param("tramite") Integer tramite, @Param("nivel") Integer nivel);

    @Query(value = "select distinct a.area_id id, a.area, a.corto, a.nivel, a.padre, a.abuelo, a.entidad, "
            + "            a.sinat_area sinatArea, a.sinat_dependencia sinatDependencia, a.cargo, a.estatus, a.user_id userId, "
            + "            a.user_nombre userNombre, a.user_paterno userPaterno, a.user_materno userMaterno, "
            + "            a.user_corto userCorto, a.siglas, a.hijos, a.eia, a.principal   "
            + "        from vw_seg_adscripcion a  "
            + "        inner join tramite_usuario tu on tu.usuario = a.user_id  "
            + "        where  "
            + "        a.estatus = true and tu.tramite = :tramite "
            + "        and a.entidad = :entidad "
            + "        order by a.nivel, a.user_corto", nativeQuery = true)
    List<IAreaAdscripcion> damePorTramiteEntidad(@Param("tramite") Integer tramite, @Param("entidad") Integer entidad);

    @Query(value = "select distinct a.area_id id, a.area, a.corto, a.nivel, a.padre, a.abuelo, a.entidad, "
            + "    a.sinat_area sinatArea, a.sinat_dependencia sinatDependencia, a.cargo, a.estatus, a.user_id userId, "
            + "    a.user_nombre userNombre, a.user_paterno userPaterno, a.user_materno userMaterno, "
            + "    a.user_corto userCorto, a.siglas, a.hijos, a.eia, a.principal   "
            + "from vw_seg_adscripcion a  "
            + "inner join oficios_flujo ofl on ofl.usuario_destino = a.user_id  "
            + "where  "
            + "a.estatus = true and ofl.oficio = :oficio "
            + "and nivel > :nivel "
            + "order by a.nivel, a.user_corto", nativeQuery = true)
    List<IAreaAdscripcion> dameAreaHijosEnOficio(@Param("oficio") Integer oficio, @Param("nivel") Integer nivel);

    List<SegAdscripcion> findByPadreOrAbueloOrderByNivelAscCortoAsc(@Param("padre") Integer padre, @Param("abuelo") Integer abuelo);

    @Query(value = "select distinct a.area_id id, a.area, a.corto, a.nivel, a.padre, a.abuelo, a.entidad, "
            + "            a.sinat_area sinatArea, a.sinat_dependencia sinatDependencia, a.cargo, a.estatus, a.user_id userId, "
            + "            a.user_nombre userNombre, a.user_paterno userPaterno, a.user_materno userMaterno, "
            + "            a.user_corto userCorto, a.siglas, a.hijos, a.eia, a.principal   "
            + "        from vw_seg_adscripcion a "
            + "        where a.area_id = :area", nativeQuery = true)
    List<IAreaAdscripcion> damePorArea(@Param("area") Integer area);

    @Query(value = "select a.id, a.area, a.corto, a.nivel, a.padre,  "
            + "(select sa.padre from seg_areas sa where id = a.padre) abuelo,  "
            + "a.entidad, a.sinat_area sinatArea, a.sinat_dependencia sinatDependencia, "
            + "ad.cargo, ad.estatus, u.id userId, u.nombre userNombre, u.nombre_corto userCorto, "
            + "u.apellido_paterno userPaterno, u.apellido_materno userMaterno, u.siglas, a.principal "
            + "from seg_areas a  "
            + "    inner join seg_adscripcion ad on ad.area = a.id  "
            + "    inner join seg_usuarios u on u.id = ad.usuario "
            + "    inner join seg_grupos_areas ga on ga.area = a.id "
            + "    where  "
            + "    ga.grupo = :nivel and a.entidad = :entidad "
            + "    and ad.estatus = true", nativeQuery = true)
    List<IAreaAdscripcion> dameAreasPor(@Param("entidad") Integer entidad, @Param("nivel") Integer nivel);

    @Query(value = "select a.id, a.area, a.corto, a.nivel, a.padre,  "
            + "(select sa.padre from seg_areas sa where id = a.padre) abuelo,  "
            + "a.entidad, a.sinat_area sinatArea, a.sinat_dependencia sinatDependencia, "
            + "ad.cargo, ad.estatus, u.id userId, u.nombre userNombre, u.nombre_corto userCorto, "
            + "u.apellido_paterno userPaterno, u.apellido_materno userMaterno, u.siglas, a.principal  "
            + "from seg_areas a  "
            + "    inner join seg_adscripcion ad on ad.area = a.id  "
            + "    inner join seg_usuarios u on u.id = ad.usuario "
            + "    inner join seg_grupos_areas ga on ga.area = a.id "
            + "    where  "
            + "    ga.grupo = :grupo and a.principal = :principal "
            + "    and ad.estatus = true", nativeQuery = true)
    List<IAreaAdscripcion> dameAreasPorPrincipal(@Param("principal") Integer principal, @Param("grupo") Integer grupo);

    @Query(value = "select distinct a.id, a.area, a.corto, a.nivel, a.padre,  "
            + "            (select sa.padre from seg_areas sa where id = a.padre) abuelo,  "
            + "            a.entidad, a.sinat_area sinatArea, a.sinat_dependencia sinatDependencia, "
            + "            ad.cargo, ad.estatus, u.id userId, u.nombre userNombre, u.nombre_corto userCorto, "
            + "            u.apellido_paterno userPaterno, u.apellido_materno userMaterno, u.siglas, a.principal   "
            + "            from seg_areas a  "
            + "                inner join seg_adscripcion ad on ad.area = a.id  "
            + "                inner join seg_usuarios u on u.id = ad.usuario "
            + "                left outer join seg_areas hijo on hijo.padre = a.id "
            + "            where  "
            + "                a.id = :area  "
            + "                and ad.estatus = true order by u.nombre_corto", nativeQuery = true)
    List<IAreaAdscripcion> dameAreaPorId(@Param("area") Integer area);

    @Query(value = "select a.id, a.area, a.corto, a.nivel, a.padre,  "
            + "(select sa.padre from seg_areas sa where id = a.padre) abuelo,  "
            + "a.entidad, a.sinat_area sinatArea, a.sinat_dependencia sinatDependencia, "
            + "ad.cargo, ad.estatus, u.id userId, u.nombre userNombre, u.nombre_corto userCorto, "
            + "u.apellido_paterno userPaterno, u.apellido_materno userMaterno, u.siglas, a.principal  "
            + "from seg_areas a  "
            + "    inner join seg_adscripcion ad on ad.area = a.id  "
            + "    inner join seg_usuarios u on u.id = ad.usuario "
            + "    inner join seg_areas hijo on hijo.padre = a.id "
            + "where  "
            + "    hijo.id = :hijo "
            + "    and ad.estatus = true order by u.nombre_corto", nativeQuery = true)
    List<IAreaAdscripcion> dameAreaPadre(@Param("hijo") Integer hijo);

    @Query(value = "select distinct a.id, a.area, a.corto, a.nivel, a.padre,  "
            + " (select sa.padre from seg_areas sa where id = a.padre) abuelo,  "
            + " a.entidad, a.sinat_area sinatArea, a.sinat_dependencia sinatDependencia, "
            + " ad.cargo, ad.estatus, u.id userId, u.nombre userNombre, u.nombre_corto userCorto, "
            + " u.apellido_paterno userPaterno, u.apellido_materno userMaterno, u.siglas, a.principal  "
            + "from seg_areas a  "
            + " inner join seg_adscripcion ad on ad.area = a.id  "
            + " inner join seg_usuarios u on u.id = ad.usuario "
            + " inner join seg_grupos_areas ga on ga.area = a.id "
            + "where  "
            + "a.principal = :principal "
            + "and ad.usuario <> :me "
            + "and ad.estatus = true order by u.nombre_corto", nativeQuery = true)
    List<IAreaAdscripcion> dameAreasPorPrincipalSinMi(@Param("principal") Integer principal, @Param("me") Integer me);

    @Query(value = "select distinct a.id, a.area, a.corto, a.nivel, a.padre,  "
            + " (select sa.padre from seg_areas sa where id = a.padre) abuelo,  "
            + " a.entidad, a.sinat_area sinatArea, a.sinat_dependencia sinatDependencia, "
            + " ad.cargo, ad.estatus, u.id userId, u.nombre userNombre, u.nombre_corto userCorto, "
            + " u.apellido_paterno userPaterno, u.apellido_materno userMaterno, u.siglas, a.principal   "
            + "from seg_areas a  "
            + " inner join seg_adscripcion ad on ad.area = a.id  "
            + " inner join seg_usuarios u on u.id = ad.usuario "
            + " inner join seg_grupos_areas ga on ga.area = a.id "
            + "where  "
            + "a.principal = :principal "
            + "and ad.estatus = true order by u.nombre_corto", nativeQuery = true)
    List<IAreaAdscripcion> dameAreasPorPrincipal(@Param("principal") Integer principal);

    @Query(value = "select distinct a.id, a.area, a.corto, a.nivel, a.padre,  "
            + " (select sa.padre from seg_areas sa where id = a.padre) abuelo,  "
            + " a.entidad, a.sinat_area sinatArea, a.sinat_dependencia sinatDependencia, "
            + " ad.cargo, ad.estatus, u.id userId, u.nombre userNombre, u.nombre_corto userCorto, "
            + " u.apellido_paterno userPaterno, u.apellido_materno userMaterno, u.siglas, a.mira, a.principal  "
            + "from seg_areas a  "
            + " inner join seg_adscripcion ad on ad.area = a.id  "
            + " inner join seg_usuarios u on u.id = ad.usuario "
            + " inner join seg_grupos_areas ga on ga.area = a.id "
            + "where  "
            + "ga.grupo = :grupo and a.id <> :me and ad.estatus = true  "
            + "order by u.nombre_corto", nativeQuery = true)
    List<IAreaAdscripcion> dameTodosGrupo(@Param("grupo") Integer grupo, @Param("me") Integer me);

    @Query(value = "select a.id, a.area, a.corto, a.nivel, a.padre,  "
            + "(select sa.padre from seg_areas sa where id = a.padre) abuelo,  "
            + "a.entidad, a.sinat_area sinatArea, a.sinat_dependencia sinatDependencia, "
            + "ad.cargo, ad.estatus, u.id userId, u.nombre userNombre, u.nombre_corto userCorto, "
            + "u.apellido_paterno userPaterno, u.apellido_materno userMaterno, u.siglas, a.principal   "
            + "from seg_areas a  "
            + "    inner join seg_adscripcion ad on ad.area = a.id  "
            + "    inner join seg_usuarios u on u.id = ad.usuario "
            + "    inner join seg_areas hijo on hijo.padre = a.id "
            + "    where  "
            + "    hijo.id = :hijo "
            + "    and ad.estatus = true limit 1", nativeQuery = true)
    IAreaAdscripcion dameAreaPadreU(@Param("hijo") Integer hijo);

    @Query(value = "select a.id, a.area, a.corto, a.nivel, a.padre,  "
            + "(select sa.padre from seg_areas sa where id = a.padre) abuelo,  "
            + "a.entidad, a.sinat_area sinatArea, a.sinat_dependencia sinatDependencia, "
            + "ad.cargo, ad.estatus, u.id userId, u.nombre userNombre, u.nombre_corto userCorto, "
            + "u.apellido_paterno userPaterno, u.apellido_materno userMaterno, u.siglas, a.principal   "
            + "from seg_areas a  "
            + "inner join seg_adscripcion ad on ad.area = a.id  "
            + "inner join seg_usuarios u on u.id = ad.usuario  "
            + "inner join seg_grupos_areas ga on ga.area = a.id "
            + "where  "
            + "ga.grupo = :nivel and a.entidad = :entidad "
            + "and a.padre = :padre and a.eia = true "
            + "and ad.estatus = true", nativeQuery = true)
    List<IAreaAdscripcion> dameAreasDA(@Param("entidad") Integer entidad, @Param("nivel") Integer nivel, @Param("padre") Integer padre);

    @Query(value = "select a.id, a.area, a.corto, a.nivel, a.padre,  "
            + "(select sa.padre from seg_areas sa where id = a.padre) abuelo,  "
            + "a.entidad, a.sinat_area sinatArea, a.sinat_dependencia sinatDependencia, "
            + "ad.cargo, ad.estatus, u.id userId, u.nombre userNombre, u.nombre_corto userCorto, "
            + "u.apellido_paterno userPaterno, u.apellido_materno userMaterno, u.siglas, a.principal  "
            + "from seg_areas a  "
            + "inner join seg_adscripcion ad on ad.area = a.id  "
            + "inner join seg_usuarios u on ad.usuario = u.id  "
            + "where  "
            + "a.id = :area "
            + "and ad.estatus = true", nativeQuery = true)
    IAreaAdscripcion dameAdscripcionI(@Param("area") Integer area);

    @Query(value = "select a.id, a.area, a.corto, a.nivel, a.padre,  "
            + "(select sa.padre from seg_areas sa where id = a.padre) abuelo,  "
            + "a.entidad, a.sinat_area sinatArea, a.sinat_dependencia sinatDependencia, "
            + "ad.cargo, ad.estatus, u.id userId, u.nombre userNombre, u.nombre_corto userCorto, "
            + "u.apellido_paterno userPaterno, u.apellido_materno userMaterno, u.siglas, a.principal   "
            + "from seg_areas a  "
            + "inner join seg_adscripcion ad on ad.area = a.id  "
            + "inner join seg_usuarios u on ad.usuario = u.id  "
            + "where  "
            + "a.padre = :area "
            + "and ad.estatus = true "
            + "order by a.nivel asc, u.nombre asc", nativeQuery = true)
    List<IAreaAdscripcion> dameAreaHijosI(@Param("area") Integer area);

    @Query(value = "select a.id, a.area, a.corto, a.nivel, a.padre,  "
            + "(select sa.padre from seg_areas sa where id = a.padre) abuelo,  "
            + "a.entidad, a.sinat_area sinatArea, a.sinat_dependencia sinatDependencia, "
            + "ad.cargo, ad.estatus, u.id userId, u.nombre userNombre, u.nombre_corto userCorto, "
            + "u.apellido_paterno userPaterno, u.apellido_materno userMaterno, u.siglas, a.principal  "
            + "from seg_areas a  "
            + "inner join seg_adscripcion ad on ad.area = a.id  "
            + "inner join seg_usuarios u on u.id = ad.usuario "
            + "inner join seg_grupos_areas ga on ga.area = a.id "
            + "where  "
            + "a.padre = :area or (select sa.padre from seg_areas sa where id = a.padre) = :area "
            + "and ad.estatus = true "
            + "order by nivel, u.nombre_corto", nativeQuery = true)
    List<IAreaAdscripcion> dameAreaNietos(@Param("area") Integer area);

    @Query(value = "select ad.area_id as id, ad.area_id as areaId, ad.area, ad.corto, ad.nivel, ad.padre, ad.abuelo, \n"
            + "ad.entidad, ad.sinat_area as sinatArea, ad.sinat_dependencia as sinatDependencia, ad.cargo, ad.estatus, \n"
            + "ad.user_id as userId, ad.user_nombre as userNombre, ad.user_paterno as userPaterno, ad.user_materno as userMaterno, ad.siglas, \n"
            + "ad.user_corto as userCorto, ad.hijos, ad.eia, ad.principal, ad.padre_nivel as padreNivel, ad.abuelo_nivel as abueloNivel, \n"
            + "ad.fecha_inicio as fechaInicio from vw_seg_adscripcion ad \n"
            + "where ad.user_id = :usuario and ad.estatus is true order by ad.fecha_inicio desc limit 1", nativeQuery = true)
    IAreaAdscripcion damePorUsuarioAd(@Param("usuario") Integer usuario);

    @Query(value = "select distinct a.id, a.area, a.corto, a.nivel, a.padre,  \n"
            + "            (select sa.padre from seg_areas sa where id = a.padre) abuelo,  \n"
            + "            a.entidad, a.sinat_area sinatArea, a.sinat_dependencia sinatDependencia, \n"
            + "            ad.cargo, ad.estatus, u.id userId, u.nombre userNombre, u.nombre_corto userCorto, \n"
            + "            u.apellido_paterno userPaterno, u.apellido_materno userMaterno, u.siglas, a.principal \n"
            + "            from seg_areas a  \n"
            + "                inner join seg_adscripcion ad on ad.area = a.id  \n"
            + "                inner join seg_usuarios u on u.id = ad.usuario \n"
            + "                inner join seg_grupos_areas ga on ga.area = a.id\n"
            + "                inner join oficios_flujo f on f.area_origen = a.id\n"
            + "                where  \n"
            + "                f.oficio = :oficio and f.accion = 4 and ad.estatus = true", nativeQuery = true)
    List<IAreaAdscripcion> dameAreaValida(@Param("oficio") Integer oficio);

}
