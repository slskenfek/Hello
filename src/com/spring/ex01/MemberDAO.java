package com.spring.ex01;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	//SqlSessionFactory��ü�� ������ ����
	public static SqlSessionFactory sqlMapper = null;
	
	private static SqlSessionFactory getInstance(){
		
		if(sqlMapper == null){
			try {
				//MemberDAO�� �� �޼ҵ� ȣ��� src/mybatis/SqlMapConfig.xml����
				//���������� ���� �� �����ͺ��̽��� ���� �غ� �մϴ�.
				Reader reader = 
						Resources.getResourceAsReader("mybatis/SqlMapConfig.xml");
				
				//���̹�Ƽ���� �̿��ϴ� SqlSessionFactory��ü�� �����ɴϴ�.
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				
				//�ڿ�����
				reader.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper; //SqlSessionFactory��ü ��ȯ
		
	}//getInstance()�޼ҵ� ��
	
	
	public List<MemberVO> selectAllMemberList(){
		//���̹�Ƽ�������ӿ�ũ�� ���� �ִ� SqlSessionFactory��ü ���
		sqlMapper = getInstance();
		
		//���� member.xml�� SQL���� ȣ���ϴµ� ���Ǵ� SqlSession��ü�� �����ɴϴ�.
		SqlSession session = sqlMapper.openSession();
		
		//��ȸ�� ȸ������(MemberVO)���� �����ϱ� ���� �뵵��  List��������
		List<MemberVO> memlist = null;
		
		//�������� �ڵ带 ��ȸ�ϹǷ� selectList()�޼ҵ带 ȣ���ϸ鼭
		//���ڷ� mapper.member.selectAllMemberList�� ������
		//member.xml���� �ش� ���ӽ����̽��� id�Ӽ��� �ش��ϴ� SQL���� �����մϴ�.
		//���⼭ selectList()�޼ҵ�� member.xml���� ���ο��� DB�� ���� �˻��� �����
		//MemberVO��ü ���� ���, �ٽ� List�� ��� ���� �޴´�.
		memlist = session.selectList("mapper.member.selectAllMemberList");
		
		return memlist; //List����
		
	}
	
	
	
	
}//MmeberDAOŬ���� ��









