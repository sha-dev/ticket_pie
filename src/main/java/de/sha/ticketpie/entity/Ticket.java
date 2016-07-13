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
 *
 */
@Entity
public class Ticket {

	private static final long serialVersionUID = 1L;

	public Ticket(){
		super();
	}

	public Ticket(String seatNo, boolean soldOutFlag){
		this.seatNo = seatNo;
		this.soldOutFlag = soldOutFlag;
		this.insertDateTime = new Date();
		this.updateDateTime = new Date();
	}

	@Id
	@GeneratedValue
	public Integer id;
	@Column(name = "seatno")
	public String seatNo;
	@Column(name = "soldoutflag")
	public boolean soldOutFlag;
	@Version
	public Integer version;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "insertdatetime")
	public Date insertDateTime;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updatedatetime")
	public Date updateDateTime;

}
