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
import lombok.Data;
/**
 * @author sato_hiroki
 */

@Entity
@Data
public class Ticket {

	public Ticket() {
		super();
	}

	public Ticket(String seatNo, boolean soldOutFlag) {
		this.seatNo = seatNo;
		this.soldOutFlag = soldOutFlag;
		this.insertDateTime = new Date();
		this.updateDateTime = new Date();
	}

	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "seatno")
	private String seatNo;
	@Column(name = "soldoutflag")
	private boolean soldOutFlag;
	@Version
	private Integer version;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "insertdatetime")
	private Date insertDateTime;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updatedatetime")
	private Date updateDateTime;

}
