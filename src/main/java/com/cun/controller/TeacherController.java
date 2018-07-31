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

import com.cun.dao.StudentTeacherDao;
import com.cun.dao.TeacherDao;
import com.cun.entity.StudentTeacher;
import com.cun.entity.Teacher;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/teacher")
@EnableSwagger2
@Transactional // 自定义update、delete、insert 的 Dao 接口必备
public class TeacherController {

	@Autowired
	private TeacherDao teacherDao;

	@Autowired
	private StudentTeacherDao studentTeacherDao;

	/**
	 * 1、查
	 * ① 这个查应该应该是一个 List 集合
	 * ② 一个教师可以有多个学生
	 * ③ 使用关系表的 JPA 查询来完成
	 * @param id
	 * @return
	 */
	@GetMapping("/get/{id}")
	public List<StudentTeacher> getTeacherById(@PathVariable Integer id) {
		// return teacherDao.findOne(id); //不符合实际需求的
		return studentTeacherDao.getStudentTeacherByTeacherId(id);
	}

	/**
	 * 2、删:
	 * ① 删除前要判断是否存在关联关系，不同于一对多/多对一
	 * ② 多对要先把关系删除掉，否则 ConstraintViolationException！
	 * ③ 再把要删除的删掉，不会手下留情了！
	 * ④ 注意添加 @Transactional，建议还是在 Service 层中加上，不要在 Controller 层中
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public Map<String, Object> deleteTeacherById(@PathVariable Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		Teacher teacher = teacherDao.findOne(id);
		map.put("data", teacher);
		
		//先断绝来外
		studentTeacherDao.deleteConnectionByTeacherId(id);
		
		//再铲除
		teacherDao.delete(id);
		return map;
	}

	/**
	 * 3、改
	 * @param teacher
	 * @return
	 */
	@PutMapping("/update")
	public Teacher updateTeacher(Teacher teacher) {
		teacherDao.save(teacher);
		return teacher;
	}

	/**
	 * 4、增
	 * @param teacher
	 * @return
	 */
	@PostMapping("/insert")
	public Teacher insertTeacher(Teacher teacher) {
		teacherDao.save(teacher);
		// save 后 teacher 有 id 了
		return teacher;
	}

	/**
	 * 5、全
	 * @return
	 */
	@GetMapping("/all")
	public List<Teacher> getAllTeachers() {
		return teacherDao.findAll();
	}

}
