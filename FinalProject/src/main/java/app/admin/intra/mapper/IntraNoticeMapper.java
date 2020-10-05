package app.admin.intra.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import app.admin.intra.domain.IntraNoticeDTO;

@Component
@Repository(value = "app.admin.intra.mapper.IntraNoticeMapper")
public interface IntraNoticeMapper {
	public int insertNotice(IntraNoticeDTO dto) throws Exception;
	public List<IntraNoticeDTO> viewNotice() throws Exception;
	public IntraNoticeDTO detailNotice(Integer notNo)throws Exception;
	public IntraNoticeDTO modifyNotice(Integer notNo) throws Exception; 
	public void updateNotice(IntraNoticeDTO dto)throws Exception;
	public void deleteNotice(IntraNoticeDTO dto)throws Exception;
}
