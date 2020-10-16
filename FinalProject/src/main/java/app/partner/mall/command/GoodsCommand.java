package app.partner.mall.command;

import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsCommand {
	Integer goodsNo;
	String venId;
	@NotBlank(message = "상품 이름을 입력하세요.")
	String goodsName;
	String goodsPrice;
	String goodsDet;
	String goodsImage;
	String goodsType;
	Timestamp goodsRegist;
	String goodsOriginal;
	String goodsStore;
	Long goodsSize;	
	MultipartFile report;

}
