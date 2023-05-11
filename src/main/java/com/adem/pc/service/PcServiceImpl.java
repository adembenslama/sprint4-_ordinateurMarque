package com.adem.pc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.adem.pc.entities.Marque;
import com.adem.pc.entities.Pc;
import com.adem.pc.repos.MarqueRepository;
import com.adem.pc.repos.PcRepository;
@Service

public class PcServiceImpl implements PcService{
	@Autowired
	PcRepository pcRepository;
	@Autowired
	MarqueRepository marqueRepository;
	@Override
	public Pc savePc(Pc p) {
	return pcRepository.save(p);
	}
	@Override
	public Pc updatePc(Pc p) {
	return pcRepository.save(p);
	}
	@Override
	public void deletePc(Pc p) {
		pcRepository.delete(p);
	}
	@Override
	public void deletePcById(Long id) {
		pcRepository.deleteById(id);
	}
	@Override
	public Pc getPc(Long id) {
	return pcRepository.findById(id).get();
	}
	@Override
	public List<Pc> getAllPcs() {
	return pcRepository.findAll();
	}
	@Override
	public Page<Pc> getAllPcParPage(int page, int size) {
	return pcRepository.findAll(PageRequest.of(page, size));
	}
	@Override
	public List<Pc> findByNomPc(String nom) {
		
		return pcRepository.findByNomPc(nom);
	}
	@Override
	public List<Pc> findByNomPcContains(String nom) {
		
		return pcRepository.findByNomPcContains(nom);
	}
	@Override
	public List<Pc> findByNomPrix(String nom, Double prixAdoption) {
		
		return pcRepository.findByNomPrix(nom, prixAdoption);
	}
	@Override
	public List<Pc> findByMarque(Marque marque) {
		
		return pcRepository.findByMarque(marque);
	}
	@Override
	public List<Pc> findByMarqueIdMar(Long id) {
	
		return pcRepository.findByMarqueIdMar(id);
	}
	@Override
	public List<Pc> findByOrderByNomPcAsc() {
		
		return pcRepository.findByOrderByNomPcAsc();
	}
	@Override
	public List<Pc> trierPcsNomsprix() {
		
		return pcRepository.trierPcsNomsPrix();
	}
	@Override
	public List<Marque> getAllMarque() {
		return marqueRepository.findAll();
	}
}
