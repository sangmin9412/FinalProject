package app.admin.matching.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchDTO {
	Long matNo;
	String memId;
	String partnerId;
	String empId;
	Timestamp matDate;
	String matCheck;
}
