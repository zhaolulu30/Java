package dao;

import java.util.List;






import bean.QingJia;
import bean.QueryCondition;
import bean.QueryCondition1;



public interface QingjiaDao {


	List<QingJia> findByCondition(QueryCondition condition) throws Exception;
	List<QingJia> findByCondition1(QueryCondition1 condition1) throws Exception;
}
