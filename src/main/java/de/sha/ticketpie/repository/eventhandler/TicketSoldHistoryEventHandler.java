package de.sha.ticketpie.repository.eventhandler;

import java.util.Date;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;

import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import de.sha.ticketpie.entity.TicketSoldHistory;

@Component
@RepositoryEventHandler
public class TicketSoldHistoryEventHandler {

	@HandleBeforeCreate
	public void beforeSave(TicketSoldHistory history) {
		history.setInsertDateTime(new Date());
	}
}
