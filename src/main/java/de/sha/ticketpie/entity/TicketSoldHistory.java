package de.sha.ticketpie.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import lombok.Data;

@Entity
@Data
public class TicketSoldHistory {

	TicketSoldHistory() {
		super();
	}

	public TicketSoldHistory(String seatNo) {
		this.seatNo = seatNo;
		this.insertDateTime = new Date();
	}

	@Id
	@GeneratedValue
	private Integer id;
	private String seatNo;
	@Version
	private int version;
	@Temporal(TemporalType.TIMESTAMP)
	private Date insertDateTime;

}
