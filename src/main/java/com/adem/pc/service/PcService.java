package com.adem.pc.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.adem.pc.entities.Marque;
import com.adem.pc.entities.Pc;

public interface PcService {
	Pc savePc(Pc p);
	Pc updatePc(Pc p);
	void deletePc(Pc p);
	void deletePcById(Long id);
	Pc getPc(Long id);
	List<Pc> getAllPcs();
	Page<Pc> getAllPcParPage(int page, int size);
	List<Pc> findByNomPc(String nom);
	List<Pc> findByNomPcContains(String nom);
	List<Pc> findByNomPrix (String nom, Double prix);
	List<Pc> findByMarque (Marque marque);
	List<Pc> findByMarqueIdMar(Long id);
	List<Pc> findByOrderByNomPcAsc();
	List<Pc> trierPcsNomsprix();
	List<Marque> getAllMarque();
	

}
