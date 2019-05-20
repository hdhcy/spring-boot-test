package com.cun.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cun.entity.StudentTeacher;

import javax.persistence.criteria.CriteriaBuilder;

public interface StudentTeacherDao extends JpaRepository<StudentTeacher, Integer> {

	/**
	 * 1.1、学生关联查询
	 * @param id
	 * @return
	 */
	@Query(value = "select * from t_st where student_id=?1", nativeQuery = true)
	List<StudentTeacher> getStudentTeacherByStudentId(Integer id);

	/**
	 * 1.2、教师关联查询
	 * @param id
	 * @return
	 */
	@Query(value = "select * from t_st where teacher_id=?1", nativeQuery = true)
	List<StudentTeacher> getStudentTeacherByTeacherId(Integer id);



	/**
	 * 2.1、通过教师 id 删除师生关系
	 * ① 在 dao 层中加上@Modifying
	 * ② 注意添加 @Transactional，否则 TransactionRequiredException
	 * ③ @Transactional 建议还是在 Service 层中加上，不要在 Controller 层中
	 */
	@Modifying
	@Query(value="delete from t_st where teacher_id=?1",nativeQuery=true)
	void deleteConnectionByTeacherId(Integer teacherId);
	
	/**
	 * 2.2、通过学生 id 删除师生关系
	 * ① 在 dao 层中加上@Modifying，否则 SQLException
	 * ② 注意添加 @Transactional，否则 TransactionRequiredException
	 * ③ @Transactional 建议还是在 Service 层中加上，不要在 Controller 层中
	 */
	@Modifying
	@Query(value="delete from t_st where student_id=?1",nativeQuery=true)
	void deleteConnectionByStudentId(Integer studentId);

}
