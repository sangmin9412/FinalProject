package app.admin.matching.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import app.admin.matching.domain.EventDTO;
import app.domain.StartEndPageDTO;

@Component
@Repository
public interface EventMapper {
	public void eventInsert(EventDTO dto);
	public List<EventDTO> selectEvent(StartEndPageDTO startEndPageDTO) throws Exception;
	public Integer getEventCount();
}
