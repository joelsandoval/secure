package com.scan.secure.dao;

import com.scan.secure.model.SegAreas;
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
public interface SegAreasRepository extends PagingAndSortingRepository<SegAreas, Integer> {

    static final Logger LOGGER = LoggerFactory.getLogger(SegAreasRepository.class);

    List<SegAreas> findByPadreAndEiaOrderByArea(@Param("padre") Integer padre, @Param("eia") Boolean eia);

    @Query(value = "select distinct * from seg_areas a  "
            + "inner join seg_adscripcion ad on ad.area = a.id  "
            + "where ad.usuario = :usuario and ad.estatus = true", nativeQuery = true)
    List<SegAreas> damePorUsuario(@Param("usuario") Integer usuario);

    @Query(value = "select distinct a.id from seg_areas a  "
            + "inner join seg_adscripcion ad on ad.area = a.id  "
            + "where ad.usuario = :usuario and ad.estatus = true", nativeQuery = true)
    List<Integer> dameAreasIdPorUsuario(@Param("usuario") Integer usuario);

    @Query("Select a From SegAreas a Order by a.area")
    List<SegAreas> dameAreas();

    @Query(value = "select a.id from seg_areas a "
            + "where a.nivel = :nivel  "
            + "and a.entidad = :entidad", nativeQuery = true)
    Integer dameMasterChief(@Param("entidad") Integer entidad, @Param("nivel") Integer nivel);

    @Query(value = "select distinct g.grupo from seg_grupos_areas g \n"
            + "inner join seg_adscripcion sa on sa.area = g.area \n"
            + "where sa.usuario = :usuario", nativeQuery = true)
    List<Integer> damePerfiles(@Param("usuario") Integer usuario);

    

}
