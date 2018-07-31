package com.cun.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cun.dao.StudentDao;
import com.cun.dao.StudentTeacherDao;
import com.cun.entity.Student;
import com.cun.entity.StudentTeacher;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/student")
@EnableSwagger2
@Transactional // 自定义update、delete、insert 的 Dao 接口必备
public class StudentController {

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private StudentTeacherDao studentTeacherDao;

	/**
	 * 1、查
	 * ① 这个查的返回值应该是一个 List 集合
	 * ② 一个学生可以有多个教师
	 * ③ 使用关系表的 JPA 查询来完成
	 * @param id
	 * @return
	 */
	@GetMapping("/get/{id}")
	public List<StudentTeacher> getStudent(@PathVariable Integer id) {
		// return studentDao.findOne(id); //不符合实际需求的
		return studentTeacherDao.getStudentTeacherByStudentId(id);
	}

	/**
	 * 2、增
	 * @param student
	 * @return
	 */
	@PostMapping("insert")
	public Student insertStudent(Student student) {
		studentDao.save(student);

		// 保存后的 student 有 id
		return student;
	}

	/**
	 * 3、改
	 * @param student
	 * @return
	 */
	@PutMapping("/update")
	public Student updateStudent(Student student) {
		studentDao.save(student);
		return student;
	}

	/**
	 * 4、删：
	 * ① 删除前要判断是否存在关联关系，不同于一对多/多对一
	 * ② 多对要先把关系删除掉，否则 ConstraintViolationException！
	 * ③ 再把要删除的删掉，不会手下留情了！
	 * ④ 注意添加 @Transactional，建议还是在 Service 层中加上，不要在 Controller 层中
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public Student deleteStudent(@PathVariable Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		Student student = studentDao.findOne(id);
		map.put("data", student);
		
		//先断绝来外
		studentTeacherDao.deleteConnectionByStudentId(id);
		
		//再铲除
		studentDao.delete(id);
		return student;
	}

	/**
	 * 5、全
	 * @return
	 */
	@GetMapping("/all")
	public List<Student> getAllStudents() {
		return studentDao.findAll();
	}

}
