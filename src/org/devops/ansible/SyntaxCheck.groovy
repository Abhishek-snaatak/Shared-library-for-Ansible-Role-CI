package org.devops.ansible

class SyntaxCheck {

    def run(steps,
          
        steps.sh """
        ANSIBLE_ROLES_PATH=roles \
        ansible-playbook \
          -i ${inventory} \
          ${playbook} \
          --syntax-check
        """
    }
}
