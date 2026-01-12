package org.devops.ansible

class DryRunCheck {

    def run(steps, String playbook, String inventory) {
        steps.sh """
        ansible-playbook \
          -i ${inventory} \
          ${playbook} \
          --check --diff
        """
    }
}
