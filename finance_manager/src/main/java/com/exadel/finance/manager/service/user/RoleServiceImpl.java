package com.exadel.finance.manager.service.user;

import com.exadel.finance.manager.model.Role;
import com.exadel.finance.manager.model.UserRoleName;
import com.exadel.finance.manager.repository.RoleRepository;
import com.exadel.finance.manager.service.AbstractEntityService;
import com.exadel.finance.manager.service.RoleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class RoleServiceImpl extends AbstractEntityService<Role> implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        super(roleRepository);
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByRoleName(UserRoleName roleName) {
        return roleRepository.findByRoleName(roleName)
                .orElseThrow(() -> new IllegalStateException("Unable to locate Role in database"));
    }
}
