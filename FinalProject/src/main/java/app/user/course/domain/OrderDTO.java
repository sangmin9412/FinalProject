package app.user.course.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
	Long orderNo;
	String venId;
	String goodsNo;
	Long orderQty;
	Timestamp orderDate;
	String orderPrice;


}
