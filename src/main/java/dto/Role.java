package dto;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="rol")
public class Role {

	private String roleName;
	private String id;
	private ArrayList<User> users = new ArrayList<User>();

	
	@Column(name="Rol")
	public String getRoleName() {
		return roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_rol")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "rol")
	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	
}
