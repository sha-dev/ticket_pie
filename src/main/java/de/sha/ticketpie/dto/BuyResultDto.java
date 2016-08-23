package de.sha.ticketpie.dto;

public class BuyResultDto {

	private boolean success;
	private String seatNo;
	
	public BuyResultDto(boolean success, String seatNo) {
		this.setSuccess(success);
		this.setSeatNo(seatNo);
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

}
