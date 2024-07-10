package co.yedam.vo;

import java.util.Date;

public class StudentVO {
	private String studentNumber; // student_number;
	private String studentName; // student_name;
	private String studentPhone; // student_phone
	private String address; // address
	private String birthDate; // birth_date
	private Date creationDate;
	
	
	
	public String getStudentNumber() {
		return studentNumber;
	}
	
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	
	
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	
	
	public String getStudentPhone() {
		return studentPhone;
	}
	
	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}
	
	
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	public String getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	
	
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	
	@Override
	public String toString() {
		return "StudentVO [studentNumber=" + studentNumber + ", studentName=" + studentName + ", studentPhone="
				+ studentPhone + ", address=" + address + ", birthDate=" + birthDate + ", creationDate=" + creationDate + "]";
	}
	
	public String briefShow() {
		return studentNumber + "  " + studentName + "  " + studentPhone;
	}
	
}
