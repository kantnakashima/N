package com.example.tokuten.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.example.tokuten.model.StudentModel;
import com.example.tokuten.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentRepository repository;

	/**
	 * @return List<StudentModel>
	 */
	public List<StudentModel> getStudentModelList() {
	    List<StudentModel> entityList = this.repository.findAll();
	    return entityList;
	}

	/**
	 * 詳細データの取得
	 * @param @NonNull Long index
	 * @return  AddressBook
	 */
	public StudentModel get(@NonNull Long id) {
		StudentModel StudentModel = this.repository.findById(id).orElse(new StudentModel());
		return StudentModel;
	}

	/**
	 * アドレス帳データの保存
	 * @param 
	 */
	public void save(@NonNull StudentModel StudentModel) {
		this.repository.save(StudentModel);
	}

	/**
	 * アドレス帳データの削除
	 * @param @NonNull Long index
	 */
	public void delete(@NonNull Long id) {
		this.repository.deleteById(id);
	}
	public void update(StudentModel StudentModel) {
		
	    // データベースに登録する値を保持するインスタンスの作成
		StudentModel StudentModels = new StudentModel();
			
	    // 画面から受け取った値を設定する
		StudentModels.setid(StudentModel.getid());
		StudentModels.setNAME(StudentModel.getNAME());
		StudentModels.setCLASS_NUM(StudentModel.getCLASS_NUM());
			
	    // データベースを更新する
	    repository.save(StudentModels);
	}
}
