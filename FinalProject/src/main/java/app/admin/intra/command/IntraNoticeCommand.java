package app.admin.intra.command;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class IntraNoticeCommand {

	Integer notNo;
	String empId;
	String notSub;
	String notCont;
	Timestamp notDate;
	Integer notCount;
	String notOriginFile;
	String notStoreFile;
	String notSize;
}
