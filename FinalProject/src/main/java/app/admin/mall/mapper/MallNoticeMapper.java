package app.admin.mall.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import app.admin.mall.domain.MallNoticeDTO;

@Component
@Repository(value = "app.admin.mall.mapper.MallNoticeMapper")
public interface MallNoticeMapper {
	public int mallNotice(MallNoticeDTO dto) throws Exception;
	public List<MallNoticeDTO> viewNotice() throws Exception;
	public MallNoticeDTO detailNotice(Integer notNo)throws Exception;
	public MallNoticeDTO modifyNotice(Integer notNo) throws Exception; 
	public void updateNotice(MallNoticeDTO dto)throws Exception;
	public void deleteNotice(MallNoticeDTO dto)throws Exception;
	public int noticeCount()throws Exception;
}
