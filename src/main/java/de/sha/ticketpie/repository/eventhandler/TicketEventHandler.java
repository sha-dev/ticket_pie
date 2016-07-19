package de.sha.ticketpie.repository.eventhandler;

import java.util.Date;

import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import de.sha.ticketpie.entity.Ticket;

@Component
@RepositoryEventHandler
public class TicketEventHandler {

	@HandleBeforeSave
	public void beforeSave(Ticket ticket){
		ticket.setUpdateDateTime(new Date());
	}
}
