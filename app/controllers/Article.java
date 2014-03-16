package controllers;

import java.util.LinkedList;
import java.util.List;

import logic.common.Tools;
import logic.dto.response.ArticleResponse;
import logic.dto.response.ArticlesResponse;
import logic.dto.response.ResponseHandler;
import logic.exceptions.ArticleNotFound;
import logic.exceptions.ExceptionHandler;
import logic.exceptions.LogicException;
import logic.exceptions.ValidationException;
import models.views.ArticleView;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import com.avaje.ebean.Page;
import com.avaje.ebean.PagingList;

/**
 * 
 * @author piotr.kosiakowski
 *
 */
public class Article extends Controller {

	@BodyParser.Of(BodyParser.Json.class)
	public static Result getById(Long id) {
		response().setContentType("application/json");
		
		ArticleResponse response = new ArticleResponse();
		
		try {
			models.views.ArticleView article = models.views.ArticleView.find.byId(id);
			if (article == null) {
				throw new ArticleNotFound();
			}
			
			response = new ArticleResponse(article);
			
			ResponseHandler<ArticleResponse> handler = new ResponseHandler<>(response);
			return ok(handler.prepareResponse());
			
		}
		catch(LogicException ex) {
			ExceptionHandler<ArticleResponse> exceptionHandler = new ExceptionHandler<>(ex, response);
			String msg = exceptionHandler.prepareResponse();
			if (msg == null) {
				return badRequest();
			}
			return ok(msg);
		}
		catch(Exception ex) {
			return ok(ex.getMessage());
		}
	}
	
	public static Result getByUrl(String url) {
		response().setContentType("application/json");

		ArticleResponse response = new ArticleResponse();
		
		try {

			String md5 = Tools.md5(url);
			
			models.views.ArticleView article = models.views.ArticleView.find.where().ieq("url_hash", md5).findUnique();
			if (article == null) {
				throw new ArticleNotFound();
			}
			
			response = new ArticleResponse(article);
			
			ResponseHandler<ArticleResponse> handler = new ResponseHandler<>(response);
			return ok(handler.prepareResponse());
			
		}
		catch(LogicException ex) {
			ExceptionHandler<ArticleResponse> exceptionHandler = new ExceptionHandler<>(ex, response);
			String msg = exceptionHandler.prepareResponse();
			if (msg == null) {
				return badRequest();
			}
			return ok(msg);
		}
		catch(Exception ex) {
			return badRequest();
		}
	}
	
	public static Result getByCategory(Long id, Long offset, Integer limit) {
		response().setContentType("application/json");

		ArticlesResponse response = new ArticlesResponse();
		
		try {

			if (offset < 0 || limit < 0) {
				throw new ValidationException();
			}
			
			limit = Math.max(limit, 10);
			offset = Math.max(offset, 0);
			
			PagingList<ArticleView> results = models.views.ArticleView.find
									.fetch("shorts")
									.where()
									.eq("shorts.category.pkid", id)
									.orderBy("created desc")
									.findPagingList(limit);
			
			results.getFutureRowCount();
			
			Page<ArticleView> page = results.getPage(offset.intValue());

			List<ArticleView> elements = page.getList();
			List<ArticleResponse> articles = new LinkedList<ArticleResponse>();
			
			for(ArticleView article : elements) {
				articles.add(new ArticleResponse(article));
			}
			
			response.setArticles(articles);
			
			ResponseHandler<ArticlesResponse> handler = new ResponseHandler<>(response);
			return ok(handler.prepareResponse());
			
		}
		catch(LogicException ex) {
			ExceptionHandler<ArticlesResponse> exceptionHandler = new ExceptionHandler<>(ex, response);
			String msg = exceptionHandler.prepareResponse();
			if (msg == null) {
				return badRequest();
			}
			return ok(msg);
		}
		catch(Exception ex) {
			return badRequest();
		}
	}
	
	public static Result getByUser(String id, Long offset, Integer limit) {
		response().setContentType("application/json");

		ArticlesResponse response = new ArticlesResponse();
		
		try {

			if (offset < 0 || limit < 0) {
				throw new ValidationException();
			}
			
			limit = Math.max(limit, 10);
			offset = Math.max(offset, 0);
			
			PagingList<ArticleView> results = models.views.ArticleView.find
									.fetch("shorts")
									.where()
									.eq("shorts.authorFacebookId", id)
									.orderBy("created desc")
									.findPagingList(limit);
			
			results.getFutureRowCount();
			
			Page<ArticleView> page = results.getPage(offset.intValue());

			List<ArticleView> elements = page.getList();
			List<ArticleResponse> articles = new LinkedList<ArticleResponse>();
			
			for(ArticleView article : elements) {
				articles.add(new ArticleResponse(article));
			}
			
			response.setArticles(articles);
			
			ResponseHandler<ArticlesResponse> handler = new ResponseHandler<>(response);
			return ok(handler.prepareResponse());
			
		}
		catch(LogicException ex) {
			ExceptionHandler<ArticlesResponse> exceptionHandler = new ExceptionHandler<>(ex, response);
			String msg = exceptionHandler.prepareResponse();
			if (msg == null) {
				return badRequest();
			}
			return ok(msg);
		}
		catch(Exception ex) {
			return badRequest();
		}
	}
	
	/**
	 * (liczba lajkow ze wszystkich shortow artykulu * waga1)  - ( liczba godzin od datry utworzenia artykułu do teraz * waga2)
	 * 
	 * @param offset
	 * @param limit
	 * @return
	 */
	public static Result getFeed(Long offset, Integer limit) {
		response().setContentType("application/json");

		ArticlesResponse response = new ArticlesResponse();
		
		try {

			if (offset < 0 || limit < 0) {
				throw new ValidationException();
			}
			
			limit = Math.max(limit, 10);
			offset = Math.max(offset, 0);
			
			PagingList<ArticleView> results = models.views.ArticleView.find
									.fetch("shorts")
									.where()
									.orderBy("factor desc")
									.findPagingList(limit);
			
			results.getFutureRowCount();
			
			Page<ArticleView> page = results.getPage(offset.intValue());

			List<ArticleView> elements = page.getList();
			List<ArticleResponse> articles = new LinkedList<ArticleResponse>();
			
			for(ArticleView article : elements) {
				articles.add(new ArticleResponse(article));
			}
			
			response.setArticles(articles);
			
			ResponseHandler<ArticlesResponse> handler = new ResponseHandler<>(response);
			return ok(handler.prepareResponse());
			
		}
		catch(LogicException ex) {
			ExceptionHandler<ArticlesResponse> exceptionHandler = new ExceptionHandler<>(ex, response);
			String msg = exceptionHandler.prepareResponse();
			if (msg == null) {
				return badRequest();
			}
			return ok(msg);
		}
		catch(Exception ex) {

			return ok(ex.getMessage());
		}
	}
	
}
