package davidAcuna.domain;

import java.util.Date;

public class ExcepcionResponse {
    
	private Date date;
	private String message;
	
	public ExcepcionResponse(Date date, String message) {
		super();
		this.date = date;
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
		
}
