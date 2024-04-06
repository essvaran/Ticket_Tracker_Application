package com.ticketManagement.Week16GradedEssvaran.controller;
    
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ticketManagement.Week16GradedEssvaran.pojo.Ticket;
import com.ticketManagement.Week16GradedEssvaran.service.ServiceInterface;
   
@Controller
public class TicketController {

	@Autowired
	ServiceInterface service;
	
	@RequestMapping("/ticket")
	public String homePage(Model model)
	{
		model.addAttribute("tickets",service.getAllTickets());
		return "home";
	}
	 
	@RequestMapping("/addTicket")
	public String goToAddPageForm()
	{
		return "add-ticket";
	}
	
	@GetMapping("/saveTicket")
	public String addTicket(Model model,@RequestParam int id , @RequestParam String title ,@RequestParam String desc ,@RequestParam String content)
	{
		service.addOrUpdateTicket(new Ticket(id, title, desc, content, LocalDate.now()));
		model.addAttribute("tickets",service.getAllTickets());
		return "home";
	}
	 
	@GetMapping("/deleteTicket")
	public String deleteTicket(@RequestParam int id , Model model)
	{
		service.deleteTicket(id);
		model.addAttribute("tickets",service.getAllTickets());
		return "redirect:/ticket";
	}
	
	@GetMapping("/searchTicket")
	public String searchTicket(@RequestParam String filter , @RequestParam String searchText , Model model)
	{
		List<Ticket> tickets = null;
		if(filter.equalsIgnoreCase("id"))
		{
			tickets=service.filterById(Integer.parseInt(searchText));
		}
		else if(filter.equalsIgnoreCase("title"))
		{
			tickets=service.filterByTitle(searchText);
		}
		else if(filter.equalsIgnoreCase("desc"))
		{
			tickets=service.filterByDescription(searchText);
		}
		model.addAttribute("tickets",tickets);
		return "home";
	}
	
	@GetMapping("/updateTicket")
	public String goToUpdateForm(@RequestParam int id , Model model)
	{
		Ticket tic = service.getById(id);
		model.addAttribute("ticket",tic);
		return "update-form";
	}
	
	@GetMapping("/fUpdateTicket")  
	public String updateTicket(Model model,@RequestParam LocalDate date ,@RequestParam int id , @RequestParam String title ,@RequestParam String desc ,@RequestParam String content)
	{
		service.addOrUpdateTicket(new Ticket(id, title, desc, content, date));
		model.addAttribute("tickets",service.getAllTickets());
		return "home";
	}
	@GetMapping("/viewTicket")
	public String viewTicket(@RequestParam int id, Model model)
	{
		model.addAttribute("ticket",service.getById(id));
		return "view";
	}

}
