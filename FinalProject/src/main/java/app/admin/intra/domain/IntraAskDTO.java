package app.admin.intra.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class IntraAskDTO {

	Integer askNo;
	String empId;
	String askSub;
	String askCont;
	Timestamp askDate;
	Integer askCount;
	String askOriginFile;
	String askStoreFile;
	Long askSize;
}
