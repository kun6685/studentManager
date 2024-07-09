package co.yedam.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import co.yedam.vo.StudentVO;

public class AppTest {
	
	public static void main(String[] args) {
		
//    1) Oracle JDBC Driver 자바 라이브러리.
//    2) Connection 객체.
		Scanner scanner = new Scanner(System.in);
		
//		System.out.print("학생번호 입력 > ");
//		String studentNumber = scanner.nextLine();
//		
//		System.out.print("학생이름 입력 > ");
//		String studentName = scanner.nextLine();
//		
//		System.out.print("연락처 입력 > ");
//		String phoneNumber = scanner.nextLine();
//		
//		addStudent(studentNumber, studentName, phoneNumber); // 입력기능 메소드 호출
		
		
//		System.out.print("수정할 학생번호 입력 > ");
//		String modifyStudentNumber = scanner.nextLine();
//		
//		System.out.print("학생이름 입력 > ");
//		String modifyStudentName = scanner.nextLine();
//		
//		System.out.print("연락처 입력 > ");
//		String modifyPhoneNumber = scanner.nextLine();
//		
//		modifyStudent(modifyStudentNumber, modifyStudentName, modifyPhoneNumber);
		
//		System.out.print("삭제할 학생번호 입력 > ");
//		String removeStudentNumber = scanner.nextLine();
//	
//		removeStudent(removeStudentNumber);
		
		System.out.print("수정할 학생번호 입력 > ");
		String modifyStudentNumber = scanner.nextLine();
		
		System.out.print("학생이름 입력 > ");
		String modifyStudentName = scanner.nextLine();
		
		System.out.print("연락처 입력 > ");
		String modifyPhoneNumber = scanner.nextLine();
		
		System.out.print("주소 입력 > ");
		String modifyAddress = scanner.nextLine();
		
		System.out.print("생일 입력 > ");
		String modifyBirth = scanner.nextLine();
		
		StudentVO studentVO = new StudentVO();
		studentVO.setStudentNumber(modifyStudentNumber);
		studentVO.setStudentName(modifyStudentName);
		studentVO.setStudentPhone(modifyPhoneNumber);
		studentVO.setAddress(modifyAddress);
		studentVO.setBirthDate(modifyBirth);
		
		modifyStudent2(studentVO);
		
		search(); // 조회기능 메소드 호출
	}
	
	
  // 수정기능
	public static void modifyStudent(String modifyStudentNumber, String modifyStudentName, String modifyPhoneNumber) {
		 Connection connection = getConnection();
		 String sql = "UPDATE table_student ";
		 sql += "SET student_name = '" + modifyStudentName + "'";
		 sql += "    ,student_phone = '" + modifyPhoneNumber + "'";
		 sql += "WHERE student_number = '" + modifyStudentNumber + "'";
		try {
		 Statement stament = connection.createStatement();
		 int r = stament.executeUpdate(sql); // insert, update, delete => 처리된 건수
		 System.out.println("처리된 건수는" + r + "건");
		} catch(SQLException e) {
			 e.printStackTrace();
		}
	}
	
	public static void modifyStudent2(StudentVO studentVO) {
		Connection connection = getConnection();
		String sql = "UPDATE table_student ";
		sql += "SET student_name = nvl('" + studentVO.getStudentName() + "', student_name)";
		sql += "   ,student_phone = nvl('" + studentVO.getStudentPhone() + "', student_phone)";
		sql += "   ,address = nvl('" + studentVO.getAddress() + "', address)";
		sql += "   ,birth_date = nvl('" + studentVO.getBirthDate() + "', birth_date)";
		sql += "WHERE student_number = '" + studentVO.getStudentNumber() + "'";
		
		try {
			 Statement stament = connection.createStatement();
			 int r = stament.executeUpdate(sql); // insert, update, delete => 처리된 건수
			 System.out.println("처리된 건수는" + r + "건");
			} catch(SQLException e) {
				 e.printStackTrace();
			}
	}
	
//	입력기능
//	INSERT INTO table_student (student_number, student_name, student_phone)
//	VALUES('s2024-01', '홍길동', '010-1264-5678');
	
	public static void addStudent(String studentNumber, String studentName, String phoneNumber) {
		Connection connection = getConnection();
		String sql = "INSERT INTO table_student (student_number, student_name, student_phone, address)";
		sql += "VALUES('"+ studentNumber +"', '" + studentName + "', '" + phoneNumber + "', '서울 100번지')";
		try {
		Statement stament = connection.createStatement();
		int r = stament.executeUpdate(sql); // insert, update, delete => 처리된 건수
		System.out.println("처리된 건수는" + r + "건");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// 삭제기능
	public static void removeStudent(String removeStudentNumber) {
		Connection connection = getConnection();
		String sql = "DELETE FROM table_student ";
    sql += "WHERE student_number = '" + removeStudentNumber + "'";
		try {
		Statement stament = connection.createStatement();
		int r = stament.executeUpdate(sql); // insert, update, delete => 처리된 건수
		System.out.println("처리된 건수는" + r + "건");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// 조회기능
	public static void search() {
		
		try {
			Connection connection = getConnection();
			Statement stament = connection.createStatement();
			ResultSet rs = stament.executeQuery("SELECT * FROM table_student");
			// [객체1, 객체2, 객체3]
			
			while(rs.next()) {
				String birth = rs.getString("birth_date");
				birth = birth != null ? birth.substring(0, 10) : "";
				System.out.println(rs.getString("student_number") + ", " + rs.getString("student_name") + ", " + rs.getString("student_phone"));
			}
				System.out.println("end of data.");
				
		} catch(SQLException e) {
				e.printStackTrace();
		}
		
	}
}
