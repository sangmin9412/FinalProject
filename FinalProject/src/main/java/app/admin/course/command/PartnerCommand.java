package app.admin.course.command;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PartnerCommand {
	@Size(min = 4, max = 12,message = "아이디를 입력해주세요")
	String venId;
	@NotEmpty(message = "비밀번호를 입력해주세요")
	String venPass;
	String reVenPass;
	@NotEmpty(message = "이름을 입력해주세요")
	String venName;
	@Size(min = 5, max = 13, message = "전화번호를 입력해주세요")
	String venTel;
	@NotEmpty(message = "사업자번호를 입력해주세요")
	String venNo;
	@NotEmpty(message = "주소를 입력해주세요")
	String venAddr;
	@NotEmpty(message = "대표자명을 입력해주세요")
	String venCeo;
	@NotNull(message = "계약일을 입력하세요.")
	Date venCdate;
	@NotEmpty(message = "계좌은행를 입력해주세요")
	String venAcnt;	
	@NotEmpty(message = "계좌번호를 입력해주세요")
	String venAcntNo;
	@NotEmpty(message = "타입를 입력해주세요")
	String venType;
	
	public boolean isVenPassEqualToReVenPass() {
		if(venPass.equals(reVenPass)) {
			return true;
		} else {
			return false;
		}
	}
}
