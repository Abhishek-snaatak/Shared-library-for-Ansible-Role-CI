package org.devops.ansible

class SyntaxCheck {

    def run(steps, String inventory, String playbook, String rolesPath) {
        steps.sh """
        ANSIBLE_ROLES_PATH=${rolesPath} \
        ansible-playbook \
          -i ${inventory} \
          ${playbook} \
          --syntax-check
        """
    }
}
