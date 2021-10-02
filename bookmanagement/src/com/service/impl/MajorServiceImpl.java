
package com.service.impl;

import java.util.List;
import com.bean.Major;
import com.config.BeanFactory;
import com.dao.IMajorDao;
import com.service.IMajorService;

public class MajorServiceImpl implements IMajorService {
	
	private IMajorDao majorDao =  (IMajorDao) BeanFactory.getBean("majorDao");

	
	public List<Major> findAllMajor() throws Exception {return majorDao.findAllMajor();}

	public Major findMajorByNo(String no) throws Exception {return majorDao.findMajorByNo(no);}

	public void insertMajor(Major major) throws Exception {majorDao.insertMajor(major);}

	public void updateMajor(String originalMajorNo,Major major) throws Exception {majorDao.updateMajor(originalMajorNo,major);}

	public void deleteMajorByNo(String no) throws Exception {majorDao.deleteMajorByNo(no);}

}
