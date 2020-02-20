package com.space.dao;

import java.util.List;

import com.space.bean.Branch;
/**
 * This is the Admin Branch DAO interface.It is used to access the objects from database.
 */
public interface AdminbranchDAO {
	
	//Branch DAO interface
			public int addbranch(Branch branch);
			public Branch viewBranch(int branchid);
			public List<Branch> viewAllBranch();
			public int updateBranch(int branchid,Branch branch);
			public int deleteBranch(int branchid);
		
			

}
