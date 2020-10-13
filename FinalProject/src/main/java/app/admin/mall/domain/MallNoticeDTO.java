package app.admin.mall.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class MallNoticeDTO {
	Integer mnotNo;
	String empId;
	String mnotSub;
	String mnotCont;
	Timestamp mnotDate;
	Integer mnotCount;
	String mnotOriginFile;
	String mnotStoreFile;
	Long mnotSize;

}
