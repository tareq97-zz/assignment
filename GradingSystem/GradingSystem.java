package com.grading.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.*;


class Student{
 	private String StudentName;
 	private Integer Semester ;
 	private Integer CourseNo;
	private Float TotalGPAResult;
 	private HashMap<String, Integer> map_sem_courses = new HashMap<String, Integer>();
	
	public Student(){
	}

	public void setStudentName(String name){
		this.StudentName = name;
	}
	
	public String getName(){
		return this.StudentName;
	}

	public void setTotalGPAResult(float TotalGPAResult){
		this.TotalGPAResult = TotalGPAResult;
	}

	public float getTotalGPAResult(){
		return this.TotalGPAResult;
	}

	public void setSemesterNo(int sem){
		this.Semester = sem;
	}
	
	public int getSemesterNo(){
		return this.Semester;
	}

	public void setCoursesNo(int CourseNo){
		this.CourseNo = CourseNo;
	}
	
	public int getCoursesNo(){
		return this.CourseNo;
	}

	public HashMap<String, Integer> getCourseMarks(){
		return this.map_sem_courses;
	}

	public HashMap<String, Integer> setCourseMarks(String course, Integer marks){
		map_sem_courses.put(course, marks);
		return map_sem_courses;
	}

	public float TotalGpa(Collection<Integer> collection){

		int result = 0;	
		int count = 0;	
		Iterator<Integer> iterator = collection.iterator();
        while (iterator.hasNext()) {
        	result = iterator.next() + result;
        	count++;
        	//if(!iterator.hasNext()){
        	//	iterator.next();
        	//}
        }
		return result/count;
	}
}

public class GradingSystem{
	private static ArrayList<Student> studentDb= new ArrayList<Student>();

	public static void main(String args[]) throws Exception{
		//Read the name of Student
		//Ask Grades store

		while(true){
			//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//String name = reader.readLine();
			//System.out.println(name);

			Scanner scan = new Scanner(System.in);
			System.out.println("Enter the student name: ");
			String sname = scan.nextLine();
			Student s = new Student();
			s.setStudentName(sname);
			System.out.println("Enter no of Semesters: ");
			s.setSemesterNo(Integer.parseInt(scan.nextLine()));

			for (int i =0 ; i< s.getSemesterNo() ; i++) {
				System.out.println("Enter no of Courses for Semester " + + (i+1) + ": ");
				s.setCoursesNo(Integer.parseInt(scan.nextLine()));
				
				for (int j=0; j<s.getCoursesNo(); j++) {
					System.out.println("Enter name of Course " + (j+1) + " and marks (Format Maths:100): ");
					String cour_marks = scan.nextLine();
					String[] arrOfStr = cour_marks.split(":", 2);
					s.setCourseMarks(arrOfStr[0],Integer.parseInt(arrOfStr[1]));
				}
			}

			Collection<Integer> s1 = s.getCourseMarks().values();
			
        	float totat_gpa = s.TotalGpa(s1);
			System.out.println("Student Name : " + s.getName() + " GPA : " + totat_gpa);

			s.setTotalGPAResult(totat_gpa);

			studentDb.add(s);

			System.out.println("---------------------------------");
			System.out.println("List of Students entered till now");
			System.out.println("---------------------------------");
			for (Student e : studentDb) {
				System.out.println("Student Name: " + e.getName() + " GPA: " + e.getTotalGPAResult());
			}

			System.out.println("Do u want to continue Y/N:");
			String conOrNot = "";
			conOrNot = scan.nextLine();

			if(conOrNot.equalsIgnoreCase("Y")){
				continue;
			}
			else {
				break;
			}
		}
	}
} 