package app.admin.matching.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {
	Long eveNo;
	String venId;
	String eveLoc;
	Timestamp eveDate;
	Long eveMxCnt;
	String eveSubject;
	String eveContent;
	String eveOriginalImage;
	String eveStoreImage;
	public EventDTO(String eveOriginalImage, String eveStoreImage) {
		super();
		this.eveOriginalImage = eveOriginalImage;
		this.eveStoreImage = eveStoreImage;
	}
	
	

}
