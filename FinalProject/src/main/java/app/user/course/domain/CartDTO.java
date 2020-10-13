package app.user.course.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
	Long cartNo;
	String memId;
	String goodsNo;
	String goodsImage;
	String goodsName;
	String venId;
	Long cartQty;
	Long goodsPrice;
	String cartPrice;
}
