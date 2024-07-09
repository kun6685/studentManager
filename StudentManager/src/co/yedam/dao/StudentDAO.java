package co.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.vo.StudentVO;

// 등록(C), 목록(R), 수정(U), 삭제(D)
// 주의 : DAO 메세지가 없음.

public class StudentDAO extends DAO {
	
	// 등록 기능
	public boolean insertStudent(StudentVO studentVO) {
		String sql = "INSERT INTO table_student (student_number, student_name, student_phone, address, birth_date)";
		sql += "VALUES(?, ?, ?, ?, ?)";
		connection = getConnection();
		try {
			psmt = connection.prepareStatement(sql);
			psmt.setString(1, studentVO.getStudentNumber());
			psmt.setString(2, studentVO.getStudentName());
			psmt.setString(3, studentVO.getStudentPhone());
			psmt.setString(4, studentVO.getAddress());
			psmt.setString(5, studentVO.getBirthDate());
			
			int r = psmt.executeUpdate();
			if(r == 1) {
				return true; // 정상 처리
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 비정상 처리
	}
	
	// 목록 반환 기능
	public List<StudentVO> selectList() {
				 String sql = "SELECT * FROM table_student ORDER BY student_number";
				 List<StudentVO> list = new ArrayList<>();
		
		
		connection = getConnection();
		
		try {
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);
		while(resultSet.next()) {
			StudentVO studentVO = new StudentVO();
			
			studentVO.setAddress(resultSet.getString("address"));
			studentVO.setBirthDate(resultSet.getString("birth_date"));
			studentVO.setCreationDate(resultSet.getDate("creation_date"));
			studentVO.setStudentName(resultSet.getString("student_name"));
			studentVO.setStudentNumber(resultSet.getString("student_number"));
			studentVO.setStudentPhone(resultSet.getString("student_phone"));
			
			
			list.add(studentVO);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
