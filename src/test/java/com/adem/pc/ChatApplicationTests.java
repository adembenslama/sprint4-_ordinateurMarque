package com.adem.pc;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.adem.pc.entities.Marque;
import com.adem.pc.entities.Pc;
import com.adem.pc.repos.PcRepository;
import com.adem.pc.service.PcService;

@SpringBootTest
class ChatApplicationTests {

	@Autowired
	private PcRepository pcRepository;
	@Autowired
	private PcService  pcService ;
	@Test
	public void testCreatePc() {
		Pc pc1 = new Pc("Sousou",50.500,new Date());
		pcRepository.save(pc1);
	}
	@Test
	public void testFindPc()
	{
		Pc p = pcRepository.findById(1L).get(); 
	System.out.println(p);
	}
	@Test
	public void testUpdatePc()
	{
		Pc p = pcRepository.findById(1L).get();
	p.setPrix(1000.0);
	pcRepository.save(p);
	}
	@Test
	public void testDeleteFreelancer()
	{
		pcRepository.deleteById(1L);;
	}
	@Test
	public void testListerTousPcs()
	{
	List<Pc> pcs = pcRepository.findAll();
	for (Pc p : pcs)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testFindBynomChatContains()
	{
	Page<Pc> pc1 = pcService.getAllPcParPage(0,3);
	System.out.println(pc1.getSize());
	System.out.println(pc1.getTotalElements());
	System.out.println(pc1.getTotalPages());
	pc1.getContent().forEach(c -> {System.out.println(c.toString());
	 });
	/*ou bien
	for (Produit p : prods)
	{
	System.out.println(p);
	} */
	}
	@Test
	public void testfindByNomPc()
	{
	List<Pc> pc1 = pcRepository.findByNomPc("Sousou");
	for (Pc p : pc1)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testFindByNomPcContains()
	{
	List<Pc> pc1=pcRepository.findByNomPcContains("s");
	for (Pc p : pc1)
	{
	System.out.println(p);
	} }
	@Test
	public void testfindByNomPrix()
	{
	List<Pc> pc1 = pcRepository.findByNomPrix("Sousou", 50.0);
	for (Pc p : pc1)
	{
	System.out.println(p);
	}
	}

	@Test
	public void testfindByMarque()
	{
		Marque mar = new Marque();
	//sou.setIdSou(1L);
	List<Pc> pc1 = pcRepository.findByMarque(mar);
	for (Pc c : pc1)
	{
	System.out.println(c);
	}
	}
	
	@Test
	public void findByMarqueIdMar()
	{
	List<Pc> pc1 = pcRepository.findByMarqueIdMar(1L);
	for (Pc p : pc1)
	{
	System.out.println(p);
	}
	 }
	@Test
	public void testfindByOrderByNomPcAsc()
	{
	List<Pc> pc1 = pcRepository.findByOrderByNomPcAsc();
	for (Pc p : pc1)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testTrierPcsNomsprix()
	{
	List<Pc> pc1 = pcRepository.trierPcsNomsPrix();
	for (Pc c : pc1)
	{
	System.out.println(c);
	}
	}

}
