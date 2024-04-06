package com.ticketManagement.Week16GradedEssvaran.service;
 
import java.util.List;

import com.ticketManagement.Week16GradedEssvaran.pojo.Ticket;

public interface ServiceInterface {

	public void addOrUpdateTicket(Ticket t);

	public List<Ticket> getAllTickets();

	public Ticket getById(int id);

	public void deleteTicket(int id);

	public List<Ticket> filterByTitle(String key);

	public List<Ticket> filterById(int key);

	public List<Ticket> filterByDescription(String key);
}
