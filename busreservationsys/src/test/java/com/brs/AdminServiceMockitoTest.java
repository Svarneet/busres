package com.brs;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.brs.entity.Admin;
import com.brs.exceptions.AdminNotFoundException;
import com.brs.repository.IAdminRepository;
import com.brs.service.AdminService;

public class AdminServiceMockitoTest {
	@Mock
	IAdminRepository adminrepo;
	@InjectMocks
	AdminService adminservice;
	Admin admin;

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		admin = new Admin(143, "Deva", "Vecds");

	}

	@Test
	public void addAdminTest() {
		when(adminrepo.save(admin)).thenReturn(admin);
		Assertions.assertEquals(admin, adminservice.addAdmin(admin));
	}

	@Test
	public void updateBusTest() throws AdminNotFoundException {
		when(adminrepo.findById(admin.getAdminId())).thenReturn(Optional.of(admin));
		when(adminrepo.save(admin)).thenReturn(admin);
		Assertions.assertEquals(admin, adminservice.updateAdmin(admin));

	}

	@Test
	public void viewAdminByIdTest() throws AdminNotFoundException {
		when(adminrepo.findById(admin.getAdminId())).thenReturn(Optional.of(admin));
		Assertions.assertEquals(admin, adminservice.viewAdmin(admin.getAdminId()));
	}

	@Test
	public void deleteAdminTest() throws AdminNotFoundException {
		when(adminrepo.findById(admin.getAdminId())).thenReturn(Optional.of(admin));
		Assertions.assertEquals(admin, adminservice.deleteAdmin(admin.getAdminId()));
	}
}