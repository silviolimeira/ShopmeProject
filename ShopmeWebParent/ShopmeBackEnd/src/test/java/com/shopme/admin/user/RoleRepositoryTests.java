package com.shopme.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopme.admin.user.RoleRepository;
import com.shopme.common.entity.Role;

//@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class RoleRepositoryTests {

	@Autowired
	private RoleRepository repo;
	
	@Test
	public void testCreateFirstRole() {
		
		Role roleAdmin = new Role("Admin", "manage everything");
		Role savedRole = repo.save(roleAdmin);
		
		assertThat(savedRole.getId()).isGreaterThan(0);
		
	}
	
	@Test
	public void testCreateRestRoles() {
		Role roleSalesPerson = new Role("SalesPerson", "manage price, customers, "
				+ "shipping, orders and sales report");
		Role roleEditor = new Role("Editor", "manage categories, brands, "
				+ "products, articles and menus");
		Role roleShipper = new Role("Shipper", "view products, view orders "
				+ "and update order status");
		Role roleAssistent = new Role("Assitent", "manage questions and reviews");
	
		repo.saveAll(List.of(roleSalesPerson, roleEditor, roleShipper, roleAssistent));
	}
	
}
