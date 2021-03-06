package pcoop.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pcoop.backend.dao.CalendarDAO;
import pcoop.backend.dto.CalendarDTO;

@Service
public class CalendarService {
	
	@Autowired
	private CalendarDAO Cdao;
	
	public List<CalendarDTO> selectAll (int project_seq) throws Exception{
		return Cdao.selectAll(project_seq);
	}
	
	public int select_seq()throws Exception{
		return Cdao.select_seq();
	}
	
	public int addEvent (CalendarDTO dto)throws Exception{
		int result = Cdao.insert(dto);
		return result;
	}
	
	public CalendarDTO selectEvent(int seq)throws Exception{
		return Cdao.selectEvent(seq);
	}
	
	public int editEvent(CalendarDTO dto) throws Exception{
		return Cdao.editEvent(dto);
	}
	
	public int deleteEvent (int seq) throws Exception{
		return Cdao.deleteEvent(seq);
	}
}
