package com.adem.pc.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.adem.pc.entities.Marque;
import com.adem.pc.entities.Pc;
@RepositoryRestResource(path = "rest")
public interface PcRepository extends JpaRepository<Pc, Long> {
	List<Pc> findByNomPc(String nom);
	List<Pc> findByNomPcContains(String nom);
	@Query("select c from Pc c where c.nomPc like %:nom and c.prix > :prix")
	List<Pc> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	@Query("select c from Pc c where c.marque = ?1")
	List<Pc> findByMarque (Marque marque);
	List<Pc> findByMarqueIdMar(Long id);
	List<Pc> findByOrderByNomPcAsc();
	@Query("select c from Pc c order by c.nomPc ASC, c.prix DESC")
	List<Pc> trierPcsNomsPrix ();

}
