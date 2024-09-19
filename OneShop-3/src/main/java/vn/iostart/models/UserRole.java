package vn.iostart.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="users_roles")

public class UserRole {
		@Id
		@Column(name="Id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@ManyToOne
		@JoinColumn(name = "userId", referencedColumnName= "id")
		private User user;
		@ManyToOne
		@JoinColumn(name ="roleld", referencedColumnName ="id")
		private Role role;
		public UserRole() {
			super();
			// TODO Auto-generated constructor stub
		}
		public UserRole(long id, User user, Role role) {
			super();
			this.id = id;
			this.user = user;
			this.role = role;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public Role getRole() {
			return role;
		}
		public void setRole(Role role) {
			this.role = role;
		}
		
		
}
