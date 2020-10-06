package app.admin.matching.command;

import java.time.LocalDateTime;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class EventCommand {
	@NotBlank(message = "장소를 입력하세요.")
	String eveLoc;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	LocalDateTime eveDate;
	@Digits(integer = 3, fraction = 0)
	Long eveMxCnt;
	@NotBlank(message = "제목을 입력하세요.")
	String eveSubject;
	@NotBlank(message = "상세설명을 입력하세요.")
	String eveContent;
	MultipartFile [] eveImage;
	
}
