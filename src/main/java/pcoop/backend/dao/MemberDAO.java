package pcoop.backend.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pcoop.backend.dto.MemberDTO;

@Repository
public class MemberDAO {
	@Autowired
	private JdbcTemplate jdbc;
	@Autowired
	private SqlSessionTemplate mybatis;
	@Inject
	SqlSession sqlSession;
	
	   // ȸ������ ���� �޼ҵ�
		public void join(Map<String, Object>map, MemberDTO dto) {

			map.get("user_id");
			map.get("member_pass");
			map.get("e_mail");
			sqlSession.insert("member.insertUser",map);        
		}

	    //�α��ΰ��� �޼ҵ�
	    public boolean loginCheck(MemberDTO dto) {
	        String name
	            =sqlSession.selectOne("member.login_check", dto);
	        
	        //���ǽ� ? true�϶��� �� : false�϶��� ��
	        return (name==null) ? false : true;
	    }


	    //���̵� ã�� ���� �޼ҵ�
	    public String find_idCheck(MemberDTO dto) {
	        String id = sqlSession.selectOne("member.find_id_check", dto);
	        return id;
	        
	    }
	 
	    //��й�ȣ ã�� ���� �޼ҵ�
	    public String find_passCheck(MemberDTO dto) {
	        String pass = sqlSession.selectOne("member.find_pass_check", dto);
	        return pass;
	    }


	    //ȸ�� ���� ���� �޼ҵ�
	    //��ư�� Ŭ���� ȸ���� ������ ȸ�� ���̺� �����ؼ� ����� �� �ְ� ��
	    public void authentication(MemberDTO dto) {
	        
	        sqlSession.insert("member.authentication", dto);
	        
	    }
	    
	    
	    public void pass_change(Map<String, Object> map, MemberDTO dto)throws Exception{
	        
	        map.get("member_pass");
	        map.get("e_mail");
	 
	        sqlSession.update("member.pass_change", map);
	    }
	    
	    
	    public boolean email_check(String e_mail) throws Exception {
	        String email
	        =sqlSession.selectOne("member.email_check", e_mail);
	    
	        //���ǽ� ? true�϶��� �� : false�϶��� ��
	        return (email==null) ? true : false;
	        
	    }
	 
	 
	    public boolean join_name_check(String name) throws Exception {
	        String user_name1
	        =sqlSession.selectOne("member.join_name_check", name);
	    
	        //���ǽ� ? true�϶��� �� : false�϶��� ��
	        return (user_name1==null) ? true : false;
	    }
	 
	    
	    //ȸ���� ������ ������ �����Ѵ�.
	    public List<MemberDTO> member_profile(String user_id) throws Exception {
	        
	        return sqlSession.selectList("member.member_profile", user_id);
	    }
	    
	    

}
