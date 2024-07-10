package co.yedam.control;

import java.util.List;

import java.util.Scanner;

import co.yedam.dao.StudentDAO;
import co.yedam.vo.StudentVO;


public class StudentControl {
	
	Scanner scanner = new Scanner(System.in);
	StudentDAO studentDAO = new StudentDAO();
	
	public void run() {
		boolean isTrue = true;
		
		while(isTrue) {
			
			System.out.println("1.학생목록   2.등록   3.수정   4.삭제   5.종료");
			System.out.print("선택 > ");
			
			int menuSelect = Integer.parseInt(scanner.nextLine());
			
			switch(menuSelect) {
			case 1:
				studentList();
				break;
			case 2:
				addStudent();
				break;
			case 3:
				updateStudent();
				break;
			case 4:
				deleteStudent();
				break;
			case 5:
				System.out.println("종료합니다");
				isTrue = false;
				break;
			}
		}
	}
	
	// 목록 출력 기능
	void studentList() {
		List<StudentVO> studentList = studentDAO.selectList();
		System.out.println("학생번호   학생이름   연락처");
		System.out.println("----------------------");
		
		for(StudentVO studentVO : studentList) {
			System.out.println(studentVO.briefShow());
		}
	}
	
	// 등록 기능
	void addStudent() {
	System.out.print("학생번호 입력 > ");
	String studentNumber = scanner.nextLine();
	
	System.out.print("학생이름 입력 > ");
	String studentName = scanner.nextLine();
	
	System.out.print("연락처 입력 > ");
	String phoneNumber = scanner.nextLine();
	
	System.out.print("주소 입력 > ");
	String address = scanner.nextLine();
	
	System.out.print("생일 입력 > ");
	String birthDate = scanner.nextLine();
	
	StudentVO studentVO = new StudentVO();
	studentVO.setStudentNumber(studentNumber);
	studentVO.setStudentName(studentName);
	studentVO.setStudentPhone(phoneNumber);
	studentVO.setAddress(address);
	studentVO.setBirthDate(birthDate);
	
	if(studentDAO.insertStudent(studentVO)) {
		System.out.println("저장 완료!");
	} else {
		System.out.println("예외 발생!");
	}
	
	
	}
	
	// 수정 기능
	void updateStudent() {
		System.out.print("수정할 학생번호 입력 > ");
		String studentNumber = scanner.nextLine();
		
		System.out.print("학생이름 입력 > ");
		String studentName = scanner.nextLine();
		
		System.out.print("연락처 입력 > ");
		String phoneNumber = scanner.nextLine();
		
		System.out.print("주소 입력 > ");
		String address = scanner.nextLine();
		
		System.out.print("생일 입력 > ");
		String birthDate = scanner.nextLine();
		
		StudentVO studentVO = new StudentVO();
		studentVO.setStudentNumber(studentNumber);
		studentVO.setStudentName(studentName);
		studentVO.setStudentPhone(phoneNumber);
		studentVO.setAddress(address);
		studentVO.setBirthDate(birthDate);
		
		if(studentDAO.updateStudent(studentVO)) {
			System.out.println("수정 완료!");
		} else {
			System.out.println("예외 발생!");
		}
	}
	
	// 제거 기능
	   void deleteStudent() {
			System.out.print("제거할 학생번호 입력 > ");
			String studentNumber = scanner.nextLine();
			
			StudentVO studentVO = new StudentVO();
			studentVO.setStudentNumber(studentNumber);
			
			if(studentDAO.deleteStudent(studentVO)) {
				System.out.println("제거 완료!");
			} else {
				System.out.println("예외 발생!");
			}
		}
}
