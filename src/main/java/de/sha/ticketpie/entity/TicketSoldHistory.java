package de.sha.ticketpie.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
public class TicketSoldHistory {

	TicketSoldHistory() {
		super();
	}

	TicketSoldHistory(String seatNo) {
		this.seatNo = seatNo;
		this.insertDateTime = new Date();
	}

	@Id
	@GeneratedValue
	public Integer id;
	public String seatNo;
	@Version
	public Integer version;
	@Temporal(TemporalType.TIMESTAMP)
	public Date insertDateTime;

}
