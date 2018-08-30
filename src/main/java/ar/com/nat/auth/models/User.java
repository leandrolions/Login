package ar.com.nat.auth.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "usuario",schema="frontend")
public class User {
		
	   	private Long id;
		@Column(name="USR_User")
	    private String username;
		private String name;
	    private String password;
	    private String passwordConfirm;
	    private Set<Role> roles;
	    private Date Alta;

	    private Date Baja;

	    @Id
	    @Column(name="USR_Cod")
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }
		@Column(name="USR_User")
	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }
		@Column(name="USR_Pwd")
	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    @Transient
	    public String getPasswordConfirm() {
	        return passwordConfirm;
	    }

	    public void setPasswordConfirm(String passwordConfirm) {
	        this.passwordConfirm = passwordConfirm;
	    }

	    @ManyToMany
	    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	    public Set<Role> getRoles() {
	        return roles;
	    }

	    public void setRoles(Set<Role> roles) {
	        this.roles = roles;
	    }
		@Column(name="USR_Nombre")
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	    @Column(name="USR_FBaja")
		public Date getAlta() {
			return Alta;
		}

		public void setAlta(Date alta) {
			Alta = alta;
		}
	    @Column(name="USR_FAlta")
		public Date getBaja() {
			return Baja;
		}

		public void setBaja(Date baja) {
			Baja = baja;
		}
}
