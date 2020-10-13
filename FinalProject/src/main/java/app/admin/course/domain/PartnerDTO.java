package app.admin.course.domain;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartnerDTO {
		String venId;
		String venPass;
		String venName;
		String venTel;
		String venNo;
		String venAddr;
		String venCeo;
		Date venCdate;
		String venAcnt;
		String venAcntNo;
		String venType;
		String venOk;
}
