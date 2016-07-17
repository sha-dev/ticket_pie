package de.sha.ticketpie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.sha.ticketpie.entity.TicketSoldHistory;

@Repository
public interface TicketSoldHistoryRepository extends JpaRepository<TicketSoldHistory, Integer> {

}
