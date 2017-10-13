package students;

import java.util.ArrayList;
import java.util.Scanner;

public class Management {
	private ArrayList<Student> students;
	private Scanner scan;
	public void runrun() {
		int sel;

		while (true) {
			System.out.println("�л����� ����");
			System.out.println("1.�߰�  2.��ȸ  3.�󼼰˻�  4.����  0.����");
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
				System.out.println("�߸��Է��Ͽ����ϴ�.");
			}

			if (sel == 0)
				break;
		}
		scan.close();
	}

	// �л� �߰�
	private void addStudent() {
		System.out.print("��     �� : ");
		String name = scan.nextLine();

		System.out.print("��     �� : ");
		String address = scan.nextLine();

		System.out.print("��ȭ��ȣ : ");
		String telnumber = scan.nextLine();

		Student student = new Student(name, address, telnumber);
		students.add(student);
	}

	// �л����� �˻�
	private void searchStudent() {
		viewStudent();

		System.out.println("�л� ��ȣ : ");
		int number = scan.nextInt();

		for (Student i : students)
			if (i.getNumber() == number) {
				System.out.print("��     ��: ");
				System.out.println(i.getName());
				System.out.print("��     ��: ");
				System.out.println(i.getAddress());
				System.out.print("��ȭ��ȣ: ");
				System.out.println(i.getTelnumber());
				break;
			}
	}

	// ����л� ����
	private void viewStudent() {
		System.out.println("�л� ���");
		for (Student i : students){
			System.out.print("��ȣ:" + i.getNumber() + "     �̸�:" + i.getName());
			System.out.println();
		}
	}

	// �л� ����
	private void delStudent() {
		int number;
		int index;
		boolean flag=true;
		
		while (flag && !students.isEmpty()) {
			viewStudent();
			index=0;
			System.out.println("�л� ��ȣ : ");
			number = scan.nextInt();
			scan.nextLine();
			
			for (Student i : students){
				if (i.getNumber() == number) {
					System.out.print("��     ��: ");
					System.out.println(i.getName());
					System.out.print("��     ��: ");
					System.out.println(i.getAddress());
					System.out.print("��ȭ��ȣ: ");
					System.out.println(i.getTelnumber());
					
					System.out.print("����?(Y/N) ");
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
