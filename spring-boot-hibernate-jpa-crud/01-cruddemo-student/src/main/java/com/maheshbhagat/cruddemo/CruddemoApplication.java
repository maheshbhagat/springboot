package com.maheshbhagat.cruddemo;

import com.maheshbhagat.cruddemo.dao.StudentDAO;
import com.maheshbhagat.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner -> {
			//createStudent(studentDAO);
			//readStudent(studentDAO, 1);
			//findAllStudents(studentDAO);
			//findStudentByLastName(studentDAO, "Dagala");
			updateStudent(studentDAO);
		};
	}

	private void updateStudent(StudentDAO studentDAO) {

		Student student = studentDAO.findById(2);
		System.out.println("Retrieved Student: "+student);
		
		student.setEmail("nilamdagala@gmail.com");
		studentDAO.update(student);

		System.out.println("Updated Student: "+student);
	}

	private void findAllStudents(StudentDAO studentDAO) {

		List<Student> studentList = studentDAO.findAll();
		studentList.stream().forEach(student -> System.out.println(student));
	}

	private void findStudentByLastName(StudentDAO studentDAO, String lastName) {

		List<Student> studentList = studentDAO.findByLastName(lastName);
		studentList.stream().forEach(student -> System.out.println(student));
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student student = new Student("Mayoo", "Bhagat", "mahesh.bhagat@gmail.com");

		System.out.println("Saving the object...");
		studentDAO.save(student);

		System.out.println("Saved Student. Generated Id: "+student.getId());
	}

	private void readStudent(StudentDAO studentDAO, int id){
		System.out.println("Reading student object");

		Student student = studentDAO.findById(id);
		System.out.println("Read Student: "+student);
	}



}
