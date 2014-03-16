package logic.dto.response;

import logic.dto.response.opengraph.Audio;
import logic.dto.response.opengraph.Image;
import logic.dto.response.opengraph.Restrictions;
import logic.dto.response.opengraph.Video;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author piotr.kosiakowski
 *
 */
public class OpenGraph {

	@JsonProperty(value = "article_author", required = false)
	private String[] author;
	
	@JsonProperty(value = "article_expiration_time", required = false)
	private String expirationTime;

	@JsonProperty(value = "article_modified_time", required = false)
	private String modifiedTime;
	
	@JsonProperty(value = "article_published_time", required = false)
	private String publishedTime;
	
	@JsonProperty(value = "article_publisher", required = false)
	private String publisher;
	
	@JsonProperty(value = "article_section", required = false)
	private String section;
	
	@JsonProperty(value = "article_tag", required = false)
	private String[] tag;
	
	@JsonProperty(value = "fb_admins", required = false)
	private String[] admins;
	
	@JsonProperty(value = "fb_app_id", required = false)
	private String appId;
	
	@JsonProperty(value = "fb_profile_id", required = false)
	private String profileId;
	
	@JsonProperty(value = "og_audio", required = false)
	private Audio[] audio;

	@JsonProperty(value = "og_description", required = false)
	private String description;

	@JsonProperty(value = "og_determiner", required = false)
	private String determiner;	

	@JsonProperty(value = "og_image", required = false)
	private Image[] image;
	
	@JsonProperty(value = "og_locale", required = false)
	private String locale;
	
	@JsonProperty(value = "og_restrictions", required = false)
	private Restrictions restriction;
	
	@JsonProperty(value = "og_see_also", required = false)
	private String[] seeAlso;
	
	@JsonProperty(value = "og_site_name", required = false)
	private String siteName;
	
	@JsonProperty(value = "og_title", required = false)
	private String title;
	
	@JsonProperty(value = "og_type", required = false)
	private String type;
	
	@JsonProperty(value = "og_updated_time", required = false)
	private String updatedTime;
	
	@JsonProperty(value = "og_url", required = false)
	private String url;

	@JsonProperty(value = "og_video", required = false)
	private Video[] video;

	public String[] getAuthor() {
		return author;
	}

	public void setAuthor(String[] author) {
		this.author = author;
	}

	public String getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(String expirationTime) {
		this.expirationTime = expirationTime;
	}

	public String getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getPublishedTime() {
		return publishedTime;
	}

	public void setPublishedTime(String publishedTime) {
		this.publishedTime = publishedTime;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String[] getTag() {
		return tag;
	}

	public void setTag(String[] tag) {
		this.tag = tag;
	}

	public String[] getAdmins() {
		return admins;
	}

	public void setAdmins(String[] admins) {
		this.admins = admins;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public Audio[] getAudio() {
		return audio;
	}

	public void setAudio(Audio[] audio) {
		this.audio = audio;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDeterminer() {
		return determiner;
	}

	public void setDeterminer(String determiner) {
		this.determiner = determiner;
	}

	public Image[] getImage() {
		return image;
	}

	public void setImage(Image[] image) {
		this.image = image;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public Restrictions getRestriction() {
		return restriction;
	}

	public void setRestriction(Restrictions restriction) {
		this.restriction = restriction;
	}

	public String[] getSeeAlso() {
		return seeAlso;
	}

	public void setSeeAlso(String[] seeAlso) {
		this.seeAlso = seeAlso;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Video[] getVideo() {
		return video;
	}

	public void setVideo(Video[] video) {
		this.video = video;
	}

}
