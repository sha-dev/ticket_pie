/**
 *
 */
package de.sha.ticketpie.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * @author sato_hiroki
 */

@Entity
public class Ticket {

	public Ticket() {
		super();
	}
	
	public Ticket(String seatNo, boolean soldOutFlag) {
		super();
		
		Date nowTime = new Date();
		
		this.seatNo = seatNo;
		this.soldOutFlag = soldOutFlag;
		this.insertDateTime = nowTime;
		this.updateDateTime = nowTime;
	}

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "seat_no")
	private String seatNo;

	@Column(name = "sold_out_flag")
	private boolean soldOutFlag;

	@Version
	private int version;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "insertdatetime")
	private Date insertDateTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updatedatetime")
	private Date updateDateTime;

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

	public boolean getSoldOutFlag() {
		return soldOutFlag;
	}

	public void setSoldOutFlag(boolean soldOutFlag) {
		this.soldOutFlag = soldOutFlag;
	}

	public Date getInsertDateTime() {
		return insertDateTime;
	}

	public void setInsertDateTime(Date insertDateTime) {
		this.insertDateTime = insertDateTime;
	}

	public Date getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

}
