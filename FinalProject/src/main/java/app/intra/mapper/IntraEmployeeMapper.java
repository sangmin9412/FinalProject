package app.intra.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import app.domain.StartEndPageDTO;
import app.intra.domain.IntraDepartmentDTO;
import app.intra.domain.IntraEmployeeDTO;

@Component
@Repository(value = "app.intra.mapper")
public interface IntraEmployeeMapper {
	public int insertEmployee(IntraEmployeeDTO dto) throws Exception;
	public List<IntraDepartmentDTO> selectAllDepartment() throws Exception;
	public List<IntraEmployeeDTO> selectAllEmployee(StartEndPageDTO dto) throws Exception;
	public int selectCountEmployee() throws Exception;
	public Integer updateEmployee(IntraEmployeeDTO dto) throws Exception;
	
}
