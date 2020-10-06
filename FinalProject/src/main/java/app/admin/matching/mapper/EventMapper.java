package app.admin.matching.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import app.admin.matching.domain.EventDTO;

@Component
@Repository
public interface EventMapper {
	public void eventInsert(EventDTO dto);
}
