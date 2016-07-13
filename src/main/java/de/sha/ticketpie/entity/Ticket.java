/**
 *
 */
package de.sha.ticketpie.entity;

import java.util.Date;

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
		this.soldOutflag = soldOutFlag;
		this.insertDateTime = new Date();
		this.updateDateTime = new Date();
	}

	@Id
	@GeneratedValue
	public Integer id;
	public String seatNo;
	public boolean soldOutflag;
	@Version
	public Integer version;
	@Temporal(TemporalType.TIMESTAMP)
	public Date insertDateTime;
	@Temporal(TemporalType.TIMESTAMP)
	public Date updateDateTime;

}
