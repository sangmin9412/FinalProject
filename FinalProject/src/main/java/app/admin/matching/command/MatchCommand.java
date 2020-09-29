package app.admin.matching.command;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchCommand {
	@NotBlank(message = "아이디를 입력하세요.")
	String memId;
	@NotBlank(message = "아이디를 입력하세요.")
	String partnerId;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	LocalDateTime matDate;
	String matCheck;
}
