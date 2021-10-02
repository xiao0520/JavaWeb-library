package com.service;

import java.util.List;

import com.bean.Major;

public interface IMajorService {

	public List<Major> findAllMajor() throws Exception;
	
	public Major findMajorByNo(String no) throws Exception;
	
	public void insertMajor(Major major) throws Exception;
	
	public void updateMajor(String originalMajorNo,Major major) throws Exception;
	
	public void deleteMajorByNo(String no) throws Exception;
}
