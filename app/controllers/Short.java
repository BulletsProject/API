package controllers;

import java.util.Date;

import logic.common.Tools;
import logic.dto.request.RequestHandler;
import logic.dto.request.ShortRequest;
import logic.dto.response.ResponseHandler;
import logic.dto.response.ShortLikeResponse;
import logic.dto.response.ShortPostResponse;
import logic.exceptions.CategoryNotExists;
import logic.exceptions.ExceptionHandler;
import logic.exceptions.IncorrectFacebookId;
import logic.exceptions.LikeAlreadyPosted;
import logic.exceptions.LogicException;
import logic.exceptions.ShortAlreadyPosted;
import logic.exceptions.ShortNotFound;
import models.Author;
import models.Category;
import play.mvc.Controller;
import play.mvc.Result;

import com.avaje.ebean.Ebean;

public class Short extends Controller {

	public static Result like(Long id, String imei) {
		
		ShortLikeResponse response = new ShortLikeResponse();
		
		try {
		
			models.Short shortElement = models.Short.find.byId(id);
			if (shortElement == null) {
				throw new ShortNotFound();
			}
			
			int likes = 
				models.Like.find.where()
					.eq("short.pkid", id)
					.eq("deviceId", imei).findList().size();
			
			if (likes > 0) {
				throw new LikeAlreadyPosted();
			}
			
			models.Like newLike = new models.Like();
			newLike.shortElement = shortElement;
			newLike.deviceId = imei;
			newLike.created = new Date();
			
			Ebean.save(newLike);
			
			ResponseHandler<ShortLikeResponse> responseHandler = new ResponseHandler<>(response);
			return ok(responseHandler.prepareResponse());
			
		}
		catch(LogicException ex) {
			ExceptionHandler<ShortLikeResponse> exceptionHandler = new ExceptionHandler<>(ex, response);
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
	
	private static Author retrieveFacebookId(String accessToken) throws IncorrectFacebookId {
		if (false) throw new IncorrectFacebookId();
		
		Author author = new Author();
		author.email = "aaa@mailinator.com";
		author.firstName = "Jan";
		author.lastName = "Kowalski";
		author.facebookId = accessToken;
		author.created = new Date();
		
		return author;
	}
	
	public static Result post(String shortElement, String accessToken) {
		
		ShortPostResponse response = new ShortPostResponse();
		
		try {
		
			RequestHandler<ShortRequest> handler = new RequestHandler<>(ShortRequest.class);
			ShortRequest shortElem = handler.parseRequest(shortElement);
			
			String articleUrl = shortElem.getArticleUrl();
			String md5 = Tools.md5(articleUrl);
			
			Integer categoryId = shortElem.getCategoryId();
			
			Category category = Category.find.byId(categoryId.longValue());
			if (category == null) {
				throw new CategoryNotExists();
			}
			
			models.Article article = models.Article.find.where().ieq("url_hash", md5).findUnique();
			if (article == null) {
				article = new models.Article();
				article.url = articleUrl;
				article.urlHash = md5;
				article.created = new Date();
			}
			
			Author facebookAuthor = retrieveFacebookId(accessToken);
			
			Author author = models.Author.find.where().ieq("facebookId", facebookAuthor.facebookId).findUnique();
			if (author == null) {
				author = facebookAuthor;
			}
			
			if (author.pkid > 0 && article.pkid > 0) {
				int previousShorts = models.Short.find
					.where()
					.eq("author.pkid", author.pkid)
					.eq("article.pkid", article.pkid).findList().size();
				
				if (previousShorts > 0) {
					throw new ShortAlreadyPosted();
				}
			}
			
			models.Short newShort = new models.Short();
			newShort.article = article;
			newShort.author = author;
			newShort.bullet1 = shortElem.getBullets().length >= 1 ? shortElem.getBullets()[0] : null;
			newShort.bullet2 = shortElem.getBullets().length >= 2 ? shortElem.getBullets()[1] : null;
			newShort.bullet3 = shortElem.getBullets().length >= 3 ? shortElem.getBullets()[2] : null;
			newShort.bullet4 = shortElem.getBullets().length >= 4 ? shortElem.getBullets()[3] : null;
			newShort.bullet5 = shortElem.getBullets().length >= 5 ? shortElem.getBullets()[4] : null;
			newShort.category = category;
			newShort.created = new Date();
			newShort.title = shortElem.getTitle();
			
			Ebean.save(article);
			Ebean.save(author);
			Ebean.save(newShort);
			
			response.setId(newShort.pkid);
			
			ResponseHandler<ShortPostResponse> responseHandler = new ResponseHandler<>(response);
			return ok(responseHandler.prepareResponse());
			
		}
		catch(LogicException ex) {
			ExceptionHandler<ShortPostResponse> exceptionHandler = new ExceptionHandler<>(ex, response);
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
