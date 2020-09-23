package app.intra.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.controller.PageAction;
import app.domain.StartEndPageDTO;
import app.intra.domain.IntraEmployeeDTO;
import app.intra.mapper.IntraEmployeeMapper;

@Component
@Service
public class IntraEmployeeDetailService {
	@Autowired
	IntraEmployeeMapper intraEmployeeMapper;

	public void employeeDetail(Model model, String empId) throws Exception {
		
		StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, empId, null);
		IntraEmployeeDTO list = intraEmployeeMapper.selectAllEmployee(dto).get(0);
		
		model.addAttribute("intraEmployeeCommand", list);
		
	}
	
}
