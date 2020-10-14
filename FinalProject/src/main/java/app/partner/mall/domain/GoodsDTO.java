package app.partner.mall.domain;

import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDTO {
	Integer goodsNo;
	String venId;
	String goodsName;
	String goodsPrice;
	String goodsDet;
	String goodsImage;
	String goodsType;
	Timestamp goodsRegist;

}
