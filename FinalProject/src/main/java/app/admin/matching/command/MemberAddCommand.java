package app.admin.matching.command;

import java.util.List;

import lombok.Data;

@Data
public class MemberAddCommand {
	String memCareer;
	String memJob;
	String memSalary;
	String memHgt;
	String memWgt;
	String memBlood;
	String memRlg;
	String memImage;
	List memHobby;

}
