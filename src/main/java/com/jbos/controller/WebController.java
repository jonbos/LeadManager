package com.jbos.controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jbos.beans.SalesLead;
import com.jbos.beans.Touch;
import com.jbos.repository.LeadRepository;
import com.jbos.repository.TouchRepository;

@Controller
public class WebController {
	@Autowired
	LeadRepository leadRepo;
	@Autowired
	TouchRepository touchRepo;

	@GetMapping("/")
	public String viewAllLeads(Model model) {
		List<SalesLead> allLeads = leadRepo.getOldestContacts();
		model.addAttribute("leads", allLeads);
		return "results";
	}

	@GetMapping("/inputLead")
	public String addNewLead(Model model) {
		SalesLead s = new SalesLead();
		model.addAttribute("newLead", s);
		return "leadForm";
	}

	@GetMapping("/leads/{id}/edit")
	public String showUpdateContact(@PathVariable("id") long id, Model model) {
		SalesLead sl = leadRepo.findById(id).orElse(null);
		model.addAttribute("newLead", sl);
		return "leadForm";
	}

	@PostMapping("/update/{id}")
	public String updateLead(SalesLead s, Model model) {
		leadRepo.save(s);
		return "redirect:/leads/" + s.getId();
	}

	@GetMapping("/leads/{id}")
	public String viewLead(@PathVariable("id") long id, Model model) {
		SalesLead lead = leadRepo.findById(id).orElse(null);
		model.addAttribute("lead", lead);
		return "lead-details";
	}

	@GetMapping("/leads/{id}/touch")
	public String showAddTouch(@PathVariable("id") long id, Model model) {
		SalesLead lead = leadRepo.findById(id).orElse(null);
		Touch t = new Touch();
		t.setSalesLead(lead);
		model.addAttribute("touch", t);
		return "touchForm";
	}

	@PostMapping("/leads/{id}/touch")
	public String addTouch(@PathVariable("id") long id, Model model, Touch t) {
		SalesLead lead = leadRepo.findById(id).orElse(null);
		t.setSalesLead(lead);
		t.setContactDate(new Date(Calendar.getInstance().getTime().getTime()));
		touchRepo.save(t);
		return "redirect:/";
	}

	@GetMapping("/leads/{id}/touch/{touchId}/delete")
	public String deleteTouch(@PathVariable("id") long id, @PathVariable("touchId") long touchId, Model model) {

		touchRepo.delete(touchRepo.findById(touchId).orElse(null));
		return "redirect:/";

	}

	@GetMapping("/leads/{id}/delete")
	public String deleteLead(@PathVariable("id") long id, Model model) {
		SalesLead l = leadRepo.findById(id).orElse(null);
		leadRepo.delete(l);
		return "redirect:/";
	}
}
