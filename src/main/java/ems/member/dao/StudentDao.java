package ems.member.dao;

import java.util.HashMap;
import java.util.Map;

import ems.member.Student;

public class StudentDao {
	/**
	 * 학생정보가 담겨져있는 데이터 ( DB 대신 임시로 사용하는 Map) */
	private Map<String, Student> studentDB = new HashMap<String, Student>();
	
	public void insert(Student student) { // insert
		studentDB.put(student.getsNum(), student);
	}
	
	public Student select(String sNum) { // select
		return studentDB.get(sNum);
	}
	
	public void update(Student student) { // update
		studentDB.put(student.getsNum(), student);
	}
	
	public void delete(String sNum) { // delete
		studentDB.remove(sNum);
	}
	
	public Map<String, Student> getStudentDB() { // DB 가져오기
		return studentDB;
	}
	
}
