package logic;


public class ArticleLogic {

	/*
	public long countLikesForArticle(long articleId) {
		
		String sql = "select count(likes.pkid) as amount "
				   + "from likes join shorts on likes.shortid = shorts.pkid "
				   + "where shorts.articleid = :id";
		
	    SqlRow sqlRow =
	                Ebean.createSqlQuery(sql).setParameter("id", articleId).findUnique(); 
		
	    return sqlRow.getLong("amount");
	}
	*/
	
}
