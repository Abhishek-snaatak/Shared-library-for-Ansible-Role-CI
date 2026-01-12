package org.devops.ansible

class DryRunCheck {

    def run(steps, String playbook, String inventory, String rolesPath) {
        steps.sh """
        ANSIBLE_ROLES_PATH=${rolesPath} \
        ansible-playbook \
          -i ${inventory} \
          ${playbook} \
          --check --diff
        """
    }
}
