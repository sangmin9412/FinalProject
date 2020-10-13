package app.user.course.command;

import lombok.Data;

@Data
public class OrderCommand {
	String venId;
	String goodsNo;
	Long orderQty;
	String orderPrice;

}
