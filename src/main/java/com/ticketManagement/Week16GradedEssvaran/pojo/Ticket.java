package com.ticketManagement.Week16GradedEssvaran.pojo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

	@Id 
	private int id;
	private String ticketTitle;
	private String ticketShortDescription;
	@Column(length = 5000)
	private String content;
	private LocalDate ticketCreatedOn;
}
