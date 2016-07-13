package de.sha.ticketpie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.sha.ticketpie.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer>{

}
