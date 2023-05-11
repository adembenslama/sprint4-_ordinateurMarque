package com.adem.pc.controllers;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.adem.pc.entities.Marque;
import com.adem.pc.entities.Pc;
import com.adem.pc.service.PcService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

@Controller
public class PcController {
	@Autowired
	PcService pcService;
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
		List<Marque> mars = pcService.getAllMarque();
		Pc pc1 = new Pc();
		Marque mar = new Marque ();

		if (!mars.isEmpty()) {
		    mar = mars.get(0);
		}

		pc1.setMarque(mar);
		modelMap.addAttribute("pc", new Pc());
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("marques", mars);
		
		for (Marque m: mars) {
			System.out.println(m);
		}
		
		modelMap.addAttribute("page",0);
		return "formPc";
	}
	
	@RequestMapping("/savePc")
	public String savePc(@Valid Pc pc,  BindingResult bindingResult, @ModelAttribute("page") int pageFromPrevious,
		    @RequestParam (name="size", defaultValue = "3") int size,
		    RedirectAttributes redirectAttributes,ModelMap modelMap)
	{ int page;
		 if (bindingResult.hasErrors()) {
			 List<Marque> mars = pcService.getAllMarque();
			 modelMap.addAttribute("marque", mars);
			 modelMap.addAttribute("mode", "edit");
		        return "formPc";
		    }if (pc.getIdPc()==null) //adding
		        page = pcService.getAllPcs().size()/size; // calculer le nbr de pages
		    else //updating
		        page = pageFromPrevious;
		    pcService.savePc(pc);
		    redirectAttributes.addAttribute("page", page);
		    return "redirect:/listePcs";
	}
	@RequestMapping("/listePcs")
	public String listePcs(ModelMap modelMap ,@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "3") int size)

	{
		Page<Pc> pcl = pcService.getAllPcParPage(page, size);
		modelMap.addAttribute("pcs", pcl);
		 modelMap.addAttribute("pages", new int[pcl.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listePcs";
	}
	@RequestMapping("/supprimerPc")
	public String supprimerPc(@RequestParam("id") Long id,
	 ModelMap modelMap ,@RequestParam (name="page",defaultValue = "0") int page,
	 @RequestParam (name="size", defaultValue = "3") int size)
	{ 
		pcService.deletePcById(id);
		Page<Pc> pcl = pcService.getAllPcParPage(page, 
				size);
				modelMap.addAttribute("pcs", pcl);
				modelMap.addAttribute("pages", new int[pcl.getTotalPages()]);
				modelMap.addAttribute("currentPage", page);
				modelMap.addAttribute("size", size);

	return "listePcs";
	}
	@RequestMapping("/modifierPc")
	public String editerPc(@RequestParam("id") Long id, @RequestParam("page") int page,ModelMap modelMap)
	{
		Pc p = pcService.getPc(id);
		List<Marque> mars = pcService.getAllMarque();
	modelMap.addAttribute("pc", p);
	modelMap.addAttribute("mode", "edit");
	modelMap.addAttribute("page",page);
	modelMap.addAttribute("marques", mars);
	return "formPc";
	}
	@RequestMapping("/updatePc")
	public String updateChat(@ModelAttribute("pc") Pc pc,
	@RequestParam("date") String date,ModelMap modelMap) throws ParseException 
	{
		//conversion de la date 
		 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		 Date dateAjout= dateformat.parse(String.valueOf(date));
		 pc.setDateAjout(dateAjout);
		 
		 pcService.updatePc(pc);
		 List<Pc> pcl = pcService.getAllPcs();
		 modelMap.addAttribute("pcs", pcl);
		return "listePcs";
		}
}
