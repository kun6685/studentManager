package co.yedam;

import co.yedam.control.StudentControl;

public class MainApplication {
	public static void main(String[] args) {
		StudentControl studentControl = new StudentControl();
		studentControl.run();
	}
}