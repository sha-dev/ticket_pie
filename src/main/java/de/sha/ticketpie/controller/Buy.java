package de.sha.ticketpie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.sha.ticketpie.dto.BuyResultDto;
import de.sha.ticketpie.logic.TicketBuyLogic;

@RestController
public class Buy {

	@Autowired
	TicketBuyLogic logic;

	@RequestMapping("buy")
	public BuyResultDto buyTicket() {

		return logic.buyTicket();
	}

}
