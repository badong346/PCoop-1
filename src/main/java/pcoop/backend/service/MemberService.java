package pcoop.backend.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import pcoop.backend.dao.MemberDAO;
import pcoop.backend.dto.MemberDTO;

@Service
public class MemberService {
	@Autowired
	private MemberDAO mdao;
	
    private JavaMailSender mailSender;
    
    
    //ȸ������ �޼ҵ�, Map�� dto�� ���� �ѱ�
    public void join(Map<String, Object>map,MemberDTO dto) {
    	mdao.join(map,dto);
 
    }
 
    //�α��� ���� �޼ҵ� (���ǿ� ���̵�� ��й�ȣ�� ����)
    public boolean loginCheck(MemberDTO dto, HttpSession session) {
        
        boolean result = mdao.loginCheck(dto);
        if(result) {    //�α��� ����
            session.setAttribute("email", dto.getEmail());
            session.setAttribute("pw", dto.getPw());
            System.out.println(session.getAttribute("email"));
            System.out.println(session.getAttribute("pw"));
        }
        
        return result;
    }
 
    //���̵� ã��
    public String find_idCheck(MemberDTO dto) {
        String id = mdao.find_idCheck(dto);
        
        return id;
    }
 
    //��й�ȣ ã��
    public String find_passCheck(MemberDTO dto) {
        String pass = mdao.find_passCheck(dto);
        return pass;
    }
 
 
    public void authentication(MemberDTO dto) {
        
    	mdao.authentication(dto);
    }
 
 
    public void pass_change(Map<String, Object> map, MemberDTO dto) throws Exception {
        
        
    	mdao.pass_change(map,dto);
    }
 
 
    //�̸��� �ߺ� Ȯ��
    public boolean email_check(String email) throws Exception{
        
        boolean result = mdao.email_check(email);
        
        return result;
        
    }
 
    //�̸� �ߺ� Ȯ�� join_id_check ��� join_name_check
    public boolean join_name_check(String name) throws Exception {
    
        boolean result = mdao.join_name_check(name);
        
        return result;
    }
 
 
    //�ڽ��� �������� �� �� �ְ� �ϴ� �޼ҵ�
    public List<MemberDTO> member_profile(String user_id) throws Exception{
        
        return mdao.member_profile(user_id);
    }
	
	
}
