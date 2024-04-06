package com.ticketManagement.Week16GradedEssvaran.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketManagement.Week16GradedEssvaran.pojo.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Integer>{

}
