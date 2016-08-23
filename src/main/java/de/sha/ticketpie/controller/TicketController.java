package de.sha.ticketpie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.sha.ticketpie.dto.BuyResultDto;
import de.sha.ticketpie.logic.TicketBuyLogic;

@RestController
public class TicketController {

	@Autowired
	TicketBuyLogic logic;

	@RequestMapping(path="buy", method = RequestMethod.GET)
	public BuyResultDto Buy() {
		return logic.buyTicket();
	}

}
