package com.ticketManagement.Week16GradedEssvaran.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketManagement.Week16GradedEssvaran.dao.TicketDao;
import com.ticketManagement.Week16GradedEssvaran.pojo.Ticket;

@Service
public class TicketService implements ServiceInterface {

	@Autowired
	TicketDao dao;

	@Override
	public void addOrUpdateTicket(Ticket t) {
		dao.addOrUpdateTicket(t);
	}
 
	@Override
	public List<Ticket> getAllTickets() {
		return dao.getAllTickets();
	}

	@Override
	public Ticket getById(int id) {
		return dao.getById(id);
	}

	@Override
	public void deleteTicket(int id) {
		dao.deleteTicket(id);
	}

	@Override
	public List<Ticket> filterByTitle(String key) {
		return dao.filterByTitle(key);
	}

	@Override
	public List<Ticket> filterById(int key) {
		return dao.filterById(key);
	}
	  
   
	@Override
	public List<Ticket> filterByDescription(String key) {
		return dao.filterByDescription(key);
	}

} 

