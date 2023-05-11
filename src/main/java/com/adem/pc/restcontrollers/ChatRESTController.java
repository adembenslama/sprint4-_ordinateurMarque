package com.adem.pc.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adem.pc.entities.Pc;
import com.adem.pc.service.PcService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ChatRESTController {
	@Autowired
	PcService pcService ;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Pc> getAllChats() {
		return pcService.getAllPcs();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Pc getChatById(@PathVariable("id") Long id) {
	return pcService.getPc(id);
	 }
	@RequestMapping(method = RequestMethod.POST)
	public Pc createChat(@RequestBody Pc pc) {
	return pcService.savePc(pc);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public Pc updateChat(@RequestBody Pc pc) {
	return pcService.updatePc(pc);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deletePc(@PathVariable("id") Long id)
	{
		pcService.deletePcById(id);
	}
	@RequestMapping(value="/pcMar/{idMar}",method = RequestMethod.GET)
	public List<Pc> getPcsByMarId(@PathVariable("idMar") Long idMar) {
	return pcService.findByMarqueIdMar(idMar);
	}
}
