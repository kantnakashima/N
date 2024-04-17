package com.example.tokuten.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.example.tokuten.model.ClassnumModel;
import com.example.tokuten.repository.ClassnumRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ClassnumService {

	@Autowired
	private ClassnumRepository repository;

	/**
	 * @return List<ClassnumModel>
	 */
	public List<ClassnumModel> getClassnumModelList() {
	    List<ClassnumModel> entityList = this.repository.findAll();
	    return entityList;
	}

	/**
	 * 詳細データの取得
	 * @param @NonNull Long index
	 * @return  AddressBook
	 */
	public ClassnumModel get(@NonNull Long index) {
		ClassnumModel ClassnumModel = this.repository.findById(index).orElse(new ClassnumModel());
		return ClassnumModel;
	}

	/**
	 * アドレス帳データの保存
	 * @param 
	 */
	public void save(@NonNull ClassnumModel ClassnumModel) {
		this.repository.save(ClassnumModel);
	}

	/**
	 * アドレス帳データの削除
	 * @param @NonNull Long index
	 */
	public void delete(@NonNull Long index) {
		this.repository.deleteById(index);
	}
}
