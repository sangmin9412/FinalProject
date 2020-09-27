package app.admin.matching.command;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginCommand {
	@NotBlank
	String memId;
	String memPass;
}
