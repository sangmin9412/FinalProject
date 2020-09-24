package app.admin.matching.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberCommand {
	String memId;
	String memName;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date memBirth;
	String memAddr;
	String memTel;
	String memEmail;
	String memPass;
	String memPassCon;
	String memGender;
	public boolean isUserPwEqualToUserPwCon() {
		if(memPass.equals(memPassCon)) {
			return true;
		}
		return false;
	}
	
}
