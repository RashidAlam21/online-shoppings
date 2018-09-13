package nt.alam.shoppingbackend.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="category")
public class CategoryBO {
	/**
	 * private fields 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private String description;
	@Column(name="image_url")
	private String imageURL;
	@Column(name="is_active")
	private boolean active=true;
	/**
	 * setter and getter method
	 * @return
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "CategoryBO [id=" + id + ", name=" + name + ", description=" + description + ", imageURL=" + imageURL
				+ ", active=" + active + "]";
	}
	
}
