package de.sha.ticketpie.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
public class TicketSoldHistory {

	public TicketSoldHistory() {
		super();
	}
	
	public TicketSoldHistory(String seatNo) {
		this.seatNo = seatNo;
		this.insertDateTime = new Date();
	}
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "seat_no")
	private String seatNo;
	
	@Version
	private int version;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "insert_date_time")
	private Date insertDateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getInsertDateTime() {
		return insertDateTime;
	}

	public void setInsertDateTime(Date insertDateTime) {
		this.insertDateTime = insertDateTime;
	}




}
