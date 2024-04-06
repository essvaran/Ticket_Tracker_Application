package com.ticketManagement.Week16GradedEssvaran.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Repository;

import com.ticketManagement.Week16GradedEssvaran.pojo.Ticket;
import com.ticketManagement.Week16GradedEssvaran.repo.TicketRepo;

@Repository
public class TicketDao implements DAOInterface {

	@Autowired
	TicketRepo repo;

	/**
	 * This method is to add or update a record save() method performs two different
	 * operation 1. It will add the record if it doesn't exist in the table 2. It
	 * will update the record if it already exists in the table
	 * 
	 * @param t --> An object of ticket
	 */
	@Override
	public void addOrUpdateTicket(Ticket t) {
		repo.save(t);
	}

	/**
	 * This methos is to fetch all the records from the database
	 * 
	 * @return --> It returns the list of tickets fetched from the database
	 */
	@Override
	public List<Ticket> getAllTickets() {
		return repo.findAll();
	}

	/**
	 * This method is to find a particular record by id
	 * 
	 * @param id --> Id of the ticket
	 * @return --> it returns the ticket object
	 */
	@Override
	public Ticket getById(int id) {
		return repo.findById(id).get();
	}

	/**
	 * This method will delete a record of the particular id
	 * 
	 * @param id
	 */
	@Override
	public void deleteTicket(int id) {
		repo.deleteById(id);
	}

	/**
	 * @return the list of ticket by that matches the search key
	 */ 
	@Override
	public List<Ticket> filterByTitle(String searchKey) {
		// TODO Auto-generated method stub
		Ticket dummy = new Ticket();
		dummy.setTicketTitle(searchKey);

		ExampleMatcher matcher = ExampleMatcher.matching()
				.withMatcher("ticketTitle", ExampleMatcher.GenericPropertyMatchers.contains())
				.withIgnorePaths("id", "ticketShortDescription", "content", "ticketCreatedOn");

		Example<Ticket> example = Example.of(dummy, matcher);
		return repo.findAll(example);
	}

	@Override
	public List<Ticket> filterById(int key) {
		Ticket dummy = new Ticket();
		dummy.setId(key);
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withMatcher("id", ExampleMatcher.GenericPropertyMatchers.contains())
				.withIgnorePaths("ticketTitle", "ticketShortDescription", "content", "ticketCreatedOn");

		Example<Ticket> example = Example.of(dummy, matcher);
		return repo.findAll(example);
	}

	@Override
	public List<Ticket> filterByDescription(String key) {
		Ticket dummy = new Ticket();
		dummy.setTicketShortDescription(key);

		ExampleMatcher matcher = ExampleMatcher.matching()
				.withMatcher("ticketShortDescription", ExampleMatcher.GenericPropertyMatchers.contains())
				.withIgnorePaths("id", "ticketTitle", "content", "ticketCreatedOn");

		Example<Ticket> example = Example.of(dummy, matcher);
		return repo.findAll(example);
	}

	@Override
	public List<Ticket> filterByDate(LocalDate key) {
		Ticket dummy = new Ticket();
		dummy.setTicketCreatedOn(key);

		ExampleMatcher matcher = ExampleMatcher.matching()
				.withMatcher("ticketCreatedOn", ExampleMatcher.GenericPropertyMatchers.contains())
				.withIgnorePaths("id", "ticketShortDescription", "content", "ticketTitle");

		Example<Ticket> example = Example.of(dummy, matcher);
		return repo.findAll(example);
	}

}
