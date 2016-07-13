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

	@Id
	@GeneratedValue
	public Integer id;
	public Integer seatNo;
	@Version
	public Integer version;
	@Temporal(TemporalType.TIMESTAMP)
	public Date insertDateTime;
	@Temporal(TemporalType.TIMESTAMP)
	public Date updateDateTime;

}
