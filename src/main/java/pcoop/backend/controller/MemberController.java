package pcoop.backend.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pcoop.backend.service.MemberService;

@Controller  //��Ʈ�ѷ� �� ����
@RequestMapping("/member/")
public class MemberController {

	@Autowired    //���񽺸� ȣ���ϱ� ���ؼ� �������� ����
    JavaMailSender mailSender;     //���� ���񽺸� ����ϱ� ���� �������� ������.
	
	@Autowired
	private MemberService mservice; //���񽺸� ȣ���ϱ� ���� �������� ����

	@Autowired
	private HttpSession session; // �Է��� �̸����ּ� ����� 
	
	 //�α��� ���� ����
    private static final Logger logger=
    LoggerFactory.getLogger(MemberController.class);
    private static final String String = null;
	

    // mailSending �ڵ�
    @RequestMapping( value = "auth" , method=RequestMethod.POST )
    public ModelAndView mailSending(HttpServletRequest request, String e_mail, HttpServletResponse response_email) throws IOException {

        Random r = new Random();
        int dice = r.nextInt(4589362) + 49311; //�̸��Ϸ� �޴� �����ڵ� �κ� (����)
        
        String setfrom = "okeydoke2@naver.com";
        String tomail = request.getParameter("e_mail"); // �޴� ��� �̸���
        session.setAttribute("toemail", tomail); // ȸ������ ���������� �� ��츦 ����� ���� ����
        String title = "ȸ������ ���� �̸��� �Դϴ�."; // ����
        String content =
        
        System.getProperty("line.separator")+ //���پ� �ٰ����� �α����� �ۼ�
        
        System.getProperty("line.separator")+
                
        "�ȳ��ϼ��� ȸ���� ���� Ȩ�������� ã���ּż� �����մϴ�"
        
        +System.getProperty("line.separator")+
        
        System.getProperty("line.separator")+

        " ������ȣ�� " +dice+ " �Դϴ�. "
        
        +System.getProperty("line.separator")+
        
        System.getProperty("line.separator")+
        
        "������ ������ȣ�� Ȩ�������� �Է��� �ֽø� �������� �Ѿ�ϴ�."; // ����
        
        
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message,
                    true, "UTF-8");

            messageHelper.setFrom(setfrom); // �����»�� �����ϸ� �����۵��� ����
            messageHelper.setTo(tomail); // �޴»�� �̸���
            messageHelper.setSubject(title); // ���������� ������ �����ϴ�
            messageHelper.setText(content); // ���� ����
            
            mailSender.send(message);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        ModelAndView mv = new ModelAndView();    //ModelAndView�� ���� �������� �����ϰ�, ���� ���� �����Ѵ�.
        mv.setViewName("/member/email_injeung");     //�����̸�
        mv.addObject("dice", dice);
        
        System.out.println("mv : "+mv);

        response_email.setContentType("text/html; charset=UTF-8");
        PrintWriter out_email = response_email.getWriter();
        out_email.println("<script>alert('�̸����� �߼۵Ǿ����ϴ�. ������ȣ�� �Է����ּ���.');</script>");
        out_email.flush();
        
        return mv;
        
    }
    
    
    //�̸��� ���� ������ ���� �޼ҵ�
    @RequestMapping("email.do")
    public String email() {
    	System.out.println("�̸��� ���� ������ ���� �޼ҵ�");
    
        return "member/email";
    }
    
    
    //�̸��Ϸ� ���� ������ȣ�� �Է��ϰ� ���� ��ư�� ������ ���εǴ� �޼ҵ�.
    //���� �Է��� ������ȣ�� ���Ϸ� �Է��� ������ȣ�� �´��� Ȯ���ؼ� ������ ȸ������ �������� �Ѿ��,
    //Ʋ���� �ٽ� ���� �������� ���ƿ��� �޼ҵ�
    @RequestMapping(value = "join_injeung.do{dice}", method = RequestMethod.POST)
    public ModelAndView join_injeung(String email_injeung, @PathVariable String dice, HttpServletResponse response_equals) throws IOException {
              
        System.out.println("������ : email_injeung : "+email_injeung);      
        System.out.println("������ : dice : "+dice);     
        
        //�������̵��� �ڷḦ ���ÿ� �ϱ����� ModelAndView�� ����ؼ� �̵��� �������� �ڷḦ ����
         
        ModelAndView mv = new ModelAndView();     
        mv.setViewName("/member/join.do");  
        mv.addObject("e_mail",email_injeung);
        
        if (email_injeung.equals(dice)) {
            //������ȣ�� ��ġ�� ��� ������ȣ�� �´ٴ� â�� ����ϰ� ȸ������â���� �̵���
            
            mv.setViewName("member/join");
            mv.addObject("e_mail",email_injeung);
            //���� ������ȣ�� ���ٸ� �̸����� ȸ������ �������� ���� �Ѱܼ� �̸�����
            //�ѹ��� �Է��� �ʿ䰡 ���� �Ѵ�.
            

            mv.addObject("tomail",session.getAttribute("tomail"));//���ǿ��� ���������� �Է��� �����ּ� �ҷ�����
            System.out.println(session.getAttribute("tomail"));

            
            response_equals.setContentType("text/html; charset=UTF-8");
            PrintWriter out_equals = response_equals.getWriter();
            out_equals.println("<script>alert('������ȣ�� ��ġ�Ͽ����ϴ�. ȸ������â���� �̵��մϴ�.');</script>");
            out_equals.flush();
    
            return mv;
            
            
        }else if (email_injeung != dice) {
            
            
            ModelAndView mv2 = new ModelAndView(); 
            
            mv2.setViewName("member/email_injeung");
            
            response_equals.setContentType("text/html; charset=UTF-8");
            PrintWriter out_equals = response_equals.getWriter();
            out_equals.println("<script>alert('������ȣ�� ��ġ�����ʽ��ϴ�. ������ȣ�� �ٽ� �Է����ּ���.'); history.go(-1);</script>");
            out_equals.flush();
            
    
            return mv2;
            
        }    
    
        return mv;
    }
    
	
	
}
