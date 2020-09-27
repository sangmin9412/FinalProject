package app.admin.matching.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO implements Serializable {
	String memId;
	String memName;
	Timestamp memBirth;
	String memAddr;
	String memTel;
	String memEmail;
	String memPass;
	String memGender;
	Timestamp memRegist;
}
