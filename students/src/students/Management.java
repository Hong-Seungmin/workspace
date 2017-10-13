package students;

import java.util.ArrayList;
import java.util.Scanner;

public class Management {
	private ArrayList<Student> students;
	private Scanner scan;
	public void runrun() {
		int sel;

		while (true) {
			System.out.println("학생정보 관리");
			System.out.println("1.추가  2.조회  3.상세검색  4.삭제  0.종료");
			sel = scan.nextInt();
			scan.nextLine();
			
			switch (sel) {
			case 1:
				addStudent();
				break;
			case 2:
				viewStudent();
				break;
			case 3:
				searchStudent();
				break;
			case 4:
				delStudent();
				break;
			case 0:
				break;
			default:
				System.out.println("잘못입력하였습니다.");
			}

			if (sel == 0)
				break;
		}
		scan.close();
	}

	// 학생 추가
	private void addStudent() {
		System.out.print("이     름 : ");
		String name = scan.nextLine();

		System.out.print("주     소 : ");
		String address = scan.nextLine();

		System.out.print("전화번호 : ");
		String telnumber = scan.nextLine();

		Student student = new Student(name, address, telnumber);
		students.add(student);
	}

	// 학생정보 검색
	private void searchStudent() {
		viewStudent();

		System.out.println("학생 번호 : ");
		int number = scan.nextInt();

		for (Student i : students)
			if (i.getNumber() == number) {
				System.out.print("이     름: ");
				System.out.println(i.getName());
				System.out.print("주     소: ");
				System.out.println(i.getAddress());
				System.out.print("전화번호: ");
				System.out.println(i.getTelnumber());
				break;
			}
	}

	// 모든학생 보기
	private void viewStudent() {
		System.out.println("학생 목록");
		for (Student i : students){
			System.out.print("번호:" + i.getNumber() + "     이름:" + i.getName());
			System.out.println();
		}
	}

	// 학생 삭제
	private void delStudent() {
		int number;
		int index;
		boolean flag=true;
		
		while (flag && !students.isEmpty()) {
			viewStudent();
			index=0;
			System.out.println("학생 번호 : ");
			number = scan.nextInt();
			scan.nextLine();
			
			for (Student i : students){
				if (i.getNumber() == number) {
					System.out.print("이     름: ");
					System.out.println(i.getName());
					System.out.print("주     소: ");
					System.out.println(i.getAddress());
					System.out.print("전화번호: ");
					System.out.println(i.getTelnumber());
					
					System.out.print("삭제?(Y/N) ");
					if(scan.nextLine().equals("Y")){
						students.remove(index);
						flag=false;
					}
					break;
				}
				index++;
			}
		}
	}

	public Management() {
		scan = new Scanner(System.in);
		students = new ArrayList<Student>();
	}

	public static void main(String[] args) {
		new Management().runrun();
	}

}
