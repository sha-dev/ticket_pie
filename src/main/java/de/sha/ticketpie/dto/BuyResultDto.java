package de.sha.ticketpie.dto;

import lombok.Data;

@Data
public class BuyResultDto {

	public BuyResultDto(Boolean judgement, String seatNo) {
		this.judgement = judgement;
		this.seatNo = seatNo;
	}

	private Boolean judgement;
	private String seatNo;

}
