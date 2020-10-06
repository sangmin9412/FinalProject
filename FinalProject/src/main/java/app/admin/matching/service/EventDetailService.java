package app.admin.matching.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.matching.domain.EventDTO;
import app.admin.matching.mapper.EventMapper;
import app.domain.StartEndPageDTO;

@Service
@Component
public class EventDetailService {
	@Autowired
	EventMapper eventMapper;
	public void execute(String eveNo, Model model) throws Exception {
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L,1L,null,eveNo);
		EventDTO eventDTO=eventMapper.selectEvent(startEndPageDTO).get(0);
		String [] originalFile=eventDTO.getEveOriginalImage().split("`");
		String [] storeFile=eventDTO.getEveStoreImage().split("`");
		List<EventDTO> fileList=new ArrayList<EventDTO>();
		int i=0;
		
		for (String file : originalFile) {
			System.out.println(file);
			EventDTO fileName=new EventDTO(file,storeFile[i]);
			fileList.add(fileName);
			i++;
		}
		model.addAttribute("eventDTO",eventDTO);
		model.addAttribute("fileList",fileList);
	}

}
